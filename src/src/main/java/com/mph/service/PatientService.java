package com.mph.service;

import java.util.List;

import com.mph.entity.Patient;

public interface PatientService {
	public void createPatient(Patient patient);
	public List<Patient> getAllPatient();
	public Patient getPatient();
	public List<Patient> updatePatient(Patient patient);
	public List<Patient> deletePatient(int pid);
	Patient getPatient(int id);
	public List<Patient> searchPatient(int pid);
	Patient getPatient(Patient pat);
}