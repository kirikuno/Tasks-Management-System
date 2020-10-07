package com.java.service;

import java.util.List;

import com.java.model.Role_Author;

public interface Role_AuthorService 
{
	void insertRole_Author(Role_Author ra);
	
	void insertRoleAuthors(List<Role_Author> roleAuthors);
}
