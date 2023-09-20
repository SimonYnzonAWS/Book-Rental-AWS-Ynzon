package bookrental;

import java.io.Serializable;

public class Book implements Serializable{
	private String title;
	private String author;
	private int yearPublished;
	private boolean isRented;
	
	public Book (String title, String author, int yearPublished) {
		this.title = title;
		this.author = author;
		this.yearPublished = yearPublished;
		this.isRented = false;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getYearPublished() {
		return yearPublished;
	}
	
	public boolean isRented() {
		return isRented;
	}
	
	public void rent() {
		isRented = true;
	}
	
	@Override
	public String toString() {
		return "Title: " + title + " Author: " + author + " Year Published: " + yearPublished + "\nIs Rented: " + isRented;
		
	}
	
	public int calculateFine() {
		return 0;
	}

}
