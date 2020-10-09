package com.java.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Project {
	private int project_id;
	private String project_name;
	private String project_description;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date due_date;

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getProject_description() {
		return project_description;
	}

	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", project_name=" + project_name + ", project_description="
				+ project_description + "]";
	}

}
