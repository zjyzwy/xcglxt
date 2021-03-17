package com.scnu.modleItem;

import java.sql.Date;

public class Payment {

	private String userID;
	private String dateTime;
	private String dutyPayment;
	private String LevelPayment;
	private String meritPayment;
	private String housingSubsidy;
	private String pay_Ret;
	private String endowmentInsurance;
	private String MedicalInsurance;
	private String cutPayment;
	private String userTax;

	public String getUserId() {
		return userID;
	}

	public void setUserId(String userId) {
		this.userID = userId;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getDutyPayment() {
		return dutyPayment;
	}

	public void setDutyPayment(String dutyPayment) {
		this.dutyPayment = dutyPayment;
	}

	public String getLevelPayment() {
		return LevelPayment;
	}

	public void setLevelPayment(String levelPayment) {
		LevelPayment = levelPayment;
	}

	public String getMeritPayment() {
		return meritPayment;
	}

	public void setMeritPayment(String meritPayment) {
		this.meritPayment = meritPayment;
	}

	public String getHousingSubsidy() {
		return housingSubsidy;
	}

	public void setHousingSubsidy(String housingSubsidy) {
		this.housingSubsidy = housingSubsidy;
	}

	public String getPayRet() {
		return pay_Ret;
	}

	public void setPayRet(String payRet) {
		this.pay_Ret = payRet;
	}

	public String getEndowmentInsurance() {
		return endowmentInsurance;
	}

	public void setEndowmentInsurance(String endowmentInsurance) {
		this.endowmentInsurance = endowmentInsurance;
	}

	public String getMedicalInsurance() {
		return MedicalInsurance;
	}

	public void setMedicalInsurance(String medicalInsurance) {
		MedicalInsurance = medicalInsurance;
	}

	public String getCutPayment() {
		return cutPayment;
	}

	public void setCutPayment(String cutPayment) {
		this.cutPayment = cutPayment;
	}

	public String getUserTax() {
		return userTax;
	}

	public void setUserTax(String userTax) {
		this.userTax = userTax;
	}

	;
}
