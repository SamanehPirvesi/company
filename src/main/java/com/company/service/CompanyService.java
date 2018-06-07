package com.company.service;

import java.util.List;

import com.company.dao.CompanyDao;
import com.company.model.Company;
import com.company.model.User;

public class CompanyService {
	private CompanyDao companyDao = new CompanyDao();

	public boolean createCompany(Company c) {
		return companyDao.createCompany(c);
	}

	public Company getCompanyById(long id) {
		return companyDao.getCompanyById(id);
	}

	public boolean updateCompany(Company c) {
		return companyDao.updateCompany(c);
	}

	public boolean updateCompanyById(long id, String name) {
		return companyDao.updateCompanyById(id, name);
	}

	public boolean deleteCompany(Company c) {
		return companyDao.deleteCompany(c);
	}

	public List<User> getListOfUserForCompany(long id) {
		return companyDao.getListOfUserForCompany(id);
	}
}
