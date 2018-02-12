
//checks the author and quote to verify that it is valid to insert


public class quoteCheck {
	
	String author;
	String quote;
	
	boolean isAuthorOk = true;
	boolean isQuoteOk = true;
	
	
	public quoteCheck(){}      //constructor to be called from main 
	

	public boolean check(String userAuthor, String userQuote){     //collects the author and quote sent in from main
		
		author = userAuthor;
		quote = userQuote;
		
		checkAuthor();
		checkQuote();
		
		return (isAuthorOk && isQuoteOk);
	}
	
	public void checkAuthor(){        //checks to see if author is valid
		
		if((author == null) || (author == "")){
			System.out.println("Author field must not be empty");
			isAuthorOk = false;
			return;
		}
	}
	
	public void checkQuote(){        //checks to see if quote is valid 
		
		if((quote == null) || (quote == "")){
			System.out.println("Quote field must not be empty");
			isQuoteOk = false;
			return;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
