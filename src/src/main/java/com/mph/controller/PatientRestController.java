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



@RestController
@RequestMapping("/patient")
@CrossOrigin(allowCredentials = "true",allowedHeaders =  "*"  ,origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE} )
public class PatientRestController {
	@Autowired
	public PatientService patientService;

	@GetMapping("/AllPatient")
	public ResponseEntity<List<Patient>> listAllPatient() {
		List<Patient> li = patientService.getAllPatient();
		if (li.isEmpty()) {
			return new ResponseEntity<List<Patient>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Patient>>(li,HttpStatus.OK);
	}
	 @GetMapping("/getPatient/{pid}")
	    public ResponseEntity<Patient> getPatient(@PathVariable("pid") int id){
	    	
		 Patient pat = patientService.getPatient(id);
	    	if (pat == null) {
				return new ResponseEntity<Patient>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<Patient>(pat,HttpStatus.OK);
	    }
	 
	
	@PostMapping("/createPatient")
	public Patient createEmployee(@RequestBody Patient patient) {
		patientService.createPatient(patient);
		return patient;
	}
	
	@DeleteMapping("/deletePatient/{id}")
	public ResponseEntity<List<Patient>> deletePatient(@PathVariable("id") int pid) {
		List<Patient> li = patientService.deletePatient(pid);
		if (li.isEmpty()) {
			return new ResponseEntity<List<Patient>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Patient>>(li,HttpStatus.OK);
	}
	
	@PutMapping("/updatePatient")
	public ResponseEntity<List<Patient>> updatePatient(@RequestBody Patient patient) {
		List<Patient> li = patientService.updatePatient(patient);
		
		if (li.isEmpty()) {
			return new ResponseEntity<List<Patient>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Patient>>(li,HttpStatus.OK);
	}
	
	
}