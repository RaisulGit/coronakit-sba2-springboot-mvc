package com.eval.coronakit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {	
	@Id
	@Column(insertable = true)
	private String username;
	
	@Column
	private String password;
	@Column
	private boolean enabled;
	@Column	
	private String email;
	
	@Column
	private String contact;
	//Added by Raisul Alam
	public User(String username, String password, boolean enabled, String email, String contact) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.email = email;
		this.contact = contact;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
}
