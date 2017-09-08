package com.mojie.demo.test;

import com.mojie.demo.constant.Constants;
import com.mojie.demo.entity.MobileBasicEntity;
import com.mojie.demo.repository.MobileBasicRepository;
import com.moxie.client.AuthToken;
import com.moxie.client.MoxieApiFactory;
import com.moxie.client.api.CarrierApi;
import com.moxie.client.data.carrier.Bill;
import com.moxie.client.data.carrier.BillDetail;
import com.moxie.client.data.carrier.MobileBasicV3;
import com.moxie.client.data.carrier.ShortMessageDetailV2;
import com.moxie.client.data.carrier.VoiceCallDetailList;
import com.moxie.client.task.*;

import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCarrierTask {
	
	private static final Logger logger = LoggerFactory.getLogger(TestCarrierTask.class);
	
    private MoxieApiFactory moxieApiFactory;
    
    @Autowired
    private MobileBasicRepository mobileBasicRepository;

    @Before
    public void setUp() {
        moxieApiFactory = MoxieApiFactory.builder()
                .withAuthToken(new AuthToken(Constants.APIKEY, Constants.TOKEN))
                .withBaseUrl(Constants.BASEURL)
                .build();
    }

    @After
    public void tearDown() {

    }
    
    
    /**
     * 创建taskId
     * @param carrierApi
     * @return
     * @throws IOException
     */
    private String createTask(CarrierApi carrierApi) throws IOException {
        TaskCreateReq req = TaskCreateReq.builder()
                .add(ParamName.USER_ID, "18767164531")
                .add(ParamName.ACCOUNT, "18767164531")
                .add(ParamName.PASSWORD, "268133")
                .add(ParamName.ORIGIN, "2")// “0”: moxie-sdk  “1”: moxie-h5  “2”: api(有交互,可输验证码/短信/独立密码)  “3”: api(无交互)
                .add(ParamName.REAL_NAME, "郭立青")
                .add(ParamName.ID_CARD, "330682199102221213")
                .add(ParamName.LOGIN_TYPE, "pwd")
                .build();
        String taskId = null;
        Response<TaskCreateRsp> taskCreateRspResponse = carrierApi.createTask(req).execute();
        if (taskCreateRspResponse.isSuccessful()) {
            TaskCreateRsp taskCreateRsp = taskCreateRspResponse.body();
            taskId = taskCreateRsp.getTaskId();
            System.out.println("任务创建成功. taskId: " + taskId);
        } else {
            System.out.println("任务创建失败");
            System.out.println("status:" + taskCreateRspResponse.code());
            System.out.println(taskCreateRspResponse.errorBody().string());
            System.exit(0);
        }
        
        return taskId;
    }

    /**
     * 授权taskId
     * @param carrierApi
     * @param taskId
     * @throws IOException
     */
    private void authTask(CarrierApi carrierApi, String taskId) throws IOException {
    	  //Step2 轮询状态
        long pollEndTime = System.currentTimeMillis() + 180 * 1000; //轮询最多3分钟
        while (true) {
            Response<TaskStatusRsp> taskStatusRspResponse = carrierApi.getTaskStatus(taskId).execute();
            if (taskStatusRspResponse.isSuccessful()) {
                TaskStatusRsp taskStatusRsp = taskStatusRspResponse.body();
                String description = taskStatusRsp.getDescription();
                String phase = taskStatusRsp.getPhase();
                String phaseStatus = taskStatusRsp.getPhaseStatus();
                boolean finished = taskStatusRsp.isFinished();

                System.out.println(String.format("%s [%s] - %s", phase, phaseStatus, description));

                if (phaseStatus.equals("DOING")) {
                    System.out.println("任务正在执行");
                }

                if (phaseStatus.equals("DONE_SUCC") && finished) {
                    System.out.println("任务已完成");
                    break;
                }

                if (phaseStatus.equals("DONE_FAIL") || phaseStatus.equals("DONE_TIMEOUT")) {
                    System.out.println("任务失败/超时");
                    return;
                }

                if (phaseStatus.equals("WAIT_CODE")) {
                    String inputType = taskStatusRsp.getInput().getType();
                    System.out.println("等待用户输入,类型:" + inputType);
                    if (taskStatusRsp.getInput().getType().equalsIgnoreCase("img")) {
                        System.out.println("base64在线转图片,访问 http://codebeautify.org/base64-to-image-converter");
                        System.out.println("请识别图片验证码:" + taskStatusRsp.getInput().getValue());
                    }
                    System.out.print("请输入验证码:");
                    Scanner scanner = new Scanner(System.in);
                    String result = scanner.nextLine();
                    if (result != null) {
                        UserInput input = new UserInput(result);
                        carrierApi.input(taskId, input).execute();
                    }
                }
            } 
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (System.currentTimeMillis() > pollEndTime) break;
        }
    }
    
  
    
    /**
     * 获取账单
     * @throws IOException
     */
    @Test
    public void testGetBill() throws IOException {
    	CarrierApi carrierApi = moxieApiFactory.newApi(CarrierApi.class);
    	
    	// 创建taskId
//        String taskId = createTask(carrierApi);
//        // 授权taskId
//        authTask(carrierApi, taskId);
    	
    	String taskId = "432de220-94c8-11e7-bcd7-00163e0d2629";
        
    	Map<String, String> map = new HashMap<String,String>();
    	map.put(Constants.Authorization, Constants.TOKEN);
    	map.put("task_id", taskId);
    	map.put("from_month", "2017-01");
    	map.put("to_month", "2017-09");
    	
    	Response<BillDetail> call = carrierApi.getBills("18767164531", map).execute();
    	for(Bill bill : call.body().getBills()) {
    		logger.info(bill.toString());
    	}
    }
    
    /**
     * 获取基本记录
     * @throws IOException
     */
    @Test
    public void testGetBasic() throws IOException {
    	CarrierApi carrierApi = moxieApiFactory.newApi(CarrierApi.class);
    	
    	// 创建taskId
//        String taskId = createTask(carrierApi);
//        // 授权taskId
//        authTask(carrierApi, taskId);
    	
    	String taskId = "432de220-94c8-11e7-bcd7-00163e0d2629";
        
    	
    	Response<MobileBasicV3> call = carrierApi.getMobileBasic("18767164531", taskId).execute();
    	
    	MobileBasicEntity entity = new MobileBasicEntity();
    	BeanUtils.copyProperties( call.body(),entity);
    	mobileBasicRepository.save(entity);
    	
    	logger.info(call.body().toString());
    }
    
    /**
     * 获取通话详单
     * @throws IOException
     */
    @Test
    public void testGetCallDetail() throws IOException {
    	CarrierApi carrierApi = moxieApiFactory.newApi(CarrierApi.class);
    	
    	// 创建taskId
//        String taskId = createTask(carrierApi);
//        // 授权taskId
//        authTask(carrierApi, taskId);
    	
    	String taskId = "432de220-94c8-11e7-bcd7-00163e0d2629";
    	
    	Map<String, String> map = new HashMap<String,String>();
    	map.put(Constants.Authorization, Constants.TOKEN);
    	map.put("task_id", taskId);
    	map.put("from_month", "2017-01");
    	map.put("to_month", "2017-09");
        
    	Response<VoiceCallDetailList> voiceList = carrierApi.getVoiceCalls("18767164531", map).execute();
    	
    	
    	logger.info(voiceList.body().toString());
    }
    
    
    /**
     * 获取短信详单
     * @throws IOException
     */
    @Test
    public void testGetSmsDetail() throws IOException {
    	CarrierApi carrierApi = moxieApiFactory.newApi(CarrierApi.class);
    	
    	// 创建taskId
//        String taskId = createTask(carrierApi);
//        // 授权taskId
//        authTask(carrierApi, taskId);
    	
    	String taskId = "432de220-94c8-11e7-bcd7-00163e0d2629";
    	
    	Map<String, String> map = new HashMap<String,String>();
    	map.put(Constants.Authorization, Constants.TOKEN);
    	map.put("task_id", taskId);
    	map.put("from_month", "2017-01");
    	map.put("to_month", "2017-09");
        
    	Response<ShortMessageDetailV2> smsDtlList = carrierApi.getShortMessages("18767164531", map).execute();
    	
    	logger.info(smsDtlList.body().toString());
    	
    	
    }
    
}
