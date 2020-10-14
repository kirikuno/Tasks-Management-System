package com.java.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int user_id;
	private String username;
	private String password;
	List<Task_Assigned> task_assigned = new ArrayList<Task_Assigned>();
	List<Task> task = new ArrayList<Task>();
	List<Role_Author> role_author = new ArrayList<Role_Author>();
	List<Revenue> Revenue = new ArrayList<Revenue>();

	public User() {
		super();
	}

	public User(int user_id, String username, String password, List<Task_Assigned> task_assigned, List<Task> task,
			List<Role_Author> role_author, List<com.java.model.Revenue> revenue) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.task_assigned = task_assigned;
		this.task = task;
		this.role_author = role_author;
		Revenue = revenue;
	}

	public List<Role_Author> getRole_author() {
		return role_author;
	}

	public void setRole_author(List<Role_Author> role_author) {
		this.role_author = role_author;
	}

	public List<Revenue> getRevenue() {
		return Revenue;
	}

	public void setRevenue(List<Revenue> revenue) {
		Revenue = revenue;
	}

	public List<Task_Assigned> getTask_assigned() {
		return task_assigned;
	}

	public void setTask_assigned(List<Task_Assigned> task_assigned) {
		this.task_assigned = task_assigned;
	}

	public int getUser_id() {
		return user_id;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + "]";
	}

}
