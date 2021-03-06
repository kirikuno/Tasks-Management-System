package com.java.model;

import java.sql.Date;

public class Task_Assigned {
	private int task_id;
	private User user_id;
	private int phase_id;
	private int status;
	private Date deadline;
	
	private Date finished_date;
	private String description;
	
	public Task_Assigned() {
		super();
		user_id = new User();
	}
	public Task_Assigned(int task_id, User user_id, int phase_id, int status, Date deadline, Date finished_date,
			String description) {
		super();
		this.task_id = task_id;
		this.user_id = user_id;
		this.phase_id = phase_id;
		this.status = status;
		this.deadline = deadline;
		this.finished_date = finished_date;
		this.description = description;
	}
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	public int getPhase_id() {
		return phase_id;
	}
	public void setPhase_id(int phase_id) {
		this.phase_id = phase_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	
	public Date getFinished_date() {
		return finished_date;
	}
	public void setFinished_date(Date finished_date) {
		this.finished_date = finished_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Task_Assigned [task_id=" + task_id + ", user_id=" + user_id + ", phase_id=" + phase_id + ", status="
				+ status + ", deadline=" + deadline + ",  finished_date=" + finished_date
				+ ", description=" + description + "]";
	}

}
