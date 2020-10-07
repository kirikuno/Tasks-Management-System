package com.java.model;

import java.sql.Date;

public class Task_Assigned {
	private String task_id;
	private String user_id;
	private String phase_id;
	private String status;
	private Date deadline;
	private Boolean home_flag;
	private Date finished_date;

	public String getTask_id() {
		return task_id;
	}

	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPhase_id() {
		return phase_id;
	}

	public void setPhase_id(String phase_id) {
		this.phase_id = phase_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Boolean getHome_flag() {
		return home_flag;
	}

	public void setHome_flag(Boolean home_flag) {
		this.home_flag = home_flag;
	}

	public Date getFinished_date() {
		return finished_date;
	}

	public void setFinished_date(Date finished_date) {
		this.finished_date = finished_date;
	}

	@Override
	public String toString() {
		return "Task_Assigned [task_id=" + task_id + ", user_id=" + user_id + ", phase_id=" + phase_id
				+ ", phase_status=" + status + ", deadline=" + deadline + ", home_flag=" + home_flag
				+ ", finished_date=" + finished_date + "]";
	}

}
