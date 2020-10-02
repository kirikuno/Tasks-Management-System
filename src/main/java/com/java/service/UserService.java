package com.java.service;

import java.util.List;

import com.java.model.User;

public interface UserService {
  List<User> getAllUsers();
  Boolean checUser(User user);
}
