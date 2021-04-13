package com.example.booklendingservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	@Id
	@Column(name="bookid")
	private int bookId;
	@Column(name="title")
	private String title;
	@Column(name="authorlastname")
	private String authorLastName;
	@Column(name="authorfirstname")
	private String authorFirstName;
	@Column(name="phone")
	private String phone;
	@Column(name="rating")
	private int rating;
	
	public Book() {
		super();
	}
	public Book(
			String title
			, String authorLastName
			, String authorFirstName
			, String phone
			, int rating) {
		super();
		this.title = title;
		this.authorLastName = authorLastName;
		this.authorFirstName = authorFirstName;
		this.phone = phone;
		this.rating = rating;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorLastName() {
		return authorLastName;
	}
	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}
	public String getAuthorFirstName() {
		return authorFirstName;
	}
	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
