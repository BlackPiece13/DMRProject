package com.dmr.dao;

import com.dmr.model.Commentable;

public class CommentableDAO extends GenericDAO<Commentable> {

	public CommentableDAO() {
		typeParameterClass = Commentable.class;
	}

}
