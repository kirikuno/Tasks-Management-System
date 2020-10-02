package com.java.model;

public class Task {

	private String task_id;
	private String task_name;
	private String status;
	private String due_date;
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
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	
	
	@Override
	public String toString() {
		return "Task [task_id=" + task_id + ", task_name=" + task_name + ", status=" + status + ", due_date=" + due_date
				+ ", create_date=" + create_date + "]";
	}
	
	
}