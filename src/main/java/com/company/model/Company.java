package com.company.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long company_id;
	private String company_name;
	private String p_iva;
	@OneToMany(mappedBy="company",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<User> users = new ArrayList<>();

	public Company() {

	}

	public Company(String company_name, String p_iva) {
		this.company_name = company_name;
		this.p_iva = p_iva;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getP_iva() {
		return p_iva;
	}

	public void setP_iva(String p_iva) {
		this.p_iva = p_iva;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	public void addUsers(User user) {
		users.add(user);
	}

}
