package com.company.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_id;
	private String user_name;
	private String surname;
	@Column(unique = true)
	private String userName;
	private String passworld;
	private String codiceFiscale;
	private Date Birthday=new Date();
	@Embedded
	private Address address;
	private String tellNumber;
	private String mobilenumber;
	private boolean active;
	private double salary;
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<WorkingDay> workingdays = new ArrayList<>();
	@ManyToOne
	private Company company;

	public User() {
	}

	public User(String user_name, String surname, String userName, String passworld, String codiceFiscale,
			 Address address, String tellNumber, String mobilenumber, boolean active, double salary) {

		this.user_name = user_name;
		this.surname = surname;
		this.userName = userName;
		this.passworld = passworld;
		this.codiceFiscale = codiceFiscale;
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

	public Date getBirthday() {
		return Birthday;
	}

	public void setBirthday(Date birthday) {
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

	public List<WorkingDay> getWorkingdays() {
		return workingdays;
	}

	public void setWorkingdays(List<WorkingDay> workingdays) {
		this.workingdays = workingdays;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
/**
 * this method is for adding workingday to list of workingdays  and keep for each user 
 * @param workingDay
 */
	public void addWorkingDays(WorkingDay workingDay) {
		workingdays.add(workingDay);

	}

}
