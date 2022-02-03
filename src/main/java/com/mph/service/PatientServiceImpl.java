
package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.PatientDao;
import com.mph.entity.Patient;

@Service
@Transactional
public class PatientServiceImpl implements PatientService{

	@Autowired
	public PatientDao patientDao;
	/**
	 * informs the compiler that the element is meant to override an element declared in a superclass
	 */
	
	
	@Override
	public void createPatient(Patient patient) {
		patientDao.createPatient(patient);
		
	}

	@Override
	public List<Patient> getAllPatient() {
		return patientDao.getAllPatient();
	}

	@Override
	public Patient getPatient(Patient pat) {
		
		return patientDao.getPatient(pat);
	}

	@Override
	public List<Patient> updatePatient(Patient patient) {
		
		return patientDao.updatePatient(patient);
	}

	

	@Override
	public List<Patient> searchPatient(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient getPatient(int id) {
		
		return patientDao.getPatient(id);
	}

	@Override
	public List<Patient> deletePatient(int pid) {
		// TODO Auto-generated method stub
		return null;
	}



}