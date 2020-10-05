package com.java.service;

import java.util.List;

import com.java.model.Category;

public interface CategoryService {
     List<Category> getAllMenu();
     Category getMenuById(String id);
}
