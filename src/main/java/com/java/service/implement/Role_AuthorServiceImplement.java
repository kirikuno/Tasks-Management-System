package com.java.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.Role_AuthorDao;
import com.java.model.Role_Author;
import com.java.service.Role_AuthorService;

@Service
public class Role_AuthorServiceImplement implements Role_AuthorService {

	@Autowired
	Role_AuthorDao roleAuthorDao;
	
	@Override
	public void insertRole_Author(Role_Author ra) 
	{
		roleAuthorDao.insertRole_Author(ra);
	}

}
