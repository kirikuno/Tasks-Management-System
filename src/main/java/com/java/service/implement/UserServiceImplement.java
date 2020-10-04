package com.java.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.UserDao;
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
	public Boolean checUser(User user) {
		return userDao.checUser(user);
	}

	@Override
	public ArrayList<String> loadingMenu(User user) 
	{
		return userDao.loadingMenu(user);
	}

}
