package com.ust.dao;

import java.time.DayOfWeek;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ust.model.FrontOfficeBean;

public interface IFrontOfficeDao {

	public abstract void setTemplate(JdbcTemplate template);

	public abstract DayOfWeek getToday();

	public abstract List<FrontOfficeBean> getAvailableDoctor();

	public abstract List<FrontOfficeBean> getPatientDetail(int regId);

	public abstract int ageCalculation(Date s);

	// View Patient List

	public abstract List<FrontOfficeBean> viewPatientList();

	// Get patient info only By RegId(single)
	public abstract FrontOfficeBean getPatientByRegId(int regId);

	public abstract List<FrontOfficeBean> getPatient(String searchString);

	public abstract FrontOfficeBean getDoctorName(String sName);

	// Inserting Patient Details
	public abstract int savePatient(FrontOfficeBean fob);

	public abstract int updatePatient(FrontOfficeBean fob, int regId);

	//Listing today's Appointment
	public abstract List<FrontOfficeBean> appointmentList(String searchString);

	public abstract int addAppoinment(FrontOfficeBean fob);

	// update patient
	public abstract int updatePatient(FrontOfficeBean fob);

	// Listing today's Appointment
	public abstract List<FrontOfficeBean> appointmentList();

	public abstract List<FrontOfficeBean> getTodaysPatient(String searchString);

}