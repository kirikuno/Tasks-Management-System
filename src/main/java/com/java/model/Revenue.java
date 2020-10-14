package com.java.model;

import java.sql.Date;

public class Revenue {
	private Date from_date;
	private Date to_date;
	private User user_id;
	private int finished_task_number;

	public Revenue() {
		super();
	}

	public Revenue(Date from_date, Date to_date, User user_id, int finished_task_number) {
		super();
		this.from_date = from_date;
		this.to_date = to_date;
		this.user_id = user_id;
		this.finished_task_number = finished_task_number;
	}

	public Date getFrom_date() {
		return from_date;
	}

	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}

	public Date getTo_date() {
		return to_date;
	}

	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public int getFinished_task_number() {
		return finished_task_number;
	}

	public void setFinished_task_number(int finished_task_number) {
		this.finished_task_number = finished_task_number;
	}

	@Override
	public String toString() {
		return "Revenue [from_date=" + from_date + ", to_date=" + to_date + ", user_id=" + user_id
				+ ", finished_task_number=" + finished_task_number + "]";
	}

}
