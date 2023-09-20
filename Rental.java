package bookrental;

import java.io.Serializable;

public class Rental implements Serializable{
	private Book book;
	
	public Rental(Book book) {
        this.book = book;
    }
	
	public Book getBook() {
        return book;
    }
}
