package com.mph.dao;

import java.util.List;

import com.mph.entity.Patient;

public interface PatientDao {
	public void createPatient(Patient patient);
	public List<Patient> getAllPatient();
	public Patient getPatient(int id);
	public List<Patient> updatePatient();

	public Patient getPatient(Patient pat);
	public List<Patient> searchPatient(int pid);
	public List<Patient> updatePatient(Patient patient);

	
}