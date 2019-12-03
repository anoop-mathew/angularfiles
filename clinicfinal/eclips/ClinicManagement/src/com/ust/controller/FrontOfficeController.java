package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.IFrontOfficeDao;
import com.ust.model.AdminBean;
import com.ust.model.FrontOfficeBean;

@RestController
public class FrontOfficeController {

	@Autowired
	IFrontOfficeDao fdao;

	@RequestMapping(value = "/api/getAvailableDoctor", method = RequestMethod.GET)
	public List<FrontOfficeBean> getAvailableDoctors() {

		List list = fdao.getAvailableDoctor();
		return list;
	}
	
	/* Request Mapping to search a doctor */
	@RequestMapping(value = "/api/searchDoctorByName/{sName}", method = RequestMethod.GET)
	public FrontOfficeBean getDoctorByName(@PathVariable("sName") String sName) {
		return fdao.getDoctorName(sName);

	}

	@RequestMapping(value = "/api/patients", headers = "Accept=Application/json", method = RequestMethod.GET)
	public List AllPatients(@ModelAttribute("fob") FrontOfficeBean fob) {
		List patList = fdao.viewPatientList();
		return patList;
	}
	
	
	
	// front office view patient by the regid 
			@RequestMapping(value = "/api/ViewPatient/{regId}", headers = "Accept=Application/json", method = RequestMethod.GET)
			public FrontOfficeBean patientDetails(@PathVariable("regId") int regId) {
			FrontOfficeBean fob = fdao.getPatientByRegId(regId);
			//fdao.dateConversion(fob);
			return fob;
			}

	


	// Patient required details
	@RequestMapping(value = "/api/patientDetails/{regId}", headers = "Accept=Application/json", method = RequestMethod.GET)
	public FrontOfficeBean patientsDetail(@PathVariable("regId") int regId) {
		FrontOfficeBean fob;

		List list = fdao.getPatientDetail(regId);
		fob = (FrontOfficeBean) list.get(0);
		return fob;
	}

	// search patient by regId and phone number
	@RequestMapping(value = "/api/patient/{searchString}", method = RequestMethod.GET)
	public List<FrontOfficeBean> getPatient(@PathVariable("searchString") String searchString) {

		List list = fdao.getPatient(searchString);
		/*
		 * FrontOfficeBean fb=(FrontOfficeBean) list.get(0);
		 * System.out.println(fb);
		 */
		return list;
	}

	// Today's appointment list of patients
	@RequestMapping(value = "/api/appointment/{date}", method = RequestMethod.GET)
	public List getappointments(@ModelAttribute("fob") FrontOfficeBean fob,
			@PathVariable("date") String date) {
		List list = fdao.appointmentList(date);
		return list;
	}
	
	@RequestMapping(value = "/api/insertAppoinment", method = RequestMethod.POST)
	public void addDoctorsAppoinment(@RequestBody FrontOfficeBean fob) {
		
		fdao.addAppoinment(fob);
		
	}
	
	// Add patient in front office
		@RequestMapping(value = "/api/insertPatient", method = { RequestMethod.POST,
				RequestMethod.PUT })
		public void insertPatient(@RequestBody FrontOfficeBean fob) {
			if (fob.getRegId() != 0) {
				fdao.updatePatient(fob);
			} else {
				fdao.savePatient(fob);
			}
		}


		// Today's appointment list of patients
		@RequestMapping(value = "/api/appointment/", method = RequestMethod.GET)
		@ResponseBody
		public List getappointments(@ModelAttribute("fob") FrontOfficeBean fob) {
			List list = fdao.appointmentList();
			return list;
		}

		// Todays appointment search

		@RequestMapping(value = "/api/searchPatient/{searchString}", method = RequestMethod.GET)
		public List<FrontOfficeBean> getPatientTodaysSearch(
				@PathVariable("searchString") String searchString) {
			System.out.println(searchString);
			List list = fdao.getTodaysPatient(searchString);
			System.out.println(list);
			return list;
		}
}
