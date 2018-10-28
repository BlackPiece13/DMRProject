package com.dmr.dao;

import com.dmr.model.Book;

public class BookDAO extends GenericDAO<Book> {

	public BookDAO() {
		typeParameterClass = Book.class;
	}

}
