package com.java.model;

public class Role_Author {
	private User user_id;
	private Role role_id;
	
	public Role_Author(User user_id, Role role_id) {
		super();
		this.user_id = user_id;
		this.role_id = role_id;
	}
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	public Role getRole_id() {
		return role_id;
	}
	public void setRole_id(Role role_id) {
		this.role_id = role_id;
	}
	public Role_Author() {
		super();
	}
	

}
