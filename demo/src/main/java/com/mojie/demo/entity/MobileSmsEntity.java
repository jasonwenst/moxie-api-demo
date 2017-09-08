package com.mojie.demo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_mobile_sms database table.
 * 
 */
@Entity
@Table(name="t_mobile_sms")
public class MobileSmsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String billmonth;

	private String code;

	private String message;

	@Lob
	private String records;

	@Column(name="total_size")
	private int totalSize;

	public MobileSmsEntity() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBillmonth() {
		return this.billmonth;
	}

	public void setBillmonth(String billmonth) {
		this.billmonth = billmonth;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRecords() {
		return this.records;
	}

	public void setRecords(String records) {
		this.records = records;
	}

	public int getTotalSize() {
		return this.totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

}