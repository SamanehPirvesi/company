package com.company.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.company.model.WorkingDay;

import hibernateUtil.HibernateUtil;

public class WorkingDayDao {
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
//	public WorkingDay getWorkingDaywdById(long id) {
//		WorkingDay wd = null;
//		Session session = HibernateUtil.openSession();
//		Transaction tx = null;
//		try {
//			tx = session.getTransaction();
//			tx.begin();
//
//			c=session.get(WorkingDay.class, id);
//
//			tx.commit();
//			
//		} catch (Exception ex) {
//
//			tx.rollback();
//
//		} finally {
//			session.close();
//		}
//
//		return c;
//
//	}
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
//	@SuppressWarnings("deprecation")
//	public boolean updateWrkingById(long id , String name) {
//		boolean res = false;
//		Session session = HibernateUtil.openSession();
//		Transaction tx = null;
//		try {
//			tx = session.getTransaction();
//			tx.begin();
//
//			Query query=session.createQuery("UPDATE Company SET company_name=:companyname WHERE company_id=:idnumber");
//			query.setString("companyname",name);
//			query.setLong("idnumber", id);
//		query.executeUpdate();
//			res = true;
//		} catch (Exception ex) {
//
//			tx.rollback();
//
//		} finally {
//			session.close();
//		}
//
//		return res;
//
//	}
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
