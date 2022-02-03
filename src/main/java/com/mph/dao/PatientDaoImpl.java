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
	/**
	 *   informs the compiler that the element is meant to override an element declared in a superclass
	 */
	
	
	
	@Override
	public void createPatient(Patient patient) {
		getSession().saveOrUpdate(patient);
		System.out.println("Patient have been Saved successfully...");
		
	}
	/**
	 * 
	 */

	@Override
	public List<Patient> getAllPatient() {
		Query qry = getSession().createQuery("select p from Patient p");
		List<Patient>  patlist = qry.list();
		System.out.println("pat list from dao : " + patlist);
		return patlist;
	}

	
	@Override
	public List<Patient> updatePatient(Patient patient) {
		Query qry = getSession().createQuery(" update Patient  p set pname=:pname,email=:email,address=:address,city=:city,phone=:phone where pid=:pid");
		qry.setParameter("pname", patient.getPname());
		qry.setParameter("email", patient.getEmail());
		qry.setParameter("address", patient.getAddress());
		qry.setParameter("city",patient.getCity());
		qry.setParameter("phone",patient.getPhone());
		qry.setParameter("pid",patient.getPid());
		
		int noofrows = qry.executeUpdate();
		if(noofrows>0) {
			System.out.println("Updated " + noofrows + " rows. ");
		}
		return getAllPatient();
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

	@Override
	public Patient getPatient(int id) {
		Query qry=getSession().createQuery("from  Patient  p where pid=:id");
		qry.setParameter("id", id);
		Patient pat = (Patient ) qry.uniqueResult();
		System.out.println("search result : " + pat);
		return pat;
	}

	@Override
	public Patient getPatient(Patient pat) {
	
		return null;
	}

}