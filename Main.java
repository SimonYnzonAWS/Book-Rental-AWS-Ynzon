package bookrental;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Main {
	static ArrayList<Rental> rentedBook = new ArrayList<>();
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		Book[] library = new Book[] {
				new FictionBook("Fictional Title 1", "Author 1", 2000),
				new FictionBook("Fictional Title 2", "Author 2", 2001),
				new NonFictionBook("NonFictional Title 1", "Author 3", 2002),
				new NonFictionBook("NonFictional Title 2", "Author 4", 2003)
		};
		
		library[1].rent();
		library[2].rent();
		
		for(Book book : library) {
			System.out.println(book);
			System.out.println();
		}
		
		for(Book book : library) {
			if (book.isRented()) {
				System.out.println("The fine for " + book.getTitle() + " is " + book.calculateFine());
				System.out.println();
				
				rentedBook.add(new Rental(book));
			}
		}
	
		fileHandle();
	
	}
	
	public static void fileHandle() throws IOException, ClassNotFoundException {
		
		FileOutputStream fos= new FileOutputStream("D:\\JavaReadOutputFiles\\numbers.txt");
		ObjectOutputStream oos= new ObjectOutputStream(fos);
		System.out.println("Successfully saved the rented books to the file...uwu");
		
		oos.writeObject(rentedBook);
		oos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("D:\\JavaReadOutputFiles\\numbers.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ArrayList<Rental> deserialized = (ArrayList) ois.readObject();
		System.out.println("\nViewing the rented books from the file..uwu\n");
		
		for(Rental rented : deserialized) {
			Book rentedBook = rented.getBook();
			
			System.out.println("Title: " + rentedBook.getTitle());
			System.out.println("Author: " + rentedBook.getAuthor());
			System.out.println("Year Published: " + rentedBook.getYearPublished());
			System.out.println("Fine: " + rentedBook.calculateFine());
			System.out.println("");
		}
		
	}
}
