package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.IAdminDao;
import com.ust.model.AdminBean;

@RestController
public class AdminController {

	@Autowired
	IAdminDao adao;

	
/**********************************    LOGIN    *****************************************/
	
	// Getting Role Name from Roletable
	
	@RequestMapping(value = "/api/getRole", method = RequestMethod.GET)
	public List<AdminBean> getAllRole() {
		List list = adao.getRole();
		return list;
	}

	
	//Verify User Login  
	
	@RequestMapping(value = "/api/verifyLogin/{uname}/{pass}", method = RequestMethod.GET)
	public AdminBean verifyLogin(@PathVariable("uname") String uname,
			@PathVariable("pass") String pass) {
		return adao.verifyUserLogin(uname, pass);
	}

/***************************************** DOCTOT **********************************/
	
	//Save Doctor Details
	
	@RequestMapping(value = "/api/saveDoctor", method = { RequestMethod.POST,
			RequestMethod.PUT })
	public void doctorInsert(@RequestBody AdminBean aBean) {
		if (aBean.getsId() != 0) {
			adao.updateDoctor(aBean);
		} else {
			adao.insertDoctorStaff(aBean);
			
		}
	}

	//Getting the Doctor By dId
	
	@RequestMapping(value = "/api/getDoctorById/{sId}", method = RequestMethod.GET, produces = "application/json")
	public AdminBean getDoctoree(@ModelAttribute("ad") AdminBean ad,
			@PathVariable("sId") int sId) {
		List doc = adao.getDoctorById(sId);
		ad =  (AdminBean) doc.get(0);//date of birth in correct formate
		return ad;
	}

	// Request to list the doctor list 
	
	@RequestMapping(value = "/api/listdoctor", method = RequestMethod.GET)
	public List<AdminBean> getAllDoctors() {
		List list = adao.getDoctorList();
		return list;
	}

	
	
	// Search by Doctor name
	
		@RequestMapping(value = "/api/doctor/{searchString}", method = RequestMethod.GET)
		public List<AdminBean> getDoctor(
				@PathVariable("searchString") String searchString) {
			System.out.println(searchString);
			List list = adao.getDoctor(searchString);
			System.out.println(list);
			return list;
		}
		
		
	// Disable Doctor
		
	@RequestMapping(value = "/api/disableDoctor", method = RequestMethod.PUT)
	void doctorDisable(@RequestBody AdminBean aBean) {
		adao.disableDoctor(aBean);
	}

/*************************************** MEDICINE ***************************************/
	
	//Disabling Medicine
	
	@RequestMapping(value = "/api/disableMedicine", method = RequestMethod.PUT)
	public void disableMedicine(@RequestBody AdminBean aBean) {
		adao.disableMedicine(aBean);
	}

	//Getting the Medicine List
	
	@RequestMapping(value = "/api/viewMedicineList", method = RequestMethod.GET)
	public List<AdminBean> viewMedicine() {
		List list = adao.viewMedicineList();
		return list;
	}

	//Inserting Medicine 
	
	@RequestMapping(value = "/api/insertMedicine", method = {
			RequestMethod.POST, RequestMethod.PUT })
	public void insertBook(@RequestBody AdminBean aBean) {

		if (aBean.getMedId() != 0) {
			adao.updateMedicine(aBean);

		} else {
			adao.saveMedicine(aBean);
		}
	}

	
	//Getting the Medicine By MedId
	
	@RequestMapping(value = "/api/getMedicineId/{medId}", method = RequestMethod.GET)
	public AdminBean getMedicineById(@PathVariable("medId") int medId) {

		return adao.get(medId);
	}
	

		
		//Search Medicine by Medicine Name or Medicine Id
	
		@RequestMapping(value = "/api/medicineSearch/{searchString}", method = RequestMethod.GET)
		public List<AdminBean> getMedicine(
				@PathVariable("searchString") String searchString) {
			System.out.println(searchString);
			List list = adao.getSearchMedicine(searchString);
			System.out.println(list);
			return list;
		}

	/**************** INSERT STAFF ***************************/

	//Inserting Staff Details
	@RequestMapping(value = "/api/insertStaff", method = { RequestMethod.POST,
			RequestMethod.PUT })
	public void staffInsert(@RequestBody AdminBean aBean) {
		if (aBean.getsId() == 0) {
			adao.insertStaff(aBean);
		} else {
			adao.updateStaff(aBean);
		}

	}

	// Display Staff Details
	
	@RequestMapping(value = "/api/staff", method = RequestMethod.GET)
	public List<AdminBean> getAllStaffs() {
		List list = adao.list();
		return list;
	}

	// Search by Staff Name
	
	@RequestMapping(value = "/api/staff/{sName}", method = RequestMethod.GET)
	public AdminBean getBookById(@PathVariable("sName") String sName) {
		return adao.getStaffName(sName);
	}

	// Disable staff Details
	
	@RequestMapping(value = "/api/disableStaff", method = RequestMethod.PUT)
	void staffDisable(@RequestBody AdminBean aBean) {
		adao.disableStaff(aBean);

	}
	
	//Getting Details of the staff By using sId
	
	@RequestMapping(value = "/api/staffById/{sId}", method = RequestMethod.GET)
	public AdminBean getBookById(@PathVariable("sId") int sId) {
		AdminBean ab;
		List list= adao.getStaffId(sId);
		ab=(AdminBean) list.get(0);
		return ab;
	}
	
		// search by staff name
	
		@RequestMapping(value = "/api/staffSearch/{searchString}", method = RequestMethod.GET)
		public List<AdminBean> getPatient(
				@PathVariable("searchString") String searchString) {
			System.out.println(searchString);
			List list = adao.getStaff(searchString);
			System.out.println(list);
			return list;
		}

}
