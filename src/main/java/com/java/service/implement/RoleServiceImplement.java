package com.java.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.RoleDao;
import com.java.model.Role;
import com.java.service.RoleService;

@Service
public class RoleServiceImplement implements RoleService {

	@Autowired
	RoleDao roleDao;
	
	@Override
	public List<Role> getAllRoles() {
		return roleDao.getAllRoles();
	}

}
