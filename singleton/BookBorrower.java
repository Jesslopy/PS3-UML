/*
 * test program for singleton pattern 
 */

public class BookBorrower 
{
	public static void main (String [] args)
	{
		try
		{
			System.out.println("\nTrying to borrow a book");
			Book b = Book.borrowBook("Design Patterns");
			System.out.println("Here's what we have signed out: ");
			System.out.println(Book.booksSignedOut());
			System.out.println("\nTrying to borrow another book");
			Book b2 = Book.borrowBook("Designing with Objects");
			System.out.println("Here's what we have signed out: ");
			System.out.println(Book.booksSignedOut());
			System.out.println("\nWe're done with the first book.");
			Book.returnBook("Design Patterns");
			System.out.println("Here's what we now have signed out: ");
			System.out.println(Book.booksSignedOut());
			System.out.println("\nTrying to borrow a children's book");
			Book b3 = Book.borrowBook("The Phantom Tollbooth");
			System.out.println("Here's what we have signed out: ");
			System.out.println(Book.booksSignedOut());
			System.out.println("\nTrying to borrow another children's book");
			Book b4 = Book.borrowBook("Charlie and the Chocolate Factory");
			System.out.println("Here's what we have signed out: ");
			System.out.println(Book.booksSignedOut());
		}
		catch(BookLimitException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
