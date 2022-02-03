package com.mph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.Patient;
import com.mph.service.PatientService;
/**
 * 
 * @author sathish.k ,jyothi pagare, pavan,meghna ,krisna chaitnaya
 *
 */
@RestController
@RequestMapping("/patient")
@CrossOrigin(allowCredentials = "true",allowedHeaders =  "*"  ,origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE} )
public class PatientRestController {
	@Autowired
	public PatientService patientService;
/**
 * here getmapping is used to handle get type of request method
 * @return   it returns the patient created
 */
	@GetMapping("/AllPatient")
	public ResponseEntity<List<Patient>> listAllPatient() {
		List<Patient> li = patientService.getAllPatient();
		if (li.isEmpty()) {
			return new ResponseEntity<List<Patient>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Patient>>(li,HttpStatus.OK);
	}
	/**
	 * it maps the http post requests onto specific handler
	 * @param patient  it reads the form data and bind it automatically to the parameter present in the provided method
	 * @return the patient created will be retained at run time
	 */
	@PostMapping("/createPatient")
	public Patient createEmployee(@RequestBody Patient patient) {
		patientService.createPatient(patient);
		return patient;
	}
	/**
	 * for mapping http delete requests onto specific handler methods 
	 * @param pid  it reads the pid value  and binds it automatically
	 * @return  deletes the patient 
	 */
	/*@DeleteMapping("/deletePat/{id}")
	public ResponseEntity<List<Patient>> deletePatient(@PathVariable("id") int pid) {
		List<Patient> li = patientService.deletePatient(pid);
		if (li.isEmpty()) {
			return new ResponseEntity<List<Patient>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Patient>>(li,HttpStatus.OK);
	}**/
	/**
	 * mapping http put requests onto specific handler methods
	 * @param patient it reads the value and binds after updation of value
	 * @return gives the updated value
	 */
	
	@PutMapping("/updatePat")
	public ResponseEntity<List<Patient>> updatePatient(@RequestBody Patient patient) {
		List<Patient> li = patientService.updatePatient(patient);
		
		if (li.isEmpty()) {
			return new ResponseEntity<List<Patient>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Patient>>(li,HttpStatus.OK);
	}
	/**
	 * here getmapping is used to handle get type of request method
	 * @param id it gives a single patient values for the mentioned id
	 * @return gives a single patient results
	 */
	 @GetMapping("/getPat/{pid}")
	    public ResponseEntity<Patient> getPatient(@PathVariable("pid") int id){
	    	
		 Patient pat = patientService.getPatient(id);
	    	if (pat == null) {
				return new ResponseEntity<Patient>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<Patient>(pat,HttpStatus.OK);
	    }
	 
	
}