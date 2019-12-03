package com.ust.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestBody;

import com.ust.model.AdminBean;

public class AdminDao implements IAdminDao {

	JdbcTemplate template;

	@Override
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	
/**********************************    LOGIN    *****************************************/
	
	// Getting Role Name from Roletable
	
	@Override
	public List<AdminBean> getRole() {

		return template.query("select roleName from cm_roleTable",
				new RowMapper<AdminBean>() {

					@Override
					public AdminBean mapRow(ResultSet rs, int row)
							throws SQLException {
						AdminBean d = new AdminBean();
						d.setRoleName(rs.getString(1));
						return d;
					}

				});

	}
	
	
	//Getting the Role Id from Role Table  by using the Role Name
	
		@Override
		public int getRoleId(String role) {
			// finding roleId using roleName
			String sqlRoleId = "select roleId from cm_roleTable where roleName=? ";
			return template.queryForObject(sqlRoleId, new Object[] { role },
					Integer.class);

		}

	
	//Verify User Login  
	
	@Override
	public AdminBean verifyUserLogin(String uname, String pass) {
		AdminBean ab=new AdminBean();
		String sql = "select cm_staffTable.sId,cm_staffTable.sName,cm_roleTable.roleName,cm_roleTable.roleId from cm_staffTable join cm_roleTable on  cm_roleTable.roleId= cm_staffTable.roleId where userName = ? and password=? and cm_staffTable.isActive='yes'";
		try{
		ab = template.queryForObject(sql,
				new Object[] { uname, pass },
				new BeanPropertyRowMapper<AdminBean>(AdminBean.class));

		String roleName = ab.getRoleName();
		if (roleName.equals("Doctor")) {
			String sql2 = "Select dId from cm_doctorTable where sId=?";
			Integer dId = template.queryForObject(sql2,
					new Object[] { ab.getsId() }, Integer.class);
			ab.setdId(dId);
		}
		return ab;
		}catch(Exception e){
			ab.setRoleId(0);
			return ab;
		}
		

	}

/***********************************    DOCTOR    *****************************************/	
	
	
	//Inserting Doctor basic details into Staff Table with default roleId 2
	
	@Override
	public int insertDoctorStaff(AdminBean aBean) {
  
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");//to convert the dob into the common formate
		String sqlDate = ft.format(aBean.getsDOB());

		String sql = "insert into cm_staffTable(roleId,sName,DOB,sGender,sAddr,sExp,sPhNo,sEmail,username,password,isActive,createdDate) values(2,'"
				+ aBean.getsName()
				+ "',"
				+ "TO_DATE('"
				+ sqlDate
				+ "','yyyy-MM-dd')"

				// + aBean.getsDOB()
				+ ",'"
				+ aBean.getsGender()
				+ "','"
				+ aBean.getsAddr()
				+ "','"
				+ aBean.getsExp()
				+ "','"
				+ aBean.getsPhNo()
				+ "','"
				+ aBean.getsEmail()
				+ "','"
				+ aBean.getUsername()
				+ "','"
				+ aBean.getPassword()
				+ "','"
				+ "yes"
				+ "',"
				+ "TO_DATE('"
				+ java.time.LocalDate.now() + "','yyyy/MM/dd'))";

		if (template.update(sql) != 0) {

			if (insertDoctor(aBean) != 0) {
				return insertAvailableDays(aBean);
			} else {
				return 0;
			}

		} else {
			return 0;
		}

	}

	
	//Insert Doctors Qualification, Spec and Fee into the Doctors Table by getting the sId from staff table
	
	@Override
	public int insertDoctor(AdminBean aBean) {

		String sql = "select max(sId) from cm_staffTable";
		int sId = template.queryForObject(sql, Integer.class);

		String sql2 = "insert into cm_doctorTable(sId,dSpec,dQualification,consultFee) values(?,?,?,?)";

		return template.update(sql2, new Object[] { sId, aBean.getdSpec(),
				aBean.getdQualification(), aBean.getConsultFee() });
	}

	
	//Insert Doctors Consulting Day into the consult Table by getting the dId from doctors table
	
	@Override
	public int insertAvailableDays(AdminBean aBean) {

		String sql = "select max(dId) from cm_doctorTable";
		int dId = template.queryForObject(sql, Integer.class);

		String sql2 = "insert into cm_consultDaysTable(dId,sunday,monday,tuesday,wednesday,thursday,friday,saturday) values(?,?,?,?,?,?,?,?)";
		return template.update(sql2, new Object[] { dId, aBean.getSunday(),
				aBean.getMonday(), aBean.getTuesday(), aBean.getWednesday(),
				aBean.getThursday(), aBean.getFriday(), aBean.getSaturday() });
	}

	//Listing the Doctors details
	
	@Override
	public List<AdminBean> getDoctorList() {

		return template
				.query("select cm_doctorTable.dId,cm_staffTable.sName,cm_doctorTable.dSpec,cm_staffTable.sPhNo,cm_staffTable.sId from cm_doctorTable join cm_staffTable on  cm_doctorTable.sId= cm_staffTable.sId where cm_staffTable.isActive='yes'",
						new RowMapper<AdminBean>() {

							@Override
							public AdminBean mapRow(ResultSet rs, int row)
									throws SQLException {
								AdminBean d = new AdminBean();
								d.setdId(rs.getInt(1));
								d.setsName(rs.getString(2));
								d.setdSpec(rs.getString(3));
								d.setsPhNo(rs.getString(4));
								d.setsId(rs.getInt(5));
								return d;
							}

						});

	}

	//Disable Doctor Details from and change the isActive value to No
	
	@Override
	public int disableDoctor(AdminBean ab) {

		String sql = "update cm_StaffTable set isActive = 'no' where sId in(select sId"
				+ " from cm_DoctorTable where dId =?)";
		return template.update(sql, new Object[] { ab.getdId() });
	}
 
	//Getting Doctors Details by using Staff Id
	
	@Override
	public List<AdminBean> getDoctorById(int sId) {
		return template
				.query("select sId,dob,sGender,sName,password,username,dId,dSpec,dQualification,consultFee,sExp,sPhNo,isActive,roleId,sAddr,sEmail,sunday,monday,tuesday,wednesday,thursday,friday,saturday from cm_doctorTable join cm_staffTable using (sId) join cm_consultDaysTable using (dId) where sId="
						+ sId + "", new RowMapper<AdminBean>() {
					public AdminBean mapRow(ResultSet rs, int row)
							throws SQLException {
						AdminBean ab = new AdminBean();
						ab.setsId(rs.getInt(1));
						ab.setsDOB(rs.getDate(2));
						ab.setsGender(rs.getString(3));
						ab.setsName(rs.getString(4));
						ab.setPassword(rs.getString(5));
						ab.setUsername(rs.getString(6));
						ab.setdId(rs.getInt(7));
						ab.setdSpec(rs.getString(8));
						ab.setdQualification(rs.getString(9));
						ab.setConsultFee(rs.getDouble(10));
						ab.setsExp(rs.getString(11));
						ab.setsPhNo(rs.getString(12));
						ab.setIsSActive(rs.getString(13));
						ab.setRoleId(rs.getInt(14));
						ab.setsAddr(rs.getString(15));
						ab.setsEmail(rs.getString(16));
						ab.setSunday(rs.getString(17));
						ab.setMonday(rs.getString(18));
						ab.setTuesday(rs.getString(19));
						ab.setWednesday(rs.getString(20));
						ab.setThursday(rs.getString(21));
						ab.setFriday(rs.getString(22));
						ab.setSaturday(rs.getString(23));

						return ab;
					}
				});

	}

	 
	//Update Doctor Details 
	
	@Override
	public int updateDoctor(AdminBean aBean) {

		// int id = getRoleId(aBean.getRoleName());

		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		long t = date.getTime();
		java.sql.Date sqlDate = new java.sql.Date(t);

		// String sqlDate = ft.format(aBean.getsDOB());

		String sql = "update cm_staffTable set sName='" + aBean.getsName()
				+ "',DOB=" + "TO_DATE('" + sqlDate + "','YYYY-MM-dd')"
				+ ",sGender='" + aBean.getsGender() + "',sAddr='"
				+ aBean.getsAddr() + "',sExp='" + aBean.getsExp() + "',sPhNo='"
				+ aBean.getsPhNo() + "',sEmail='" + aBean.getsEmail()
				+ "',username='" + aBean.getUsername() + "',password='"
				+ aBean.getPassword() + "',isActive='yes' where sId= "
				+ aBean.getsId() + "";
		template.update(sql, new Object[] {});

		// int seq = getSeq();
		// int dId=getSeqDoc();
		// System.out.println(seq);
		String sql1 = "update cm_doctorTable set dSpec='" + aBean.getdSpec()
				+ "',dQualification='" + aBean.getdQualification()
				+ "',consultFee=" + aBean.getConsultFee() + " where sId="
				+ aBean.getsId() + "";
		template.update(sql1, new Object[] {});

		int dId = getSeqDid(aBean.getsId());

		String sql2 = "update cm_consultdaysTable set sunday='"
				+ aBean.getSunday() + "',monday='" + aBean.getMonday()
				+ "',tuesday='" + aBean.getTuesday() + "',wednesday='"
				+ aBean.getWednesday() + "',thursday='" + aBean.getThursday()
				+ "',friday='" + aBean.getFriday() + "',saturday='"
				+ aBean.getSaturday() + "'where dId=" + dId + "";
		return template.update(sql2, new Object[] {});

	}

	
	//Getting Doctor Id with staff Id
	
	@Override
	public int getSeqDid(int sId) {
		int id1;
		String sql = "select dId from cm_doctorTable where sId=?";

		id1 = template.queryForObject(sql, new Object[] { sId }, Integer.class);
		return id1;
	}
	
	
	//Search Function to searching by using  sId, dSpec, sPho
		@Override
		public List<AdminBean> getDoctor(String searchString) {
			return template
					.query("select sId,dId,sName,dSpec,sPhNo from cm_doctorTable join cm_staffTable using(sId) where sName like '"
							+ searchString
							+ "%' or dSpec like '"
							+ searchString
							+ "%' or sPhNo like '" + searchString + "%'",
							new RowMapper<AdminBean>() {

								public AdminBean mapRow(ResultSet rs, int row)
										throws SQLException {
									AdminBean ab = new AdminBean();
									ab.setsId(rs.getInt(1));
									ab.setdId(rs.getInt(2));
									ab.setsName(rs.getString(3));
									ab.setdSpec(rs.getString(4));
									ab.setsPhNo(rs.getString(5));

									return ab;
								}
							});
		}

		

/******************************************   MEDICINE     **********************************************/
	
	//Inserting Medicine into the Medicine Table
	
	@Override
	public int saveMedicine(AdminBean adm_bean) {

		String sql = "insert into cm_medicineTable(medName,medPrice,isActive,manufacturer,createdDate)"
				+ "values('"
				+ adm_bean.getMedName()
				+ "',"
				+ adm_bean.getMedPrice()
				+ ",1,'"
				+ adm_bean.getManufacturer()
				+ "',TO_DATE('"
				+ java.time.LocalDate.now()
				+ "', 'YYYY-MM-DD'))";

		return template.update(sql);
	}

	
	//Select the Details of the Medicine  From the Medicine Table
	
	@Override
	public AdminBean get(int medId) {

		String sql = "select * from cm_medicineTable where medId =" + medId
				+ "";
		return (AdminBean) template.queryForObject(sql, new Object[] {},
				new BeanPropertyRowMapper<AdminBean>(AdminBean.class));
	}

	
	//Update the value of the Medicine in the Medicine Table
	
	@Override
	public int updateMedicine(AdminBean adm_bean) {

		String sql = "update cm_medicineTable set medName='"
				+ adm_bean.getMedName() + "',medPrice="
				+ adm_bean.getMedPrice() + ",manufacturer='"
				+ adm_bean.getManufacturer() + "' where medId=?";

		return template.update(sql, new Object[] { adm_bean.getMedId() });
	}

	
	//Disable the Medicine from Viewing by making isActive : No
	
	@Override
	public int disableMedicine(AdminBean ab) {

		String sql = "update cm_medicineTable set isActive=0 where medId=?";

		return template.update(sql, new Object[] { ab.getMedId() });

	}

	//View Medicine Details
	
	@Override
	public List<AdminBean> viewMedicineList() {

		String sql = "select medId,medName,medPrice,manufacturer,createdDate from cm_medicineTable where isActive=1";

		return template.query(sql, new RowMapper<AdminBean>() {

			public AdminBean mapRow(ResultSet rs, int row) throws SQLException {
				AdminBean adm_bean = new AdminBean();
				adm_bean.setMedId(rs.getInt(1));
				adm_bean.setMedName(rs.getString(2));
				adm_bean.setMedPrice(rs.getDouble(3));
				adm_bean.setManufacturer(rs.getString(4));
				adm_bean.setmCreatedDate(rs.getDate(5));
				return adm_bean;
			}
		});
	}
	
	// search medicine by medicine name
	
		@Override
		public List<AdminBean> getSearchMedicine(String searchString) {

			return template
					.query("select medId,medName,manufacturer,MedPrice from cm_medicineTable where  medId like '"
							+ searchString
							+ "%' or medName like '"
							+ searchString
							+ "%'", new RowMapper<AdminBean>() {
						public AdminBean mapRow(ResultSet rs, int row)
								throws SQLException {

							AdminBean ms = new AdminBean();
							ms.setMedId(rs.getInt(1));
							ms.setMedName(rs.getString(2));
							ms.setManufacturer(rs.getString(3));
							ms.setMedPrice(rs.getInt(4));

							return ms;
						}
					});

		}

/************************************    STAFF     *****************************************************/	
   
	
	//Inserting Staff into the staff table with corresponding Role Name
	
	@Override
	public int insertStaff(AdminBean aBean) {

		int id = getRoleId(aBean.getRoleName());

		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String sqlDate = ft.format(aBean.getsDOB());

		String sql = "insert into cm_staffTable(roleId,sName,DOB,sGender,sAddr,sExp,sPhNo,sEmail,username,password,isActive,createdDate) values("
				+ id
				+ ",'"
				+ aBean.getsName()
				+ "',"
				+ "TO_DATE('"
				+ sqlDate
				+ "','yyyy-MM-dd')"

				// + aBean.getsDOB()
				+ ",'"
				+ aBean.getsGender()
				+ "','"
				+ aBean.getsAddr()
				+ "','"
				+ aBean.getsExp()
				+ "','"
				+ aBean.getsPhNo()
				+ "','"
				+ aBean.getsEmail()
				+ "','"
				+ aBean.getUsername()
				+ "','"
				+ aBean.getPassword()
				+ "','"
				+ "yes"
				+ "',"
				+ "TO_DATE('"
				+ java.time.LocalDate.now() + "','yyyy/MM/dd'))";
		return template.update(sql, new Object[] {});
	}

	
	//Update Staff Details
	
	@Override
	public int updateStaff(AdminBean ab) {

		int id = getRoleId(ab.getRoleName());

		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		String sqlDate = ft.format(ab.getsDOB());

		String sql = "update cm_staffTable set roleId=" + id + ",sName='"
				+ ab.getsName() + "',DOB= TO_DATE('" + sqlDate
				+ "' ,'yyyy-MM-dd')" + ",sGender='" + ab.getsGender()
				+ "',sAddr='" + ab.getsAddr() + "',sExp='" + ab.getsExp()
				+ "',sPhNo='" + ab.getsPhNo() + "',sEmail='" + ab.getsEmail()
				+ "',username='" + ab.getUsername() + "',password='"
				+ ab.getPassword() + "',isActive='" + ab.getIsSActive()
				+ "'  where sId=" + ab.getsId() + "";
		return template.update(sql);
	}

	//Getting the List of Active Staff 
	
	@Override
	public List<AdminBean> list() {
		return template
				.query("select sId,cm_staffTable.roleId,sName,DOB,sGender,sAddr,sExp,sPhNo,sEmail,username,password,isActive,createdDate,roleName from cm_staffTable join cm_roleTable on cm_roleTable.roleId=cm_staffTable.roleId where isActive='yes'",
						new RowMapper<AdminBean>() {

							public AdminBean mapRow(ResultSet rs, int row)
									throws SQLException {
								AdminBean ab = new AdminBean();
								ab.setsId(rs.getInt(1));
								ab.setRoleId(rs.getInt(2));
								ab.setsName(rs.getString(3));
								ab.setsDOB(rs.getDate(4));
								ab.setsGender(rs.getString(5));
								ab.setsAddr(rs.getString(6));
								ab.setsExp(rs.getString(7));
								ab.setsPhNo(rs.getString(8));
								ab.setsEmail(rs.getString(9));
								ab.setUsername(rs.getString(10));
								ab.setPassword(rs.getString(11));
								ab.setIsSActive(rs.getString(12));
								ab.setsCreatedDate(rs.getDate(13));
								ab.setRoleName(rs.getString(14));
								return ab;
							}
						});
	}

	 //Getting the Staff Name 
	@Override
	public AdminBean getStaffName(String sName) {
		String sql = "select sId,roleId,sName,DOB,sGender,sAddr,sExp,sPhNo,sEmail,username,password,isActive,createdDate from cm_staffTable where sName=? and cm_staffTable.isActive='yes'";
		return (AdminBean) template.queryForObject(sql, new Object[] { sName },
				new BeanPropertyRowMapper<AdminBean>(AdminBean.class));

	}

	
	//Getting the Staff Details By passing the Sid
	
	@Override
	public List<AdminBean> getStaffId(int sId) {
		/*
		 * String sql =
		 * "select sId,roleId,sName,DOB,sGender,sAddr,sExp,sPhNo,sEmail,username,password,isActive,createdDate from cm_staffTable where sId=? and cm_staffTable.isActive='yes'"
		 * ; return (AdminBean) template.queryForObject(sql, new Object[] { sId
		 * }, new BeanPropertyRowMapper<AdminBean>(AdminBean.class));
		 */
		String sql = "select sId,cm_staffTable.roleId,sName,DOB,sGender,sAddr,sExp,sPhNo,sEmail,username,password,isActive,createdDate,roleName from cm_staffTable join cm_roleTable on cm_roleTable.roleId=cm_staffTable.roleId where isActive='yes' and cm_staffTable.sId=?";
		return template.query(sql, new Object[] { sId },
				new RowMapper<AdminBean>() {

					public AdminBean mapRow(ResultSet rs, int row)
							throws SQLException {
						AdminBean ab = new AdminBean();
						ab.setsId(rs.getInt(1));
						ab.setRoleId(rs.getInt(2));
						ab.setsName(rs.getString(3));
						ab.setsDOB(rs.getDate(4));
						ab.setsGender(rs.getString(5));
						ab.setsAddr(rs.getString(6));
						ab.setsExp(rs.getString(7));
						ab.setsPhNo(rs.getString(8));
						ab.setsEmail(rs.getString(9));
						ab.setUsername(rs.getString(10));
						ab.setPassword(rs.getString(11));
						ab.setIsSActive(rs.getString(12));
						ab.setsCreatedDate(rs.getDate(13));
						ab.setRoleName(rs.getString(14));
						return ab;
					}
				});
	}

	//To make Staff Disable
	@Override
	public int disableStaff(AdminBean aBean) {

		String sql = "update cm_staffTable set isActive =  'no' where sId = ?";
		return template.update(sql, new Object[] { aBean.getsId() });
	}

	 

	// staff search by name and phone number
	
	@Override
	public List<AdminBean> getStaff(String searchString) {
		return template
				.query("select sId,roleName,sName,sPhNo from cm_staffTable join cm_roleTable using(roleId) where sName like '"
						+ searchString
						+ "%' or sPhNo like '"
						+ searchString
						+ "%' or sId like '" + searchString + "%'",
						new RowMapper<AdminBean>() {

							public AdminBean mapRow(ResultSet rs, int row)
									throws SQLException {
								AdminBean ab = new AdminBean();
								ab.setsId(rs.getInt(1));
								ab.setRoleName(rs.getString(2));
								ab.setsName(rs.getString(3));
								ab.setsPhNo(rs.getString(4));
								return ab;
							}
						});
	}
}
