package com.company.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long user_id;
	private String user_name;
	private String surname;
	@Column(unique=true)
	private String userName;
	private String passworld;
	private String codiceFiscale;
	private Date Birthday  ;
	@Embedded
	private Address address;
	private String tellNumber;
	private String mobilenumber;
	private boolean active;
	private double salary;
	

	public User() {
	}

	public User(long user_id, String user_name, String surname, String userName, String passworld, String codiceFiscale,
			SimpleDateFormat birthday, Address address, String tellNumber, String mobilenumber, boolean active,
			double salary) {

		this.user_id = user_id;
		this.user_name = user_name;
		this.surname = surname;
		this.userName = userName;
		this.passworld = passworld;
		this.codiceFiscale = codiceFiscale;
		Birthday = birthday;
		this.address = address;
		this.tellNumber = tellNumber;
		this.mobilenumber = mobilenumber;
		this.active = active;
		this.salary = salary;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassworld() {
		return passworld;
	}

	public void setPassworld(String passworld) {
		this.passworld = passworld;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public SimpleDateFormat getBirthday() {
		return Birthday;
	}

	public void setBirthday(SimpleDateFormat birthday) {
		Birthday = birthday;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getTellNumber() {
		return tellNumber;
	}

	public void setTellNumber(String tellNumber) {
		this.tellNumber = tellNumber;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
