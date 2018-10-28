package com.dmr.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("COMMENT")
public class Comment extends Commentable {

	@ManyToOne
	private Commentable commentable;

	@ManyToOne
	private User user;

	private String value;

	public Commentable getCommentable() {
		return commentable;
	}

	public void setCommentable(Commentable commentable) {
		this.commentable = commentable;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
