package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.model.DoctorBean;

public class DoctorDao implements IDoctorDao {

	JdbcTemplate template;


	@Override
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
/************************************ Lab ********************************************/
	
	//To show the list of test 
	
	@Override
	public Integer doc_getLabId(String labName) {
		String sql = "select labId from cm_labTestTable where lName=?";
		return template.queryForObject(sql, new Object[] { labName },
				Integer.class);
	}



	//Getting LabId by Using the lab Name 
	@Override
	public Integer d_getLabId(String lName) {
		String sql = "select labId from cm_labTestTable where lName =?";
		return template.queryForObject(sql, new Object[] { lName },
				Integer.class);

	}

	// add lab request
	
	@Override
	public int saveDoctorLabPrescription(DoctorBean doc) {

		Integer labId = d_getLabId(doc.getlName());
		String sql = "insert into cm_assignLabTable(assigLabDate,regId,dId,labId)values(TO_DATE('"
				+ java.time.LocalDate.now()
				+ "','YYYY-MM-DD'),"
				+ doc.getRegId() + "," + doc.getdId() + "," + labId + ")";
		return template.update(sql);
	}
	
	
	//Listing the Lab Test Available
	
		@Override
		public List<DoctorBean> lablist() {
			return template.query("select labId ,lName from cm_labTestTable",
					new RowMapper<DoctorBean>() {
						public DoctorBean mapRow(ResultSet rs, int row)
								throws SQLException {
							DoctorBean db = new DoctorBean();
							db.setLabId(rs.getInt(1));
							db.setlName(rs.getString(2));
							return db;
						}
					});
		}

		
		//Get All Lab Prescription
		
		@Override
		public List<DoctorBean> getAllLabPrescription(int dId, int regId) {
			return template
					.query("select labId,lName,assignLabId from cm_assignLabTable join cm_LabTestTable using(labId) join cm_doctorTable using (dId) where trunc(assigLabDate) = trunc(sysdate)and regId="
							+ regId + " and dId=" + dId + "",
							new RowMapper<DoctorBean>() {
								public DoctorBean mapRow(ResultSet rs, int row)
										throws SQLException {
									DoctorBean db = new DoctorBean();

									db.setLabId(rs.getInt(1));
									db.setlName(rs.getString(2));
									db.setAssignLabId(rs.getInt(3));

									return db;
								}
							});
		}

		
		//Patient Lab History
		
		@Override
		public List<DoctorBean> lablistHistory(int regId) {
			return template
					.query("select labId,lName from cm_assignLabTable join cm_LabTestTable using(labId) where regId ="
							+ regId + "", new RowMapper<DoctorBean>() {
						public DoctorBean mapRow(ResultSet rs, int row)
								throws SQLException {
							DoctorBean db = new DoctorBean();
							db.setLabId(rs.getInt(1));
							db.setlName(rs.getString(2));
							return db;
						}
					});
		}


		// Delete Lab Request

		@Override
		public int deleteLab(int id) {
			System.out.println(id);
			String sql = "delete from cm_assignLabTable where assignlabId=" + id
					+ "";
			return template.update(sql);
		}

		
		
	
/****************************************  MEDICINE  ********************************/

	//Get Medicine Id by using the Medicine Name
	
	@Override
	public int getMedicineId(String mName) {
		String sql = "select medId from cm_medicineTable where medName = ?";
		return template.queryForObject(sql, new Object[] { mName },
				Integer.class);

	}

	
	//Medicine List 
	
		@Override
		public List<DoctorBean> medicinelist() {
			return template.query("select medId ,medName from cm_MedicineTable",
					new RowMapper<DoctorBean>() {
						public DoctorBean mapRow(ResultSet rs, int row)
								throws SQLException {
							DoctorBean db = new DoctorBean();
							db.setMedId(rs.getInt(1));
							db.setMedName(rs.getString(2));
							return db;
						}
					});
		}

		//Remove patient Medicine 
		
		@Override
		public int removemedicine(int medId) {
			String sql = "delete from cm_medicineTable where medId = " + medId + "";
			return template.update(sql);

		}

	
		//Patient Medicine History 
		
		@Override
		public List<DoctorBean> medicinehist(int regId) {
			return template
					.query("select prescId,medName,prescDate from cm_PrescriptionTable join cm_MedicineTable using(medId) where regId ="
							+ regId
							+ "order by cm_PrescriptionTable.prescDate desc",
							new RowMapper<DoctorBean>() {
								public DoctorBean mapRow(ResultSet rs, int row)
										throws SQLException {
									DoctorBean db = new DoctorBean();
									db.setPrescId(rs.getInt(1));
									db.setMedName(rs.getString(2));
									db.setPrescDate(rs.getDate(3));
									return db;
								}
							});
		}

		// Doctor medicine request

		@Override
		public Integer d_getMedicineId(String medName) {
			String sql = "select medId from cm_medicineTable where medName = ?";
			return template.queryForObject(sql, new Object[] { medName },
					Integer.class);

		}
		
		// Delete Medicine Request

		@Override
		public int delete(int id) {
			String sql = "delete from cm_prescriptionTable where prescId=" + id
					+ "";
			return template.update(sql);
		}

		
/******************************************   DOCTOR   ******************************/
	
	
	//change consult status
	public void disableAppoinment(int regId,int dId)
	{
		String sql ="update cm_appoinmentTable set consultStatus='yes' where regId=? and did=? and trunc(dateOfApp)=trunc(sysdate)";
		template.update(sql,new Object[]{regId,dId});
		
	}


 //Add Patient Comments
	
	@Override
	public int addPatientComments(DoctorBean doc_bean) {

		String sql = "insert into cm_doctorObsTable(obserDate,obsNotes,regId,dId)values(TO_DATE('"
				+ java.time.LocalDate.now()
				+ "', 'YYYY-MM-DD'),'"
				+ doc_bean.getObsNotes()
				+ "',"
				+ doc_bean.getRegId()
				+ ","
				+ doc_bean.getdId() + ")";

		return template.update(sql);
	}

	
	

	
	//Patient Observation History
	
	@Override
	public List<DoctorBean> ObslistHistory(int regId) {
		return template
				.query("select cm_doctorObsTable.obsnotes,cm_doctorObsTable.obserdate,cm_StaffTable.sName from cm_doctorObsTable join cm_doctorTable on(cm_doctorObsTable.dId = cm_doctorTable.dId) join cm_StaffTable on(cm_doctorTable.sId = cm_StaffTable.sId)where regId ="
						+ regId + " order by cm_doctorObsTable.obserdate desc",
						new RowMapper<DoctorBean>() {
							public DoctorBean mapRow(ResultSet rs, int row)
									throws SQLException {
								DoctorBean db = new DoctorBean();
								db.setObsNotes(rs.getString(1));
								db.setObserDate(rs.getDate(2));
								db.setsName(rs.getString(3));
								return db;
							}
						});
	}

	
	

	//Save Doctor Prescripation
	
	@Override
	public int saveDoctorPrescription(DoctorBean doc) {
		System.out.println(doc.getdId());
		System.out.println(doc.getRegId());
		System.out.println(doc.getMedFreq());
		System.out.println(doc.getMedDays());
		Integer medId = d_getMedicineId(doc.getMedName());
		String sql = "insert into cm_prescriptionTable(dId,regId,medId,medFreq,medDays,prescDate,pharmacyStatus) values("
				+ doc.getdId()
				+ ", "
				+ doc.getRegId()
				+ ",?,'"
				+ doc.getMedFreq()
				+ "',"
				+ doc.getMedDays()
				+ ",TO_DATE('"
				+ java.time.LocalDate.now() + "', 'YYYY-MM-DD'),'no')";
		int status = template.update(sql, new Object[] { medId });
		if(status!=0){
			disableAppoinment(doc.getRegId(),doc.getdId());
		}
		return status;
	}

	//Get All Prescription
	
	@Override
	public List<DoctorBean> getAllPrescription(int dId, int regId) {
		return template
				.query("select p.prescId,p.dId,p.regId,p.prescdate,p.medDays , p.medFreq ,m.medName from cm_prescriptiontable p join cm_medicineTable m on p.medid=m.medid where trunc(prescdate) = trunc(sysdate) and p.regId = "
						+ regId + " and p.dId= " + dId + "",

				new RowMapper<DoctorBean>() {
					public DoctorBean mapRow(ResultSet rs, int row)
							throws SQLException {
						DoctorBean db = new DoctorBean();
						db.setPrescId(rs.getInt(1));
						db.setdId(rs.getInt(2));
						db.setRegId(rs.getInt(3));
						db.setPrescDate(rs.getDate(4));
						db.setMedDays(rs.getInt(5));
						db.setMedFreq(rs.getString(6));
						db.setMedName(rs.getString(7));
						return db;
					}
				});
	}



	// search PatientAppointment by patient name
	
	@Override
	public List<DoctorBean> getSearchAppointment(String searchString, int dId) {
		System.out.println(java.time.LocalDate.now());
		return template
				.query("select appId,regId,pFName,pLName,dId,consultStatus,dateOfApp from cm_AppoinmentTable join cm_PatientTable using(regId) where pFName like '"
						+ searchString
						+ "%' and dateOfApp = TO_DATE('"
						+ java.time.LocalDate.now()
						+ "' ,'YYYY-MM-DD') and dId =" + dId + " ",
						new RowMapper<DoctorBean>() {
							public DoctorBean mapRow(ResultSet rs, int row)
									throws SQLException {

								DoctorBean ap = new DoctorBean();
								ap.setAppId(rs.getInt(1));
								ap.setRegId(rs.getInt(2));
								ap.setpFName(rs.getString(3));
								ap.setpLName(rs.getString(4));
								ap.setdId(rs.getInt(5));
								ap.setConsultStatus(rs.getString(6));
								ap.setDateOfApp(rs.getDate(7));

								return ap;
							}
						});

	}

	//Getting Doctors Completed Appointment
	
	@Override
	public List<DoctorBean> getDoctorsCompletedAppointment(int dId) {
		return template
				.query("select appId,regId,pFName,pLName,pGender,consultStatus from cm_PatientTable join cm_AppoinmentTable using(regId) where dId = "
						+ dId
						+ " and dateOfApp = TO_DATE('"
						+ java.time.LocalDate.now()
						+ "' ,'YYYY-MM-DD') and consultStatus = 'yes'",
						new RowMapper<DoctorBean>() {
							public DoctorBean mapRow(ResultSet rs, int row)
									throws SQLException {
								DoctorBean db = new DoctorBean();
								db.setAppId(rs.getInt(1));
								db.setRegId(rs.getInt(2));
								db.setpFName(rs.getString(3));
								db.setpLName(rs.getString(4));
								db.setpGender(rs.getString(5));
								db.setConsultStatus(rs.getString(6));
								return db;
							}
						});
	}

	//Getting the Appointment of all Doctor
	
	@Override
	public List<DoctorBean> getDoctorsAnyAppointment(int dId) {
		return template
				.query("select appId,regId,pFName,pLName,pGender,consultStatus from cm_PatientTable join cm_AppoinmentTable using(regId) where dId = "
						+ dId
						+ " and dateOfApp = TO_DATE('"
						+ java.time.LocalDate.now() + "' ,'YYYY-MM-DD')",
						new RowMapper<DoctorBean>() {
							public DoctorBean mapRow(ResultSet rs, int row)
									throws SQLException {
								DoctorBean db = new DoctorBean();
								db.setAppId(rs.getInt(1));
								db.setRegId(rs.getInt(2));
								db.setpFName(rs.getString(3));
								db.setpLName(rs.getString(4));
								db.setpGender(rs.getString(5));
								db.setConsultStatus(rs.getString(6));
								return db;
							}
						});
	}

	//Getting Appointment of a single Doctor by using the dId
	
	@Override
	public List<DoctorBean> getDoctorsAppointment(int dId) {
		return template
				.query("select appId,regId,pFName,pLName,pGender,consultStatus from cm_PatientTable join cm_AppoinmentTable using(regId) where dId = "
						+ dId
						+ " and dateOfApp = TO_DATE('"
						+ java.time.LocalDate.now()
						+ "' ,'YYYY-MM-DD') and consultStatus='no'",
						new RowMapper<DoctorBean>() {
							public DoctorBean mapRow(ResultSet rs, int row)
									throws SQLException {
								DoctorBean db = new DoctorBean();
								db.setAppId(rs.getInt(1));
								db.setRegId(rs.getInt(2));
								db.setpFName(rs.getString(3));
								db.setpLName(rs.getString(4));
								db.setpGender(rs.getString(5));
								db.setConsultStatus(rs.getString(6));
								return db;
							}
						});
	}

	
	
}
