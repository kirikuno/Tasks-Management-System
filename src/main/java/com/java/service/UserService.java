package com.java.service;

import java.util.ArrayList;
import java.util.List;

import com.java.model.User;

public interface UserService {
  List<User> getAllUsers();
  Boolean checUser(User user);
  ArrayList<String> loadingMenu(User user);
}
