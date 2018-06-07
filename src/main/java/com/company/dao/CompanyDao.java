package com.company.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.company.model.Company;
import com.company.model.User;

import utility.HibernateUtil;

public class CompanyDao {
	/**
	 * adding data for company table
	 * 
	 * @param c
	 * @return
	 */
	public boolean createCompany(Company c) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			session.persist(c);
			tx.commit();
			res = true;
		} catch (Exception ex) {

			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}

	/**
	 * use for read from company table by id
	 * 
	 * @param id
	 * @return
	 */
	public Company getCompanyById(long id) {
		Company c = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			c = session.get(Company.class, id);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return c;
	}

	/**
	 * update data in company table and first must run the read method and then
	 * update it
	 * 
	 * @param c
	 * @return
	 */
	public boolean updateCompany(Company c) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			session.update(c);
			tx.commit();
			res = true;
		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}
		return res;
	}

	/**
	 * update comnpany table by id without reading data with read method
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public boolean updateCompanyById(long id, String name) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("UPDATE Company SET company_name=:companyname WHERE company_id=:idnumber");
			query.setString("companyname", name);
			query.setLong("idnumber", id);
			query.executeUpdate();
			res = true;
		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}
		return res;
	}

	/**
	 * delete data from company and with this method first use read method and then
	 * use delete
	 * 
	 * @param c
	 * @return
	 */
	public boolean deleteCompany(Company c) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.delete(c);
			tx.commit();
			res = true;
		} catch (Exception ex) {
			tx.rollback();

		} finally {
			session.close();
		}
		return res;
	}

	public List<User> getListOfUserForCompany(long id) {
		List<User> list = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("FROM User where company_company_id=:companyid");
			query.setLong("companyid", id);
			list = query.getResultList();
			tx.commit();
		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}

		return list;

	}

}
