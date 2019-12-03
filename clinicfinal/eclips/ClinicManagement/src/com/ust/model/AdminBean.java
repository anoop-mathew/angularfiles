package com.ust.model;

import java.util.Date;

public class AdminBean {

/* cm_roleTable */
	private int roleId;
	private String roleName;

	// cm_staffTable
	private int sId;
	private String sName;
	private Date sDOB;
	private String sGender;
	private String sAddr;
	private String sExp;
	private String sPhNo;
	private String sEmail;
	private String username;
	private String password;
	private String isSActive;
	private Date sCreatedDate;

	// cm_doctorTable
	private int dId;
	private String dSpec;
	private String dQualification;
	private double consultFee;

	// cm_medicineTable
	private int medId;
	private String medName;
	private double medPrice;
	private int isMActive;
	private String manufacturer;
	private Date mCreatedDate;

	// cm_labTestTable
	private int labId;
	private String lName;
	private double lFee;
	private String description;
	
	private int consultDayId;	
	private String sunday ;
	private String monday ;
	private String tuesday ;
	private String wednesday ;
	private String thursday ;
	private String friday;
	private String saturday ;
		
	
	public int getConsultDayId() {
		return consultDayId;
	}
	public String getSunday() {
		return sunday;
	}
	public String getMonday() {
		return monday;
	}
	public String getTuesday() {
		return tuesday;
	}
	public String getWednesday() {
		return wednesday;
	}
	public String getThursday() {
		return thursday;
	}
	public String getFriday() {
		return friday;
	}
	public String getSaturday() {
		return saturday;
	}
	public void setConsultDayId(int consultDayId) {
		this.consultDayId = consultDayId;
	}
	public void setSunday(String sunday) {
		this.sunday = sunday;
	}
	public void setMonday(String monday) {
		this.monday = monday;
	}
	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}
	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}
	public void setThursday(String thursday) {
		this.thursday = thursday;
	}
	public void setFriday(String friday) {
		this.friday = friday;
	}
	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}
	public int getRoleId() {
		return roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public int getsId() {
		return sId;
	}
	public String getsName() {
		return sName;
	}
	public Date getsDOB() {
		return sDOB;
	}
	public String getsGender() {
		return sGender;
	}
	public String getsAddr() {
		return sAddr;
	}
	public String getsExp() {
		return sExp;
	}
	public String getsPhNo() {
		return sPhNo;
	}
	public String getsEmail() {
		return sEmail;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getIsSActive() {
		return isSActive;
	}
	public Date getsCreatedDate() {
		return sCreatedDate;
	}
	public int getdId() {
		return dId;
	}
	public String getdSpec() {
		return dSpec;
	}
	public String getdQualification() {
		return dQualification;
	}
	public double getConsultFee() {
		return consultFee;
	}
	public int getMedId() {
		return medId;
	}
	public String getMedName() {
		return medName;
	}
	public double getMedPrice() {
		return medPrice;
	}
	public int getIsMActive() {
		return isMActive;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public Date getmCreatedDate() {
		return mCreatedDate;
	}
	public int getLabId() {
		return labId;
	}
	public String getlName() {
		return lName;
	}
	public double getlFee() {
		return lFee;
	}
	public String getDescription() {
		return description;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public void setsDOB(Date sDOB) {
		this.sDOB = sDOB;
	}
	public void setsGender(String sGender) {
		this.sGender = sGender;
	}
	public void setsAddr(String sAddr) {
		this.sAddr = sAddr;
	}
	public void setsExp(String sExp) {
		this.sExp = sExp;
	}
	public void setsPhNo(String sPhNo) {
		this.sPhNo = sPhNo;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setIsSActive(String isSActive) {
		this.isSActive = isSActive;
	}
	public void setsCreatedDate(Date sCreatedDate) {
		this.sCreatedDate = sCreatedDate;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public void setdSpec(String dSpec) {
		this.dSpec = dSpec;
	}
	public void setdQualification(String dQualification) {
		this.dQualification = dQualification;
	}
	public void setConsultFee(double consultFee) {
		this.consultFee = consultFee;
	}
	public void setMedId(int medId) {
		this.medId = medId;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	public void setMedPrice(double medPrice) {
		this.medPrice = medPrice;
	}
	public void setIsMActive(int isMActive) {
		this.isMActive = isMActive;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public void setmCreatedDate(Date mCreatedDate) {
		this.mCreatedDate = mCreatedDate;
	}
	public void setLabId(int labId) {
		this.labId = labId;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public void setlFee(double lFee) {
		this.lFee = lFee;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "AdminBean [roleId=" + roleId + ", roleName=" + roleName
				+ ", sId=" + sId + ", sName=" + sName + ", sDOB=" + sDOB
				+ ", sGender=" + sGender + ", sAddr=" + sAddr + ", sExp="
				+ sExp + ", sPhNo=" + sPhNo + ", sEmail=" + sEmail
				+ ", username=" + username + ", password=" + password
				+ ", isSActive=" + isSActive + ", sCreatedDate=" + sCreatedDate
				+ ", dId=" + dId + ", dSpec=" + dSpec + ", dQualification="
				+ dQualification + ", consultFee=" + consultFee + ", medId="
				+ medId + ", medName=" + medName + ", medPrice=" + medPrice
				+ ", isMActive=" + isMActive + ", manufacturer=" + manufacturer
				+ ", mCreatedDate=" + mCreatedDate + ", labId=" + labId
				+ ", lName=" + lName + ", lFee=" + lFee + ", description="
				+ description + ", consultDayId=" + consultDayId + ", sunday="
				+ sunday + ", monday=" + monday + ", tuesday=" + tuesday + ", wednesday=" + wednesday
				+ ", thursday=" + thursday + ", friday=" + friday + ", saturday=" + saturday + "]";
	}
	
	
	
}