package com.mojie.demo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_mobile_call database table.
 * 
 */
@Entity
@Table(name="t_mobile_call")
public class MobileCallEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String billmonth;

	@Lob
	private String calls;

	private String code;

	private String message;

	private String mobile;

	@Column(name="total_size")
	private int totalSize;

	public MobileCallEntity() {
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

	public String getCalls() {
		return this.calls;
	}

	public void setCalls(String calls) {
		this.calls = calls;
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

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getTotalSize() {
		return this.totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

}