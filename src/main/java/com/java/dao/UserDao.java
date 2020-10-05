package com.java.dao;

import java.util.ArrayList;
import java.util.List;

import com.java.model.Category;
import com.java.model.User;

public interface UserDao {

	List<User> getAllUsers();
    Boolean checUser(User user);
	ArrayList<Category> loadingMenu(User user);
}
