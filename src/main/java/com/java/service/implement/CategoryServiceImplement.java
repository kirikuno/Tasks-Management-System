package com.java.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.CategoryDao;
import com.java.model.Category;
import com.java.service.CategoryService;

@Service
public class CategoryServiceImplement implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public List<Category> getAllMenu() {
		return categoryDao.getAllMenu();
	}

	@Override
	public Category getMenuById(String id) {
		return categoryDao.getMenuById(id);
	}

}
