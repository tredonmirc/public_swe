import java.lang.reflect.Array;
import java.util.Scanner;

public class Menu {

	static Scanner in = new Scanner(System.in);
	static CliQuoteServe wrapper;
	static QuoteList ql;

	public static void main(String[] args) {
		System.out.println("Welcome to the Quotes Server");
		menu();
	}

	private static void menu() {

		wrapper = new CliQuoteServe();
		ql = wrapper.getQuoteList();
		int input = 0;
		while (input != 6) {
			System.out.println("Please pick an option: \n" + "1. Get a random Quote \n" + "2. Search for a Quote \n"
					+ "3. Add a new Quote \n" + "4. Add Keyword to Quote\n" + "5. Search for quote by keyword \n" + "6. Exit");

			try {
				input = Integer.parseInt(in.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid Entry:  Please enter a number");
			}

			if (input == 1) {
				String quote = wrapper.randomeQuote();
				if (quote == null) {
					System.out.println("No quote found");
				} else {
					System.out.println(quote);
				}
			} else if (input == 2) {
				searchMenu();
			} else if (input == 3) {
				addQuotes();
			} else if (input == 4) {
				addKeyword();
			} else if (input == 5) {
				keywordSearch();
			} else if (input == 6) {
				System.out.println("Goodbye! Come back again");
			} else {
				System.out.println("That is not a valid option. Please choose again");
			}
		}
	}

	/*Search existing lists for keywords
	 */
	public static void keywordSearch() {
		System.out.println("What keyword would you like to search for?");
		String word = in.nextLine();
		QuoteList withKeyword = ql.searchForKeyword(word);
		if (withKeyword.getSize() == 0) {
			System.out.println("No matches found");
		} else {
			System.out.println("Quotes with matching keywords:");
			for (int i=0;i<withKeyword.getSize();i++) {
				System.out.println(withKeyword.getQuote(i).toString());
			}
		}
	}

	/* Add a keyword to an existing quote in our list
	   If the quote list is empty, do nothing.  Otherwise add the keyword to the quote
	 */
	public static void addKeyword() {
		System.out.println("These are the current quotes");
		int ql_size = ql.getSize();
		if (ql_size == 0) {
			System.out.println("There are no quotes, please add one first");
		}
		else {
			for (int i = 0; i < ql_size; i++) {
				System.out.println(i + ": " + ql.getQuote(i).toString());
			}
			System.out.println(ql_size+": Nevermind, I changed my mind");
			System.out.print("Which quote would you like to add a keyword too: ");
			int input = 0;
			try {
				input = Integer.parseInt(in.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid Entry: Please select a number from the list");
			}
			if (input == ql_size) {
				return;
			}
			System.out.print("Enter Keyword: ");
			String new_word = in.nextLine();
			if (ql.getQuote(input).addKeyword(new_word)) {
				System.out.println("Keyword added successfully");
				System.out.println(ql.getQuote(input).toString());
			} else {
				System.out.println("Keyword not added: duplicate or invalid");
			}
		}

	}

	private static void searchMenu() {

		int input = 0;
		while (input != 4) {
			System.out.println("Please pick an option: \n" + "1. Search by author \n" + "2. Search by quote \n"
					+ "3. Both \n" + "4. Exit");

			try {
				input = Integer.parseInt(in.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid Entry:  Please enter a number");
			}

			int adjusted = input - 1;
			if (adjusted == 0 || adjusted == 1 || adjusted == 2) {
				System.out.println("What would you like to search for: ");
				String phrase = in.nextLine();
				String[] array = wrapper.searchQuote(phrase, adjusted);
				if (array.length == 0) {
					System.out.println("No quote found");
				} else {
					for (int i = 0; i < array.length; i++) {
						System.out.println(array[i] + "\n");
					}
				}
			} else {
				System.out.println("That is not a valid option. Please choose again");
			}
		}
	}

	private static void addQuotes() {
		int input = 1;

		while (input == 1) {
			System.out.println("Please enter your quote");
			String quote = in.nextLine();
			System.out.println("Please enter the author for the quote");
			String author = in.nextLine();
			
			//if false returned, than quote or author is null or empty 
			quoteCheck qc = new quoteCheck(); 

			if (qc.check(author, quote) == false) {
				System.out.println("Entry is invalid");
			} else {
				if (wrapper.exactQuote(quote, author) == true) {
					System.out.println("Quote Already Exists");
				} else {
					Quote q = new Quote();
					q.setQuoteText(quote);
					q.setAuthor(author);
					ql.setQuote(q);
				}
			}
			
			System.out.println("1.Continue to add quotes \n" +
					"2. Exit");
			try {
				input = Integer.parseInt(in.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid Entry:  Please enter a number");
			}
			//The user is finished adding quotes - time to update the file
			UpdateFile uf = new UpdateFile("quotes.xml","</quote-list>");
			uf.addQuotes(ql);
			try {
				uf.close();
			} catch (Exception ex) {
				System.out.println("Problem updating the file - aborted");
				ex.printStackTrace();
			}
		}
	} 
}
