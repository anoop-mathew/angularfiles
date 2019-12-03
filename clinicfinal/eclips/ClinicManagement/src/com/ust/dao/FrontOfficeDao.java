package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.model.AdminBean;
import com.ust.model.FrontOfficeBean;

public class FrontOfficeDao implements IFrontOfficeDao {
	
	JdbcTemplate template;
	
	
	@Override
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	@Override
	public DayOfWeek getToday(){
		LocalDate date=LocalDate.now();
		DayOfWeek now=date.getDayOfWeek();
		return now;
	}
	
	//Get Available doctor List
	
	@Override
	public List<FrontOfficeBean> getAvailableDoctor(){
		DayOfWeek today=getToday();
		
		String sql="select sName,cm_consultDaysTable.dId from cm_doctorTable join cm_staffTable on cm_doctorTable.sId=cm_staffTable.sId join cm_consultDaysTable on cm_consultDaysTable.dId=cm_doctorTable.dId where "+today+"='true' and isActive='yes'";
		
		return template.query(sql,
				new RowMapper<FrontOfficeBean>(){
			
				public FrontOfficeBean mapRow(ResultSet rs,int row) throws SQLException{
					FrontOfficeBean fb_bean=new FrontOfficeBean();
					fb_bean.setsName(rs.getString(1));
					fb_bean.setdId(rs.getInt(2));
					return fb_bean;
				}
		});
	}
	
// Getting patient Details by passing RegId
	
@Override
public List<FrontOfficeBean> getPatientDetail(int regId) {	
		
	return template
			.query("select regId,pFName,pLName,pGender,dob,pAddr,pPhNo,pBloodGrp,createdDate from cm_patientTable where regId="+regId+"",
					new RowMapper<FrontOfficeBean>() {

						public FrontOfficeBean mapRow(ResultSet rs, int row)
								throws SQLException {
							FrontOfficeBean fob = new FrontOfficeBean();

							fob.setRegId(rs.getInt(1));
							fob.setpFName(rs.getString(2));
							fob.setpLName(rs.getString(3));
							fob.setpGender(rs.getString(4));
							fob.setpDOB(rs.getDate(5));
							fob.setpAddr(rs.getString(6));
							fob.setpPhNo(rs.getString(7));
							fob.setpBloodGrp(rs.getString(8));
							fob.setPcreatedDate(rs.getDate(9));
							fob.setAge(ageCalculation(fob.getpDOB()));
							return fob;
						}
					});
	
	}
	
//Age Calculation

public int ageCalculation(Date s) {
		
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String sqlDate = ft.format(s);
		String s3=sqlDate.substring(0,4);
		int now1=Integer.parseInt(s3);
		
		int now2 = s.getMonth();
		
		int now3 = s.getDate();
		
		LocalDate l = LocalDate.of(now1,now2,now3);
		LocalDate now4 = LocalDate.now(); //gets localDate
		Period diff = Period.between(l, now4); //difference between the dates is calculated
		int age = diff.getYears();
		return age;
		
	}


	// View Patient List

	@Override
	public List<FrontOfficeBean> viewPatientList() {
		return template
				.query("select regId,pFName,pLName,pGender,dob,pAddr,pPhNo,pBloodGrp,createdDate from cm_patientTable",
						new RowMapper<FrontOfficeBean>() {

							public FrontOfficeBean mapRow(ResultSet rs, int row)
									throws SQLException {
								FrontOfficeBean fob = new FrontOfficeBean();

								fob.setRegId(rs.getInt(1));
								fob.setpFName(rs.getString(2));
								fob.setpLName(rs.getString(3));
								fob.setpGender(rs.getString(4));
								fob.setpDOB(rs.getDate(5));
								fob.setpAddr(rs.getString(6));
								fob.setpPhNo(rs.getString(7));
								fob.setpBloodGrp(rs.getString(8));
								fob.setPcreatedDate(rs.getDate(9));
							    //fob.setAge(ageCalculation(fob.getpDOB()));
								return fob;
							}
						});
	}
	
	
	// Get patient info only By RegId(single)
		
		@Override
		public FrontOfficeBean getPatientByRegId(int regId) {
		String sql = "select regId,pFName,pLName,pGender,DOB,pAddr,pPhNo,pBloodGrp,createdDate from cm_patientTable where regId=?";
		return template.queryForObject(sql, new Object[] { regId },
		new BeanPropertyRowMapper<FrontOfficeBean>(
		FrontOfficeBean.class));
		}
		
	
	
	//Search Patient Details
		
	@Override
	public List<FrontOfficeBean> getPatient(String searchString) {
		return template
				.query("select regId,pFName,pLName,pGender,DOB,pAddr,pPhNo,pBloodGrp,createdDate from cm_patientTable where  regId like '"
						+ searchString + "%' or pPhNo like '" + searchString + "%'",
						new RowMapper<FrontOfficeBean>() {
							public FrontOfficeBean mapRow(ResultSet rs, int row)
									throws SQLException {

								FrontOfficeBean adm = new FrontOfficeBean();
								adm.setRegId(rs.getInt(1));
								adm.setpFName(rs.getString(2));
								adm.setpLName(rs.getString(3));
								adm.setpGender(rs.getString(4));
								adm.setpDOB(rs.getDate(5));
								adm.setpAddr(rs.getString(6));
								adm.setpPhNo(rs.getString(7));
								adm.setpBloodGrp(rs.getString(8));
								adm.setPcreatedDate(rs.getDate(9));

								return adm;
							}
						});

	}
	 
	//Listing Doctor Name 
	
	@Override
	public FrontOfficeBean getDoctorName(String sName) {
			FrontOfficeBean ab;
			String sql = "select cm_doctorTable.dId,cm_staffTable.sName,cm_doctorTable.dSpec,cm_doctorTable.consultFee,cm_staffTable.sPhNo from cm_doctorTable join cm_staffTable on  cm_doctorTable.sId= cm_staffTable.sId where sName = ? and cm_staffTable.isActive='yes'";
			ab= template.queryForObject(sql, new Object[] { sName },
					new BeanPropertyRowMapper<FrontOfficeBean>(FrontOfficeBean.class));
			
			String sql2="select DOB from cm_stafftable where sname='"+sName+"'";
			ab.setsDOB(template.queryForObject(sql2, Date.class));
			return ab;
			
		}
	

	// Inserting Patient Details
	
	@Override
	public int savePatient(FrontOfficeBean fob) {

		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String sqlDate = ft.format(fob.getpDOB());
		String sql1 = "insert into cm_patientTable(pFName,pLName,pGender,DOB,pAddr,pPhNo,pBloodGrp,createdDate) values('"
				+ fob.getpFName()
				+ "','"
				+ fob.getpLName()
				+ "','"
				+ fob.getpGender()
				+ "',"
				+ "TO_DATE('"
				+ sqlDate
				+ "','yyyy-MM-dd')"
				+ ",'"
				+ fob.getpAddr()
				+ "','"
				+ fob.getpPhNo()
				+ "','"
				+ fob.getpBloodGrp()
				+ "',"
				+ "TO_DATE('" + java.time.LocalDate.now() + "','yyyy/mm/dd'))";
		return template.update(sql1);

	}

 
	
	//Update Patient Details
	
	@Override
	public int updatePatient(FrontOfficeBean fob,int regId) {

		String sql = "select regId,pFName,pLName,pGender,DOB,pBloodGrp from cm_patientTable where regId=?";
		template.queryForObject(sql, new Object[] { regId },
				new BeanPropertyRowMapper<FrontOfficeBean>(
						FrontOfficeBean.class));
		
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String sqlDate = ft.format(fob.getpDOB());
		String sql1 = "update cm_patientTable set pFName='" + fob.getpFName()
				+ "',pLName='" + fob.getpLName() + "',pGender='"
				+ fob.getpGender() + "',DOB= TO_DATE('" + sqlDate
				+ "' ,'yyyy-MM-dd'),pAddr='" + fob.getpAddr() + "',pPhNo='"
				+ fob.getpPhNo() + "',pBloodGrp='" + fob.getpBloodGrp()
				+ "' where regId=" + regId + "";
		return template.update(sql1);
	}

	
	//Listing today's Appointment By Search
	
	@Override
	public List<FrontOfficeBean> appointmentList(String searchString) {
		return template
				.query("select regId,pFName,pGender,appId,dId,sName from cm_patientTable join cm_appoinmentTable using (regId) join cm_doctorTable using (dId) join  cm_staffTable using (sId) where dateOfApp='"
						+ searchString + "'", new RowMapper<FrontOfficeBean>() {

					public FrontOfficeBean mapRow(ResultSet rs, int row)
							throws SQLException {
						// TODO Auto-generated method stub
						FrontOfficeBean fob = new FrontOfficeBean();
						fob.setRegId(rs.getInt(1));
						fob.setpFName(rs.getString(2));
						fob.setpGender(rs.getString(3));
						fob.setAppId(rs.getInt(4));
						fob.setdId(rs.getInt(5));
						fob.setsName(rs.getString(6));

						return fob;
					}

				});

	}
	
	//Add Appoinment
	
	@Override
	public int addAppoinment(FrontOfficeBean fob){
		
		String sql="insert into cm_appoinmentTable(regId,dId,dateOfApp,consultStatus) values("+fob.getRegId()+","+fob.getdId()+",TO_DATE('"+java.time.LocalDate.now()+"','yyyy-mm-dd'),'no')";
		return template.update(sql);
	}
	
	
	// update patient
		
		@Override
		public int updatePatient(FrontOfficeBean fob) {

			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			String sqlDate = ft.format(fob.getpDOB());
			String sql = "update cm_patientTable set pFName='" + fob.getpFName()
					+ "',pLName='" + fob.getpLName() + "',pGender='"
					+ fob.getpGender() + "',DOB= TO_DATE('" + sqlDate
					+ "' ,'yyyy-MM-dd'),pAddr='" + fob.getpAddr() + "',pPhNo='"
					+ fob.getpPhNo() + "',pBloodGrp='" + fob.getpBloodGrp()
					+ "' where regId=" + fob.getRegId() + "";
			return template.update(sql);
		}
		
		// Listing today's Appointment
		
		@Override
		public List<FrontOfficeBean> appointmentList() {
			return template
					.query("select regId,pFName,pLName,pGender,appId,dId,sName from cm_patientTable join cm_appoinmentTable using (regId) join cm_doctorTable using (dId) join  cm_staffTable using (sId) where trunc(dateOfApp)=trunc(sysdate)",
							new RowMapper<FrontOfficeBean>() {

								public FrontOfficeBean mapRow(ResultSet rs, int row)
										throws SQLException {
									// TODO Auto-generated method stub
									FrontOfficeBean fob = new FrontOfficeBean();
									fob.setRegId(rs.getInt(1));
									fob.setpFName(rs.getString(2));
									fob.setpLName(rs.getString(3));
									fob.setpGender(rs.getString(4));
									fob.setAppId(rs.getInt(5));
									fob.setdId(rs.getInt(6));
									fob.setsName(rs.getString(7));
									return fob;
								}
							});
		}

		// Todays appointment search

		@Override
		public List<FrontOfficeBean> getTodaysPatient(String searchString) {
			return template
					.query("select regId,pFName,sName from cm_patientTable join cm_appoinmentTable using(regId) join cm_doctorTable using(dId) join cm_staffTable on(cm_doctorTable.sId=cm_staffTable.sId) where trunc(dateOfApp)=trunc(sysdate) and regId like '"
							+ searchString
							+ "%' or pFName like '"
							+ searchString
							+ "%' or sName like '" + searchString + "%'",
							new RowMapper<FrontOfficeBean>() {
								public FrontOfficeBean mapRow(ResultSet rs, int row)
										throws SQLException {

									FrontOfficeBean adm = new FrontOfficeBean();
									adm.setRegId(rs.getInt(1));
									adm.setpFName(rs.getString(2));
									adm.setsName(rs.getString(3));
									System.out.println(adm);
									return adm;
								}
							});

		}
		
		
}
