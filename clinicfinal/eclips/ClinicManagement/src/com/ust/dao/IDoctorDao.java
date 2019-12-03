package com.ust.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ust.model.DoctorBean;

public interface IDoctorDao {

	public abstract void setTemplate(JdbcTemplate template);

	public abstract Integer doc_getLabId(String labName);


	public abstract Integer d_getLabId(String lName);

	// add lab request
	public abstract int saveDoctorLabPrescription(DoctorBean doc);

	public abstract int getMedicineId(String mName);


	public abstract int addPatientComments(DoctorBean doc_bean);

	public abstract List<DoctorBean> lablist();

	public abstract List<DoctorBean> getAllLabPrescription(int dId, int regId);

	public abstract List<DoctorBean> medicinelist();

	public abstract int removemedicine(int medId);

	public abstract List<DoctorBean> lablistHistory(int regId);

	public abstract List<DoctorBean> medicinehist(int regId);

	public abstract List<DoctorBean> ObslistHistory(int regId);

	public abstract Integer d_getMedicineId(String medName);

	public abstract int saveDoctorPrescription(DoctorBean doc);

	public abstract List<DoctorBean> getAllPrescription(int dId, int regId);

	// search PatientAppointment by patient name
	public abstract List<DoctorBean> getSearchAppointment(String searchString,
			int dId);

	//status
	public abstract List<DoctorBean> getDoctorsCompletedAppointment(int dId);

	public abstract List<DoctorBean> getDoctorsAnyAppointment(int dId);

	public abstract List<DoctorBean> getDoctorsAppointment(int dId);

	public abstract int delete(int id);

	public abstract int deleteLab(int id);

}