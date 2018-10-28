package com.dmr.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity 
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("AUTHOR")
public class Author extends Person {

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "books_id")
	@JoinTable(joinColumns = @JoinColumn(name = "author_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
	private List<Book> books;
	@ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
	private List<Media> medias;

	public List<Book> getBook() {
		return books;
	}

	public void setBook(List<Book> books) {
		this.books = books;
	}

	public Author() {
		super();
	}

	public Author(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}

	public Author(String firstName, String lastName, List<Book> books) {
		setFirstName(firstName);
		setLastName(lastName);
		this.books = books;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Media> getMedias() {
		return medias;
	}

	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}

}