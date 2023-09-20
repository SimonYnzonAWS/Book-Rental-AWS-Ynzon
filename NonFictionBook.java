package bookrental;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class NonFictionBook extends Book {

	public NonFictionBook(String title, String author, int yearPublished) {
		super(title, author, yearPublished);
	}

	@Override
	public int calculateFine() {
		final int FINE_PER_DAY = 5;
		final int MAX_FINE_DAYS = 14;
		
		if(isRented()) {
			LocalDate dueDate = LocalDate.now().plusDays(MAX_FINE_DAYS);
			LocalDate returnDate = LocalDate.of(2023, 12, 25);
			
			System.out.println("Due date: " + dueDate);
			System.out.println("Return date: " + returnDate);
			
			if(returnDate.isAfter(dueDate)) {
				
				long fineDays = ChronoUnit.DAYS.between(LocalDate.now(), dueDate);
				
				return (int) (fineDays * FINE_PER_DAY);
			}
		}
		
		return 0;
	}
}
