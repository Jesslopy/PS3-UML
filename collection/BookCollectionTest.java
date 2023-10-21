/* 
 * program for testing BookCollection
 */

public class BookCollectionTest
{
	public static void main (String [] args)
	{
		try
		{
			// store banned books
			String [] banned = {"Catcher in the Rye", "To Kill a Mockingbird",
				"Grapes of Wrath", "Brave New World"};
			for (int i = 0; i < banned.length; i++)
			{
				Book.addBannedTitle(banned[i]);
			}

			// create book collection
			BookCollection books = new BookCollection();
			Book b1 = new NonFiction();
			Book b2 = new Fiction("And Then There Were None", 288, "black", 
				Genre.MYSTERY);
			Book b3 = new Fiction("Harry Potter and the Sorcerer's Stone", 
				223, "brown", Genre.FANTASY);
			Book b4 = new NonFiction();
			Book b5 = new Fiction(); 
			Book b6 = new NonFiction("Mastering the Art of French Cooking", 
				68, "green", 641);
			Book b7 = new Fiction("Inimitable Jeeves", 253, "ecru", 
				Genre.HUMOR);
			Book b8 = new Fiction("Murder of Roger Ackroyd", 288, "black", 
				Genre.MYSTERY);
			Book [] toAdd = {b1, b2, b3, b4, b5, b6, b7, b8};
			for (Book b: toAdd)
			{
				books.addBook(b);
			}

			// display books in collection
			System.out.println("Here are the books in our collection:\n\n" 
				+ books.toString());

			// store and retrieve current favorite book
			books.setFavoriteBook(b8);
			System.out.println("Our favorite book used to be a fiction one:\n" 
				+ books.getFavoriteBook().getTitle());
			books.setFavoriteBook(b6);
			System.out.println("\nNow it's a non-fiction one:\n" 
				 + books.getFavoriteBook().getTitle());

			// try to add banned book to collection
			System.out.println("\nLet's add 'Brave New World' to our"
				+ " collection");
			Book b9 = new Fiction("Brave New World", 234, "black",
				Genre.FANTASY);
			books.addBook(b9);
		}
		catch (BannedBookException e)
		{
			System.out.println(e.getMessage());	
		}
	}
}
