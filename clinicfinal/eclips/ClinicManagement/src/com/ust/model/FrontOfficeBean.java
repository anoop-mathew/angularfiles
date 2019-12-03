package com.ust.model;

import java.util.Date;

public class FrontOfficeBean {

	// Role table
	private int roleId;
	private String roleName;

	// Staff table
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
	private Date screatedDate;

	// Doctor table
	private int dId;
	private String dSpec;
	private String dQualification;
	private double consultFee;

	// Patient Table
	private int regId;
	private String pFName;
	private String pLName;
	private String pGender;
	private Date pDOB;
	private String pAddr;
	private String pPhNo;
	private String pBloodGrp;
	private Date pcreatedDate;

	// Appointment table
	private int appId;
	private Date dateOfApp;
	private String consultStatus;

	// FrontOffice Billing table
	private int fBillId;
	private Date billDate;
	private double admFee;

	private int consultDayId;	
	private String sun ;
	private String mon ;
	private String tue ;
	private String wed ;
	private String thu ;
	private String fri ;
	private String sat ;
	
	
	
	@Override
	public String toString() {
		return "FrontOfficeBean [roleId=" + roleId + ", roleName=" + roleName
				+ ", sId=" + sId + ", sName=" + sName + ", sDOB=" + sDOB
				+ ", sGender=" + sGender + ", sAddr=" + sAddr + ", sExp="
				+ sExp + ", sPhNo=" + sPhNo + ", sEmail=" + sEmail
				+ ", username=" + username + ", password=" + password
				+ ", isSActive=" + isSActive + ", screatedDate=" + screatedDate
				+ ", dId=" + dId + ", dSpec=" + dSpec + ", dQualification="
				+ dQualification + ", consultFee=" + consultFee + ", regId="
				+ regId + ", pFName=" + pFName + ", pLName=" + pLName
				+ ", pGender=" + pGender + ", DOB=" + pDOB + ", pAddr="
				+ pAddr + ", pPhNo=" + pPhNo + ", pBloodGrp=" + pBloodGrp
				+ ", pcreatedDate=" + pcreatedDate + ", appId=" + appId
				+ ", dateOfApp=" + dateOfApp + ", consultStatus="
				+ consultStatus + ", fBillId=" + fBillId + ", billDate="
				+ billDate + ", admFee=" + admFee + ", consultDayId="
				+ consultDayId + ", sun=" + sun + ", mon=" + mon + ", tue="
				+ tue + ", wed=" + wed + ", thu=" + thu + ", fri=" + fri
				+ ", sat=" + sat + ", age=" + age + "]";
	}

	public int getConsultDayId() {
		return consultDayId;
	}

	public String getSun() {
		return sun;
	}

	public String getMon() {
		return mon;
	}

	public String getTue() {
		return tue;
	}

	public String getWed() {
		return wed;
	}

	public String getThu() {
		return thu;
	}

	public String getFri() {
		return fri;
	}

	public String getSat() {
		return sat;
	}

	public void setConsultDayId(int consultDayId) {
		this.consultDayId = consultDayId;
	}

	public void setSun(String sun) {
		this.sun = sun;
	}

	public void setMon(String mon) {
		this.mon = mon;
	}

	public void setTue(String tue) {
		this.tue = tue;
	}

	public void setWed(String wed) {
		this.wed = wed;
	}

	public void setThu(String thu) {
		this.thu = thu;
	}

	public void setFri(String fri) {
		this.fri = fri;
	}

	public void setSat(String sat) {
		this.sat = sat;
	}

	private int age;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public Date getScreatedDate() {
		return screatedDate;
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

	public int getRegId() {
		return regId;
	}

	public String getpFName() {
		return pFName;
	}

	public String getpLName() {
		return pLName;
	}

	public String getpGender() {
		return pGender;
	}

	public Date getpDOB() {
		return pDOB;
	}

	public String getpAddr() {
		return pAddr;
	}

	public String getpPhNo() {
		return pPhNo;
	}

	public String getpBloodGrp() {
		return pBloodGrp;
	}

	public Date getPcreatedDate() {
		return pcreatedDate;
	}

	public int getAppId() {
		return appId;
	}

	public Date getDateOfApp() {
		return dateOfApp;
	}

	public String getConsultStatus() {
		return consultStatus;
	}

	public int getfBillId() {
		return fBillId;
	}

	public Date getBillDate() {
		return billDate;
	}

	public double getAdmFee() {
		return admFee;
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

	public void setScreatedDate(Date screatedDate) {
		this.screatedDate = screatedDate;
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

	public void setRegId(int regId) {
		this.regId = regId;
	}

	public void setpFName(String pFName) {
		this.pFName = pFName;
	}

	public void setpLName(String pLName) {
		this.pLName = pLName;
	}

	public void setpGender(String pGender) {
		this.pGender = pGender;
	}

	public void setpDOB(Date pDOB) {
		this.pDOB = pDOB;
	}

	public void setpAddr(String pAddr) {
		this.pAddr = pAddr;
	}

	public void setpPhNo(String pPhNo) {
		this.pPhNo = pPhNo;
	}

	public void setpBloodGrp(String pBloodGrp) {
		this.pBloodGrp = pBloodGrp;
	}

	public void setPcreatedDate(Date pcreatedDate) {
		this.pcreatedDate = pcreatedDate;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public void setDateOfApp(Date dateOfApp) {
		this.dateOfApp = dateOfApp;
	}

	public void setConsultStatus(String consultStatus) {
		this.consultStatus = consultStatus;
	}

	public void setfBillId(int fBillId) {
		this.fBillId = fBillId;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public void setAdmFee(double admFee) {
		this.admFee = admFee;
	}

	
	
	
	
}
