package com.ust.model;

import java.util.Date;

public class DoctorBean {

	// cm_roleTable
	private int roleId;
	private String roleName;

	// cm_appoinmentTable
	
	private int appId;
	private int regId;
	private int dId;
	private Date dateOfApp;
	private String consultStatus;

	// cm_doctorTable
	// private int dId;
	private String dSpec;
	private String dQualification;
	private int consultFee;

	// cm_patientTable
	// private int regId;
	private String pFName;
	private String pLName;
	private String pGender;
	private Date pDOB;
	private String pAddr;
	private String pPhNo;
	private String pBloodGrp;
	private Date pcreatedDate;

	// cm_prescriptionTable
	private int prescId;
	// private int dId;
	// private int regId;
	//private int medId;
	private String medFreq;
	private int medDays;
	private Date prescDate;
	private String pharmacyStatus;

	// cm_doctorObsTable
	private int dObsId;
	private Date obserDate;
	private String obsNotes;
	//private int regId;
	//private int dId;

	// cm_assignLabTable
	private int assignLabId;
	//private int regId;
	//private int dId;
	//private int labId;
	private Date assigLabDate;
	private String sampleStatus;
	private String testStatus;

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
	private int isSActive;
	private Date sCreatedDate;

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
	public int getRoleId() {
		return roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public int getAppId() {
		return appId;
	}
	public int getRegId() {
		return regId;
	}
	public int getdId() {
		return dId;
	}
	public Date getDateOfApp() {
		return dateOfApp;
	}
	public String getConsultStatus() {
		return consultStatus;
	}
	public String getdSpec() {
		return dSpec;
	}
	public String getdQualification() {
		return dQualification;
	}
	public int getConsultFee() {
		return consultFee;
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
	public int getPrescId() {
		return prescId;
	}
	public String getMedFreq() {
		return medFreq;
	}
	public int getMedDays() {
		return medDays;
	}
	public Date getPrescDate() {
		return prescDate;
	}
	public String getPharmacyStatus() {
		return pharmacyStatus;
	}
	public int getdObsId() {
		return dObsId;
	}
	public Date getObserDate() {
		return obserDate;
	}
	public String getObsNotes() {
		return obsNotes;
	}
	public int getAssignLabId() {
		return assignLabId;
	}
	public Date getAssigLabDate() {
		return assigLabDate;
	}
	public String getSampleStatus() {
		return sampleStatus;
	}
	public String getTestStatus() {
		return testStatus;
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
	public int getIsSActive() {
		return isSActive;
	}
	public Date getsCreatedDate() {
		return sCreatedDate;
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
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public void setRegId(int regId) {
		this.regId = regId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public void setDateOfApp(Date dateOfApp) {
		this.dateOfApp = dateOfApp;
	}
	public void setConsultStatus(String consultStatus) {
		this.consultStatus = consultStatus;
	}
	public void setdSpec(String dSpec) {
		this.dSpec = dSpec;
	}
	public void setdQualification(String dQualification) {
		this.dQualification = dQualification;
	}
	public void setConsultFee(int consultFee) {
		this.consultFee = consultFee;
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
	public void setPrescId(int prescId) {
		this.prescId = prescId;
	}
	public void setMedFreq(String medFreq) {
		this.medFreq = medFreq;
	}
	public void setMedDays(int medDays) {
		this.medDays = medDays;
	}
	public void setPrescDate(Date prescDate) {
		this.prescDate = prescDate;
	}
	public void setPharmacyStatus(String pharmacyStatus) {
		this.pharmacyStatus = pharmacyStatus;
	}
	public void setdObsId(int dObsId) {
		this.dObsId = dObsId;
	}
	public void setObserDate(Date obserDate) {
		this.obserDate = obserDate;
	}
	public void setObsNotes(String obsNotes) {
		this.obsNotes = obsNotes;
	}
	public void setAssignLabId(int assignLabId) {
		this.assignLabId = assignLabId;
	}
	public void setAssigLabDate(Date assigLabDate) {
		this.assigLabDate = assigLabDate;
	}
	public void setSampleStatus(String sampleStatus) {
		this.sampleStatus = sampleStatus;
	}
	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
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
	public void setIsSActive(int isSActive) {
		this.isSActive = isSActive;
	}
	public void setsCreatedDate(Date sCreatedDate) {
		this.sCreatedDate = sCreatedDate;
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
	@Override
	public String toString() {
		return "DoctorBean [roleId=" + roleId + ", roleName=" + roleName
				+ ", appId=" + appId + ", regId=" + regId + ", dId=" + dId
				+ ", dateOfApp=" + dateOfApp + ", consultStatus="
				+ consultStatus + ", dSpec=" + dSpec + ", dQualification="
				+ dQualification + ", consultFee=" + consultFee + ", pFName="
				+ pFName + ", pLName=" + pLName + ", pGender=" + pGender
				+ ", pDOB=" + pDOB + ", pAddr=" + pAddr + ", pPhNo=" + pPhNo
				+ ", pBloodGrp=" + pBloodGrp + ", pcreatedDate=" + pcreatedDate
				+ ", prescId=" + prescId + ", medFreq=" + medFreq
				+ ", medDays=" + medDays + ", prescDate=" + prescDate
				+ ", pharmacyStatus=" + pharmacyStatus + ", dObsId=" + dObsId
				+ ", obserDate=" + obserDate + ", obsNotes=" + obsNotes
				+ ", assignLabId=" + assignLabId + ", assigLabDate="
				+ assigLabDate + ", sampleStatus=" + sampleStatus
				+ ", testStatus=" + testStatus + ", sId=" + sId + ", sName="
				+ sName + ", sDOB=" + sDOB + ", sGender=" + sGender
				+ ", sAddr=" + sAddr + ", sExp=" + sExp + ", sPhNo=" + sPhNo
				+ ", sEmail=" + sEmail + ", username=" + username
				+ ", password=" + password + ", isSActive=" + isSActive
				+ ", sCreatedDate=" + sCreatedDate + ", medId=" + medId
				+ ", medName=" + medName + ", medPrice=" + medPrice
				+ ", isMActive=" + isMActive + ", manufacturer=" + manufacturer
				+ ", mCreatedDate=" + mCreatedDate + ", labId=" + labId
				+ ", lName=" + lName + ", lFee=" + lFee + "]";
	}
	
	
	

	/*
	 * // cm_dayTable private int dayId; private String dayName;
	 * 
	 * // cm_consultDayTable private int consultId; private int dayId; private
	 * int dId;
	 */

}

