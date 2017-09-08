package com.mojie.demo.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_mobile_bill database table.
 * 
 */
@Entity
@Table(name="t_mobile_bill")
public class MobileBillEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="actual_fee")
	private int actualFee;

	@Column(name="base_fee")
	private int baseFee;

	@Column(name="bill_end_date")
	private String billEndDate;

	@Column(name="bill_month")
	private String billMonth;

	@Column(name="bill_start_date")
	private String billStartDate;

	private String code;

	private int discount;

	@Column(name="extra_discount")
	private int extraDiscount;

	@Column(name="extra_fee")
	private int extraFee;

	@Column(name="extra_service_fee")
	private int extraServiceFee;

	@Column(name="last_point")
	private int lastPoint;

	private String message;

	private int notes;

	@Column(name="paid_fee")
	private int paidFee;

	private int point;

	@Column(name="related_mobiles")
	private String relatedMobiles;

	@Column(name="sms_fee")
	private int smsFee;

	@Column(name="total_fee")
	private int totalFee;

	@Column(name="unpaid_fee")
	private int unpaidFee;

	@Column(name="voice_fee")
	private int voiceFee;

	@Column(name="web_fee")
	private int webFee;

	public MobileBillEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getActualFee() {
		return this.actualFee;
	}

	public void setActualFee(int actualFee) {
		this.actualFee = actualFee;
	}

	public int getBaseFee() {
		return this.baseFee;
	}

	public void setBaseFee(int baseFee) {
		this.baseFee = baseFee;
	}

	public String getBillEndDate() {
		return this.billEndDate;
	}

	public void setBillEndDate(String billEndDate) {
		this.billEndDate = billEndDate;
	}

	public String getBillMonth() {
		return this.billMonth;
	}

	public void setBillMonth(String billMonth) {
		this.billMonth = billMonth;
	}

	public String getBillStartDate() {
		return this.billStartDate;
	}

	public void setBillStartDate(String billStartDate) {
		this.billStartDate = billStartDate;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getDiscount() {
		return this.discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getExtraDiscount() {
		return this.extraDiscount;
	}

	public void setExtraDiscount(int extraDiscount) {
		this.extraDiscount = extraDiscount;
	}

	public int getExtraFee() {
		return this.extraFee;
	}

	public void setExtraFee(int extraFee) {
		this.extraFee = extraFee;
	}

	public int getExtraServiceFee() {
		return this.extraServiceFee;
	}

	public void setExtraServiceFee(int extraServiceFee) {
		this.extraServiceFee = extraServiceFee;
	}

	public int getLastPoint() {
		return this.lastPoint;
	}

	public void setLastPoint(int lastPoint) {
		this.lastPoint = lastPoint;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getNotes() {
		return this.notes;
	}

	public void setNotes(int notes) {
		this.notes = notes;
	}

	public int getPaidFee() {
		return this.paidFee;
	}

	public void setPaidFee(int paidFee) {
		this.paidFee = paidFee;
	}

	public int getPoint() {
		return this.point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getRelatedMobiles() {
		return this.relatedMobiles;
	}

	public void setRelatedMobiles(String relatedMobiles) {
		this.relatedMobiles = relatedMobiles;
	}

	public int getSmsFee() {
		return this.smsFee;
	}

	public void setSmsFee(int smsFee) {
		this.smsFee = smsFee;
	}

	public int getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}

	public int getUnpaidFee() {
		return this.unpaidFee;
	}

	public void setUnpaidFee(int unpaidFee) {
		this.unpaidFee = unpaidFee;
	}

	public int getVoiceFee() {
		return this.voiceFee;
	}

	public void setVoiceFee(int voiceFee) {
		this.voiceFee = voiceFee;
	}

	public int getWebFee() {
		return this.webFee;
	}

	public void setWebFee(int webFee) {
		this.webFee = webFee;
	}

}