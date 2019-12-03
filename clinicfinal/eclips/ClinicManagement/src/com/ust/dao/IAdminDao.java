package com.ust.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ust.model.AdminBean;

public interface IAdminDao {

	public abstract void setTemplate(JdbcTemplate template);

	public abstract List<AdminBean> getRole();

	public abstract AdminBean verifyUserLogin(String uname, String pass);

	public abstract int insertDoctorStaff(AdminBean aBean);

	public abstract int insertDoctor(AdminBean aBean);

	public abstract int insertAvailableDays(AdminBean aBean);

	public abstract List<AdminBean> getDoctorList();

	// disable a doctor
	public abstract int disableDoctor(AdminBean ab);

	public abstract List<AdminBean> getDoctorById(int sId);

	// ///update doctor
	public abstract int updateDoctor(AdminBean aBean);

	// get did
	public abstract int getSeqDid(int sId);

	public abstract int saveMedicine(AdminBean adm_bean);

	public abstract AdminBean get(int medId);

	public abstract int updateMedicine(AdminBean adm_bean);

	public abstract int disableMedicine(AdminBean ab);

	public abstract List<AdminBean> viewMedicineList();

	/**************** INSERT STAFF ***************************/
	/* Date dob; */

	public abstract int getRoleId(String role);

	public abstract int insertStaff(AdminBean aBean);

	public abstract int updateStaff(AdminBean ab);

	public abstract List<AdminBean> list();

	// staff search by id
	public abstract AdminBean getStaffName(String sName);

	// staff search by id
	public abstract List<AdminBean> getStaffId(int sId);

	// disable a staff
	public abstract int disableStaff(AdminBean aBean);

	//search doctor by name,mobile,specialisation
	public abstract List<AdminBean> getDoctor(String searchString);

	// search medicine by medicine name
	public abstract List<AdminBean> getSearchMedicine(String searchString);

	public abstract List<AdminBean> getStaff(String searchString);

}