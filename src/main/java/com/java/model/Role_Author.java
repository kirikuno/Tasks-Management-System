package com.java.model;

public class Role_Author {
	private int user_id;
	private String role_id;
	
	public Role_Author()
	{
		this.user_id = 2;
	    this.role_id = "R1";
	}

	public Role_Author(int user_id, String role_id) {
		this.user_id = user_id;
		this.role_id = role_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		return "Role_Author [user_id=" + user_id + ", role_id=" + role_id + "]";
	}

}
