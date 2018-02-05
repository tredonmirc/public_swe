import java.util.Scanner;

public class Menu {

	static Scanner in = new Scanner(System.in);
	
	public static void main(String [] args) {
		System.out.println("Welcome to the Quotes Server");
		menu(); 
	}

	private static void menu(){

		CliQuoteServe wrapper = new CliQuoteServe();
		int input = 0;
		while (input != 3) {
			System.out.println("Please pick an option: \n"
					+ "1. Get a random Quote \n"
					+ "2. Search for a Quote \n"
					+ "3. Exit");

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
				System.out.println("Goodbye! Come back agian");
			} else {
				System.out.println("That is not a valid option. Please choose again");
			}
		}
	}
	
	private static void searchMenu(){

		CliQuoteServe wrapper2 = new CliQuoteServe();
		int input = 0;
		while(input != 4) {
			System.out.println("Please pick an option: \n"
					+ "1. Search by author \n"
					+ "2. Search by quote \n"
					+ "3. Both \n"
					+ "4. Exit");

			try {
				input = Integer.parseInt(in.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid Entry:  Please enter a number");
			}

			int adjusted = input-1;
			if (adjusted == 0 || adjusted == 1 || adjusted == 2) {
				System.out.println("What would you like to search for: ");
				String phrase = in.nextLine();
				String[] array = wrapper2.searchQuote(phrase, adjusted);
				if (array.length == 0) {
					System.out.println("No quote found");
				} else {
					for (int i = 0; i < array.length; i++) {
						System.out.println(array[i]+"\n");
					}
				}
			} else {
				System.out.println("That is not a valid option. Please choose again");
			}
		}
	}
}
