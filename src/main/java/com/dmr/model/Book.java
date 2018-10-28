package com.dmr.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BOOK")
public class Book extends Media {

	/* temporaire **/
	private String author;
	private String title;
	private String resume;
	/**/
	@Embedded
	private Cover cover;

	public Book() {

	}

	public Book(String title, String auteur) {
		this.title = title;
	}

	public Book(String title, List<Author> authors, Cover cover) {
		super();
		this.title = title;
		this.cover = cover;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public Cover getCover() {
		return cover;
	}

	public void setCover(Cover cover) {
		this.cover = cover;
	}

}
