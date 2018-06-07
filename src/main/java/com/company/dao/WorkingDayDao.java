package com.company.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.company.model.WorkingDay;

import utility.HibernateUtil;

public class WorkingDayDao {
	/**
	 * adding workingday data in the DB
	 * 
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
	 * 
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
			wd = session.get(WorkingDay.class, id);
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
	 * 
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
	 * caclulate sum of hours in the month month between 1-12 and with id return
	 * 
	 * @param id
	 * @param mounth
	 * @return
	 */
	public int GetHoursOfUserByMonth(long id, int month) {
		int hour = 0;
		int minute = 0;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			// Query query = session.createNativeQuery(
			// "SELECT SUM(HOUR(timediff(wd.initTime,wd.finishTime)))FROM workingday as wd
			// WHERE wd.user_user_id=:userId and MONTH(wd.date)=:month");
			// Query query2 = session.createNativeQuery(
			// "SELECT SUM(MINUTE(timediff(wd.initTime,wd.finishTime)))FROM workingday as wd
			// WHERE wd.user_user_id=:userId and MONTH(wd.date)=:month");
			// query.setParameter("userId", id);
			// query.setParameter("month", month);
			// query2.setParameter("userId", id);
			// query2.setParameter("month", month);
			// hour = Integer.parseInt(query.getSingleResult().toString());
			// minute = Integer.parseInt(query2.getSingleResult().toString());
			// if (minute > 30) {
			// hour += 1;
			// }
			Query query = session.createNativeQuery(
					"SELECT ABS(ROUND((SUM(TIME_TO_SEC(timediff(wd.initTime,wd.finishTime)))/3600))) FROM workingday as wd WHERE  wd.user_user_id=:userId and MONTH(wd.date)=:month");
			query.setParameter("userId", id);
			query.setParameter("month", month);
			hour = Integer.parseInt(query.getSingleResult().toString());
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return hour;
	}

	/**
	 * calculate sum of permission in the month with user id
	 * 
	 * @param id
	 * @param month
	 * @return
	 */
	public int getDaysHolidayForUserByMonth(long id, int month) {
		int counter = 0;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createNativeQuery(
					"SELECT SUM(wd.ferie) FROM workingday as wd WHERE wd.user_user_id=:userId and MONTH(wd.date)=:month");
			query.setParameter("userId", id);
			query.setParameter("month", month);
			counter = Integer.parseInt(query.getSingleResult().toString());
		} catch (Exception ex) {

			tx.rollback();
		} finally {
			session.close();
		}
		return counter;
	}

	/**
	 * calculate sum of holiday in the year
	 * 
	 * @param id
	 * @param year
	 * @return
	 */
	public int getDaysHolidayForUserByYear(long id, int year) {
		int counter = 0;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createNativeQuery(
					"SELECT SUM(wd.ferie) FROM workingday as wd WHERE wd.user_user_id=:userId and Year(wd.date)=:year");
			query.setParameter("userId", id);
			query.setParameter("year", year);
			counter = Integer.parseInt(query.getSingleResult().toString());
		} catch (Exception ex) {

			tx.rollback();
		} finally {
			session.close();
		}
		return counter;
	}

	/**
	 * calculate some of permission hours in the month
	 * 
	 * @param id
	 * @param month
	 * @return
	 */
	public int GetPermissionHoursForByMonth(long id, int month) {
		int hour = 0;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createNativeQuery(
					"SELECT ABS(ROUND((SUM(TIME_TO_SEC(wd.hoursPermission))/3600))) FROM workingday as wd WHERE  wd.user_user_id=:userId and MONTH(wd.date)=:month");
			query.setParameter("userId", id);
			query.setParameter("month", month);
			hour = Integer.parseInt(query.getSingleResult().toString());
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return hour;
	}

	/**
	 * calculate sum of hourpermission in the year
	 * 
	 * @param id
	 * @param month
	 * @return
	 */
	public int GetPermissionHoursForByYear(long id, int year) {
		int hour = 0;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createNativeQuery(
					"SELECT ABS(ROUND((SUM(TIME_TO_SEC(wd.hoursPermission))/3600))) FROM workingday as wd WHERE  wd.user_user_id=:userId and YEAR(wd.date)=:year");
			query.setParameter("userId", id);
			query.setParameter("year", year);
			hour = Integer.parseInt(query.getSingleResult().toString());
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return hour;
	}

	/**
	 * first read workingday by id then delete it
	 * 
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
