package com.java.model;

import java.util.Date;

public class Task {

	private int task_id;
	private String task_name;
	private String task_description;
	private String status;
	private Date due_date;
	private Project project_id;
	private User lead_id;
	
	public Task() {
		super();
	}
	public Task(int task_id, String task_name, String task_description, String status, Date due_date,
			Project project_id, User lead_id) {
		super();
		this.task_id = task_id;
		this.task_name = task_name;
		this.task_description = task_description;
		this.status = status;
		this.due_date = due_date;
		this.project_id = project_id;
		this.lead_id = lead_id;
	}
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public String getTask_description() {
		return task_description;
	}
	public void setTask_description(String task_description) {
		this.task_description = task_description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public Project getProject_id() {
		return project_id;
	}
	public void setProject_id(Project project_id) {
		this.project_id = project_id;
	}
	
	public User getLead_id() {
		return lead_id;
	}
	public void setLead_id(User lead_id) {
		this.lead_id = lead_id;
	}
	@Override
	public String toString() {
		return "Task [task_id=" + task_id + ", task_name=" + task_name + ", task_description=" + task_description
				+ ", status=" + status + ", due_date=" + due_date + ", project_id=" + project_id + ", lead_id="
				+ lead_id + "]";
	}
	
	
}
