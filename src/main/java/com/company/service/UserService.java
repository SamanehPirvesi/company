package com.company.service;

import java.util.List;

import com.company.dao.UserDao;
import com.company.model.User;

public class UserService {
	private UserDao userDao = new UserDao();

	public boolean createUser(User u) {
		return userDao.createUser(u);
	}

	public User getUserById(long id) {
		return userDao.getUserById(id);
	}

	public List<User> getUsersByName(String name) {
		return userDao.getUsersByName(name);
	}

	public User getUserByUserName(String username) {
		return userDao.getUserByUserName(username);
	}

	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	public boolean isUserActive(long id) {
		return userDao.isUserActive(id);
	}

	public boolean updateUser(User u) {
		return userDao.updateUser(u);
	}

	public boolean updateUserById(long id, String name) {
		return userDao.updateUserById(id, name);
	}

	public boolean updatePassworldByUsername(String username, String passworld) {
		return userDao.updatePassworldByUsername(username, passworld);
	}

	public boolean activeExsistentUserByUsername(String username) {
		return userDao.activeExsistentUserByUsername(username);
	}

	public boolean deactiveExsistentUserByUsername(String username) {
		return userDao.deactiveExsistentUserByUsername(username);
	}

	public boolean deleteUser(User u) {
		return userDao.deleteUser(u);

	}
}
