package com.company.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.company.model.User;

import utility.HibernateUtil;

public class UserDao {
	/**
	 * use for adding data in user table in the DB
	 * 
	 * @param u
	 * @return
	 */
	public boolean createUser(User u) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.persist(u);
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
	 * use for read user by id from DB
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById(long id) {
		User u = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			u = session.get(User.class, id);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return u;
	}

	/**
	 * read from DB by name and if exsit same name keep in the list
	 * 
	 * @param name
	 * @return
	 */
	public List<User> getUsersByName(String name) {
		List<User> list = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query<User> query = session.createQuery("from User where user_name=:username",User.class);
			query.setParameter("username", name);
			list = query.getResultList();
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * read from DB by user name and return one result because username is unique
	 * 
	 * @param username
	 * @return
	 */
	public User getUserByUserName(String username) {
		User u = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query<User> query = session.createQuery("from User where userName=:username",User.class);
			query.setParameter("username", username);
			u = (User) query.uniqueResult();
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return u;
	}

	/**
	 * return list of all user
	 * 
	 * @return
	 */

	public List<User> getAllUser() {
		List<User> list = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query<User> query = session.createQuery("from User ",User.class);
			list = query.getResultList();
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return list;
	}

	/**
	 * if the user is active return true else return false
	 * 
	 * @param username
	 * @return
	 */
	public boolean isUserActive(long id) {
		boolean result = false;
		User u;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query<User> query = session.createQuery("from User where user_id=:userid",User.class);
			query.setParameter("userid", id);
			u = (User) query.uniqueResult();
			result = u.isActive();
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return result;
	}

	/**
	 * when read from DB after that whit this method we can update data
	 * 
	 * @param u
	 * @return
	 */
	public boolean updateUser(User u) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.update(u);
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
	 * white out need to read from DB only with find by id and after that update our
	 * data
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	
	public boolean updateUserById(long id, String name) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("UPDATE User SET user_name=:username WHERE user_id=:idnumber");
			query.setParameter("username", name);
			query.setParameter("idnumber", id);
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
	 * take the user name and update the passworld
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	public boolean updatePassworldByUsername(String username, String passworld) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("UPDATE User SET passworld=:passworld WHERE userName=:username");
			query.setParameter("passworld", passworld);
			query.setParameter("username", username);
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
	 * this method use when we want active the user with the username
	 * 
	 * @param username
	 * @param passworld
	 * @return
	 */

	public boolean activeExsistentUserByUsername(String username) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("UPDATE User SET active=:active WHERE userName=:username");
			query.setParameter("active", true);
			query.setParameter("username", username);
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
	 * use for deactive the user
	 * 
	 * @param username
	 * @return
	 */
	public boolean deactiveExsistentUserByUsername(String username) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("UPDATE User SET active=:active WHERE userName=:username");
			query.setParameter("active", false);
			query.setParameter("username", username);
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
	 * first read data from DB after that delete select data
	 * 
	 * @param u
	 * @return
	 */
	public boolean deleteUser(User u) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.delete(u);
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
	 * delete the user first take the user id and after that delete it
	 * 
	 * @param username
	 * @param passworld
	 * @return
	 */

}
