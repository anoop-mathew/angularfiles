package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.IDoctorDao;
import com.ust.model.DoctorBean;

@RestController
public class DoctorController {

	@Autowired
	IDoctorDao ddao;

	

	@RequestMapping(value = "/api/addPatientComment", method = RequestMethod.POST)
	public void insertObservation(@RequestBody DoctorBean doc_bean) {
		ddao.addPatientComments(doc_bean);
	}

	

	// RequestMapping to get all Lab tests
	@RequestMapping(value = "/api/labtests", method = RequestMethod.GET)
	public List<DoctorBean> getAllLabTests() {
		List list = ddao.lablist();
		return list;
	}
	
	//Lab
	@RequestMapping(value = "/api/alllabpreslist/{dId}/{regId}", method = RequestMethod.GET)
	  public List<DoctorBean> getAllLabPrescription(@PathVariable("dId") int dId,@PathVariable("regId") int regId)
	  {
	     List presList=ddao.getAllLabPrescription(dId,regId);
	 return presList;
	  }
	
	@RequestMapping(value = "/api/insertlabpres", method = RequestMethod.POST)
	public void insertDoctorLabPrescription(@RequestBody DoctorBean doc) {
		System.out.println("insert prescr");
		ddao.saveDoctorLabPrescription(doc);

	}
	
	
	
	
	// RequestMapping to get all Medicine tests
	@RequestMapping(value = "/api/medlists", method = RequestMethod.GET)
	public List<DoctorBean> getAllMedicineList() {
		List list = ddao.medicinelist();
		return list;
	}

	

	// RequestMappig to remove the medicine
	
	@RequestMapping(value = "/api/removemedicine/{medId}", method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable("medId") int medId) {
		ddao.removemedicine(medId);
	}

	@RequestMapping(value = "/api/medHis/{regId}", method = RequestMethod.GET)
	public List<DoctorBean> getAllMedicineHistory(
			@PathVariable("regId") int regId) {
		List list = ddao.medicinehist(regId);
		return list;
	}

	@RequestMapping(value = "/api/labtestshis/{regId}", method = RequestMethod.GET)
	public List<DoctorBean> getAllLabTestsHistory(
			@PathVariable("regId") int regId) {
		List list = ddao.lablistHistory(regId);
		return list;
	}

	@RequestMapping(value = "/api/Obsshis/{regId}", method = RequestMethod.GET)
	public List<DoctorBean> getAllObservationsHistory(
			@PathVariable("regId") int regId) {
		List list = ddao.ObslistHistory(regId);
		return list;
	}

	@RequestMapping(value = "/api/insertpres", method = RequestMethod.POST)
	public void insertDoctorPrescription(@RequestBody DoctorBean doc) {
		System.out.println("insert prescr");
		ddao.saveDoctorPrescription(doc);

	}
	
	@RequestMapping(value = "/api/allpreslist/{dId}/{regId}", method = RequestMethod.GET)
	  public List<DoctorBean> getAllPrescription(@PathVariable("dId") int dId,@PathVariable("regId") int regId)
	  {
	     List presList=ddao.getAllPrescription(dId,regId);
	 return presList;
	  }
	
	// search appointment by AppId and RegId and PatientName
	
		@RequestMapping(value = "/api/searchAppointment/{searchString}/{dId}", method = RequestMethod.GET)
		
		public List<DoctorBean> getSearchAppointment(
				@PathVariable("searchString") String searchString ,@PathVariable("dId") int dId) {
			System.out.println(searchString);
			List list = ddao.getSearchAppointment(searchString,dId);
			return list;
		}
		
		// RequestMapping to get the appointments of each doctor
				@RequestMapping(value = "/api/getdoctorscompletedappointment/{dId}", method = RequestMethod.GET)
				public List<DoctorBean> getDoctorsCompletedAppointment(@PathVariable("dId") int dId) {
					List list = ddao.getDoctorsCompletedAppointment(dId);

					return list;
				}
				
				// RequestMapping to get the appointments of each doctor
						@RequestMapping(value = "/api/getDoctorsAnyAppointment/{dId}", method = RequestMethod.GET)
						public List<DoctorBean> getDoctorsAnyAppointment(@PathVariable("dId") int dId) {
							List list = ddao.getDoctorsAnyAppointment(dId);

							return list;
						}




			// RequestMapping to get the appointments of each doctor
			@RequestMapping(value = "/api/getdoctorsappointment/{dId}", method = RequestMethod.GET)
			public List<DoctorBean> getDoctorsApponintment(@PathVariable("dId") int dId) {
				List list = ddao.getDoctorsAppointment(dId);

				return list;
			}
			
			//delete Med
			
			@RequestMapping(value="/api/deleteMed/{id}",method=RequestMethod.DELETE)
			public void deleteMed(@PathVariable("id") int id)
			{System.out.println("hi");
			ddao.delete(id);
			}
			
             //delete lab
			
			@RequestMapping(value="/api/deleteLab/{id}",method=RequestMethod.DELETE)
			public void deleteLab(@PathVariable("id") int id)
			{System.out.println("hi");
			ddao.deleteLab(id);
			}
}
