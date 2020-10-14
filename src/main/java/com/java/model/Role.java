package com.java.model;

import java.util.ArrayList;
import java.util.List;

public class Role {
	private String role_id;
	private String role_name;
	List<Role_Menu> role_menu=new ArrayList<Role_Menu>();
	List<Role_Author> role_author=new ArrayList<Role_Author>();
	
	public Role() {
		super();
	}

	public Role(String role_id, String role_name, List<Role_Menu> role_menu, List<Role_Author> role_author) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_menu = role_menu;
		this.role_author = role_author;
	}

	public List<Role_Author> getRole_author() {
		return role_author;
	}

	public void setRole_author(List<Role_Author> role_author) {
		this.role_author = role_author;
	}

	public List<Role_Menu> getRole_menu() {
		return role_menu;
	}

	public void setRole_menu(List<Role_Menu> role_menu) {
		this.role_menu = role_menu;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name + "]";
	}

}
