package com.mph.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
    private String pname;
	private String email;
	private String password;
	private String gender;
	private long phone;
	private String address;
	private String city;
	/**
	 * used to refer the parent class object
	 */

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param pid  this get id of the patient
	 * @param pname gets the name of the patient
	 * @param email gets the email of the patient
	 * @param password generates the password
	 * @param gender 
	 * @param phone gets the phone number of the patient
	 * @param address gets the address of the patient
	 * @param city gets the city of the patient
	 */

	public Patient(int pid, String pname, String email, String password, String gender,long phone, String address,String city) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.city = city;	
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pname=" + pname + ", email=" + email + ", password=" + password + ", gender="
				+ gender + ", phone=" + phone + ", address=" + address + ", city=" + city + "]";
	}
	
	

}