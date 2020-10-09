package com.java.model;

import java.util.Date;

public class Task {

	private String task_id;
	private String task_name;
	private String task_description;
	private String status;
	private Date due_date;
	private String create_date;
	public String getTask_id() {
		return task_id;
	}
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
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
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	
	public String getTask_description() {
		return task_description;
	}
	public void setTask_description(String task_description) {
		this.task_description = task_description;
	}
	@Override
	public String toString() {
		return "Task [task_id=" + task_id + ", task_name=" + task_name + ", task_description=" + task_description
				+ ", status=" + status + ", due_date=" + due_date + ", create_date=" + create_date + "]";
	}
	
	
}
