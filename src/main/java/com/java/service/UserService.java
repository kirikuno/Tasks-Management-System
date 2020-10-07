package com.java.service;

import java.util.ArrayList;
import java.util.List;

import com.java.model.Category;
import com.java.model.User;

public interface UserService {
  List<User> getAllUsers();
  Boolean checkUser(User user);
  Boolean checkExistUser(User user);
  ArrayList<Category> loadingMenu(User user);
  void insertUser(User user);
  int getIdByUsername(String username);
}
