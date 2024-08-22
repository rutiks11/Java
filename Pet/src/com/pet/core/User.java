package com.pet.core;

public class User {
<<<<<<< HEAD
	private int idgenerator = 0;
=======
	private int idgenerator=0;
>>>>>>> 8e2a1003d252cedbeeab6e2450d43858461298d1
	private int id;
	private String name;
	private String password;
	private Role role;
<<<<<<< HEAD

	public User() {
		super();
	}

	public User(String name) {

		this.name = name;
	}

=======
	public User() {
		super();
	}
>>>>>>> 8e2a1003d252cedbeeab6e2450d43858461298d1
	public User(String name, String password, Role role) {
		super();
		this.id = ++idgenerator;
		this.name = name;
		this.password = password;
		this.role = role;
	}
<<<<<<< HEAD

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

=======
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
>>>>>>> 8e2a1003d252cedbeeab6e2450d43858461298d1
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", role=" + role + "]";
	}
<<<<<<< HEAD

	@Override
	public boolean equals(Object o) {
		User user = (User) o;

		if (o instanceof User) {
			return this.name.equals(user.getName());
		}
		return false;
	}

=======
	
	
>>>>>>> 8e2a1003d252cedbeeab6e2450d43858461298d1
}
