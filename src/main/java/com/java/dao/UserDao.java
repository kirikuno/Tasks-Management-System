package com.java.dao;

import java.util.ArrayList;
import java.util.List;

import com.java.model.Category;
import com.java.model.User;

public interface UserDao {

	List<User> getAllUsers();
    Boolean checkUser(User user);
	ArrayList<Category> loadingMenu(User user);
	Boolean checkExistUser(User user);
	void insertUser(User user);
	int getIdByUsername(String username);
	User getbyId(int id);
	List<User> getUsersByProjectId(int id);
}
