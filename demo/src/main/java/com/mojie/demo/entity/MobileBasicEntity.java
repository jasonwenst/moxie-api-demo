package com.mojie.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the t_mobile_basic database table.
 * 
 */
@Entity
@Table(name="t_mobile_basic")
public class MobileBasicEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="available_balance")
	private int availableBalance;

	private String carrier;

	private String city;

	@Lob
	private String families;

	private String idcard;

	@Column(name="last_modify_time")
	private Timestamp lastModifyTime;

	private String level;

	private String mobile;

	private String name;

	@Column(name="open_time")
	private Timestamp openTime;

	@Column(name="package_name")
	private String packageName;

	@Lob
	private String packages;

	private String province;

	@Lob
	private String recharges;

	private int state;

	public MobileBasicEntity() {
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getAvailableBalance() {
		return this.availableBalance;
	}

	public void setAvailableBalance(int availableBalance) {
		this.availableBalance = availableBalance;
	}

	public String getCarrier() {
		return this.carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFamilies() {
		return this.families;
	}

	public void setFamilies(String families) {
		this.families = families;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Timestamp getLastModifyTime() {
		return this.lastModifyTime;
	}

	public void setLastModifyTime(Timestamp lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getOpenTime() {
		return this.openTime;
	}

	public void setOpenTime(Timestamp openTime) {
		this.openTime = openTime;
	}

	public String getPackageName() {
		return this.packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackages() {
		return this.packages;
	}

	public void setPackages(String packages) {
		this.packages = packages;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getRecharges() {
		return this.recharges;
	}

	public void setRecharges(String recharges) {
		this.recharges = recharges;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

}