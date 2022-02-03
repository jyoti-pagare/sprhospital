package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Patient;

@Repository
public class PatientDaoImpl implements PatientDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void createPatient(Patient patient) {
		getSession().saveOrUpdate(patient);
		System.out.println("Patient have been Saved successfully...");
		
	}

	@Override
	public List<Patient> getAllPatient() {
		Query qry = getSession().createQuery("select p from Patient p");
		List<Patient>  plist = qry.list();
		System.out.println("patient list from dao : " + plist);
		return plist;
	}

	@Override
	public Patient getPatient(Patient pat) {
	    Criteria c = getSession().createCriteria(Patient.class);
	    c.add(Restrictions.eq("email",pat.getEmail()));
	    Patient patient= (Patient) c.uniqueResult();	    
		return patient;
	}

	@Override
	public List<Patient> updatePatient(Patient patient) {
		Query qry = getSession().createQuery(" update Patient  p set pname=:pname,password=:pass,gender=:gender,phone=:phone");
		qry.setParameter("pname", patient.getPname());
		qry.setParameter("pass", patient.getPassword());
		qry.setParameter("gender", patient.getGender());
		qry.setParameter("phone",patient.getPhone());
		
		int noofrows = qry.executeUpdate();
		if(noofrows>0) {
			System.out.println("Updated " + noofrows + " rows. ");
		}
		return getAllPatient();
	}

	@Override
	public List<Patient> deletePatient(int pid) {
		Query qry = getSession().createQuery(" delete Patient p where pid=:pid");
		qry.setParameter("pid", pid);
		int noofrows = qry.executeUpdate();
		if(noofrows>0) {
			System.out.println("Deleted " + noofrows + " rows. ");
		}
		return getAllPatient();
	}

	@Override
	public Patient getPatient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> searchPatient(int pid) {
		Query qry = getSession().createQuery(" search Patient p where pid=:pid");
		qry.setParameter("pid", pid);
		return getAllPatient();
	}

	@Override
	public List<Patient> updatePatient() {
		// TODO Auto-generated method stub
		return null;
	}

}