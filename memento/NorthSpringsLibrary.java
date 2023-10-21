/* 
 * test program for memento pattern
 */

import java.util.Map;
import java.util.HashMap;


public class NorthSpringsLibrary
{
	/*
	 * calculates the circulation of a book for a five-year period 
	 * starting with the current year 
	 */

	public static int getFiveYearCirculation(Book b, 
		Map<Integer, Book.Memento> c)
	{
		int count = 0;
		for (int i = c.size()-1; i >= c.size()-5; i--)
		{
			b.restoreState(c.get(i));
			count+= b.saveState().getSavedBorrowers();
		}
		return count;
	}

    public static void main(String[] args)
	{
		// first book
		Map<Integer, Book.Memento> bookCirculation = new HashMap<>();
		Book b1 = new Book("Designing with Objects", 1, 1);
		bookCirculation.put(0, b1.saveState());
		b1 = new Book("Designing with Objects", 2, 3);	
		bookCirculation.put(1, b1.saveState());
		b1 = new Book("Designing with Objects", 3, 5);	
		bookCirculation.put(2, b1.saveState());
		b1 = new Book("Designing with Objects", 4, 0);	
		bookCirculation.put(3, b1.saveState());
		b1 = new Book("Designing with Objects", 5, 2);	
		bookCirculation.put(4, b1.saveState());
		System.out.println("\nHere's the circulation for " + b1.getTitle() 
			+ " for the past five years:\n");
		System.out.printf("%-7s%s\n", "year", "circulation");;
		System.out.println(b1.getCurrentCirculation());	
		for (int i = 3; i >= 0; i--)
		{
			b1.restoreState(bookCirculation.get(i));
			System.out.println(b1.getCurrentCirculation());
		}	
		int circulation = getFiveYearCirculation(b1, bookCirculation);	
		String result = (circulation != 0) ? "" : " not";
		System.out.println("\nThat book has been signed out " + circulation
			+ " times, so we will" + result + " keep it in our collection.");

		// second book
		bookCirculation = new HashMap<>();
		Book b2 = new Book("C++ for Beginners", 1, 0);
		bookCirculation.put(0, b2.saveState());
		b2 = new Book("C++ for Beginners", 2, 0);	
		bookCirculation.put(1, b2.saveState());
		b2 = new Book("C++ for Beginners", 3, 0);	
		bookCirculation.put(2, b2.saveState());
		b2 = new Book("C++ for Beginners", 4, 0);	
		bookCirculation.put(3, b2.saveState());
		b2 = new Book("C++ for Beginners", 5, 0);	
		bookCirculation.put(4, b2.saveState());
		System.out.println("\nHere's the circulation for " + b2.getTitle() 
			+ " for the past five years:\n");
		System.out.printf("%-7s%s\n", "year", "circulation");
		System.out.println(b2.getCurrentCirculation());	
		for (int i = 3; i >= 0; i--)
		{
			b2.restoreState(bookCirculation.get(i));
			System.out.println(b2.getCurrentCirculation());
		}	
		circulation = getFiveYearCirculation(b2, bookCirculation);	
		result = (circulation != 0) ? "" : " not";
		System.out.println("\nThat book has been signed out " + circulation
			+ " times, so we will" + result + " keep it in our collection.");
	}
}
