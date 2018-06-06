package com.company.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.company.model.WorkingDay;

import utility.HibernateUtil;

public class WorkingDayDao {
	/**
	 * adding workingday data in the DB
	 * @param wd
	 * @return
	 */
	public boolean createWorkingDay(WorkingDay wd) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			session.persist(wd);

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
	 * for reading workingday with the id
	 * @param id
	 * @return
	 */
	
	public WorkingDay getWorkingDaywdById(long id) {
		WorkingDay wd = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			wd=session.get(WorkingDay.class, id);

			tx.commit();
			
		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}
		return wd;
	}
	
	/**
	 * for updating workingday parameter
	 * @param wd
	 * @return
	 */
	public boolean updateWorkingDay(WorkingDay wd) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			session.update(wd);

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
	 * mounth between 1-12 and with id return
	 * @param id
	 * @param mounth
	 * @return
	 */

	public boolean GetHoursOfUserByMounth(long id , int mounth) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			Query query=session.createQuery("from WorkingDay , WHERE company_id=:idnumber");
		
	
			res = true;
		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}

		return res;

	}
	/**
	 * forst read workingday by id then delete it
	 * @param wd
	 * @return
	 */
	public boolean deleteWorkingDay(WorkingDay wd) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			session.delete(wd);

			tx.commit();
			res = true;
		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}

		return res;

	}


}
