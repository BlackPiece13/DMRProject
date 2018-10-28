package com.dmr.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("USER")
public class User extends Person {

	@OneToMany(mappedBy = "user")
	private List<Comment> comments;

	private String Login;

	@Column(name = "password")
	private String pwd;
	private String mail;
	private String role;

	public User(String login, String pwd, String role, String mail) {
		super();
		Login = login;
		this.pwd = pwd;
		this.role = role;
		this.mail = mail;
	}

	public User() {
		super();
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
