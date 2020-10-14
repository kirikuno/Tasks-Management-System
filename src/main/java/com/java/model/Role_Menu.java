package com.java.model;

public class Role_Menu {
	private String menu_id;
	private Role role_id;

	public Role_Menu() {
		super();
	}

	public Role_Menu(String menu_id, Role role_id) {
		super();
		this.menu_id = menu_id;
		this.role_id = role_id;
	}

	public String getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}

	public Role getRole_id() {
		return role_id;
	}

	public void setRole_id(Role role_id) {
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		return "Role_Menu [menu_id=" + menu_id + ", role_id=" + role_id + "]";
	}

}
