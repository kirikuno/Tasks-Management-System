package com.java.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.UserDao;
import com.java.model.Category;
import com.java.model.User;
import com.java.service.UserService;

@Service
public class UserServiceImplement implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public Boolean checkUser(User user) {
		return userDao.checkUser(user);
	}

	@Override
	public ArrayList<Category> loadingMenu(User user) 
	{
		return userDao.loadingMenu(user);
	}

	@Override
	public Boolean checkExistUser(User user) {
		return userDao.checkExistUser(user);
	}

	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public int getIdByUsername(String username) {
		return userDao.getIdByUsername(username);
	}

	@Override
	public User getbyId(int id) {
		
		return userDao.getbyId(id);
	}

	@Override
	public List<User> getUsersByProjectId(int id) {
		return userDao.getUsersByProjectId(id);
	}

}
