package com.java.model;

public class Category 
{
	private String menu_id;
	private String menu_name;
	private String menu_description;
	
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_description() {
		return menu_description;
	}
	public void setMenu_description(String menu_description) {
		this.menu_description = menu_description;
	}
	@Override
	public String toString() {
		return "Category [menu_id=" + menu_id + ", menu_name=" + menu_name + ", menu_description=" + menu_description
				+ "]";
	}
	

}
