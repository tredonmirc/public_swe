import static org.junit.Assert.*;
import org.junit.Test;


public class keywordTester {
	
	
	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("keywordTester");
		
	}
	
	public static Quote quote1() { 
		Quote quote1 = new Quote("Joseph Addison", "Don't tell me how hard you work. Tell me how much you get done.");
		return quote1;
	}
	public static Quote quote2() { 
		Quote quote2 = new Quote("Don Cunningham", "Eschew obfuscation!");
		return quote2;
	}
	public static Quote quote3() { 
		Quote quote3 = new Quote("H. L. Mencken", "For every problem there is one solution which is simple, neat, and wrong.");
		return quote3; 
	}
	public static Quote quote4() { 
		Quote quote4 = new Quote("Ramsey Clark","A right is not what someone gives you; it's what no one can take from you.");
		return quote4;
	}
	
	 public static QuoteList quoteList(){
		 QuoteList quoteList = new QuoteList();
		 
		 quoteList.setQuote(quote1());
		 quoteList.setQuote(quote2());
		 quoteList.setQuote(quote3());
		 quoteList.setQuote(quote4());
		 
		 return quoteList;
		 }



	//checks initial set up of quote/keyword - done
	@Test
	public void initial_setup(){
		assertEquals(0, quote1().getKeywords().size());      //size of arraylist keywords should be 0
	}
    /*
	//empty string was added/null was added, nothing returned
	@Test
	public void add_keyword_none_added(){
		quote1().addKeyword("");                           
		assertEquals(0, quote1().getKeywords().size());      //size of arraylist keywords should be 0
		quote1().addKeyword(null);
		assertEquals(0, quote1().getKeywords().size());      //size of arraylist keywords should be 0
	}

	//one key word added to quote1
	@Test
	public void add_keyword_1_added(){
		quote1().addKeyword("work");
		
		assertEquals(1, quote1().getKeywords().size());     //one element was added, size should be 1
		assertEquals("work", quote1().getKeywords().get(0));  //the first keyword = "work"
	}
	
	//one more key word added to quote1
	@Test
	public void add_keyword_multi_added(){
		quote1().addKeyword("tell");
		
		assertEquals(2, quote1().getKeywords().size());     //one element was added, size should be 1
		assertEquals("work", quote1().getKeywords().get(0));  //the first keyword = "work"
		assertEquals("tell", quote1().getKeywords().get(1));  //the first keyword = "tell"
	}
	
	//"tell" readded to quote1
	//should not change anything in quote
	@Test
	public void add_same_keyword(){
		quote1().addKeyword("tell");
		
		assertEquals(2, quote1().getKeywords().size());    
		assertEquals("work", quote1().getKeywords().get(0));  //the first keyword = "work"
		assertEquals("tell", quote1().getKeywords().get(1));  //the first keyword = "tell"
	}

	//a word that is not present in the list is trying to be deleted
	//should not affect the list at all
	@Test
	public void delete_element_not_found(){
		quote1().deleteKeyWord("hi");
		
		assertEquals(2, quote1().getKeywords().size());    
		assertEquals("work", quote1().getKeywords().get(0));  //the first keyword = "work"
		assertEquals("tell", quote1().getKeywords().get(1));  //the first keyword = "tell"
	}
	
	//tries deleting from an empty keyword list
	//returns empty list
	@Test
	public void delete_on_empty(){
		quote2().deleteKeyWord("work");
		
		assertEquals(0, quote2().getKeywords().size());   
	}
	
	
	//deletes keyword from a list containing only one element
	//returns empty list
	@Test
	public void delete_on_single(){
		quote3().addKeyword("problem");
		
		quote3().deleteKeyWord("problem");
		assertEquals(0, quote1().getKeywords().size());  //the size of the list after "problem" was deleted should be 0
	}
	
	//deletes an element from a list that has more than 1 element
	@Test
	public void delete_on_multiple(){
		quote1().deleteKeyWord("work");
		
		assertEquals(1, quote1().getKeywords.size());    
		assertEquals("tell", quote1().getKeywords().get(0));  //the first keyword is now "tell"
	}
	
	//searches all quotes to see how many user requested keywords are found
	//this one results in no key words being found
	//returns a quoteList of size 0
	@Test
	public void search_keywords_not_present(){
		quote1().addKeyword("you");
		quote3().addKeyword("problem");
		quote4().addKeyword("right");
		quote4().addKeyword("take");
		quote4().addKeyWord("you");
		
		//quote1 keywords: "tell", "you"
		//quote2 keywords:  N/A
		//quote3 keywords: "problem"
		//quote4 keywords: "right", "take", "you"
		
		assertEquals(0, (quoteList().searchForKeyWord("hi")).getSize());
	}
	
	//searches all quotes to find a keyword
	//one quote is found
	//returns quoteList containing that one quote
	@Test
	public void search_keyword_one_found(){
		
		assertEquals(1, (quoteList().searchForKeyWord("problem")).getSize());
		
		//searches for keyword "problem" in quoteList.
		//returns a quoteList containing 1 quote.
		//compares the quote from index 0 of that quoteList to appropriate quote
		
		assertEquals(quote3().toString(), quoteList().searchForKeyWord("problem").getQuote(0).toString());
	}
	
	//multiple quotes containing that keyword found 
	@Test
	public void search_keyword_multi_found(){
		
		assertEquals(2, (quoteList().searchForKeyWord("you")).getSize());
		
		assertEquals(quote1().toString(), quoteList().searchForKeyWord("you").getQuote(0).toString());
		assertEquals(quote4().toString(), quoteList().searchForKeyWord("you").getQuote(1).toString());
	}

	//quote has no keywords
	//returns nothing
	@Test
	public void retrieve_no_keyword_from_quote(){
		
		assertEquals(0, quote2().getKeyWords().getSize());
	}
	
	//quote has one keywords
	//returns list containing that one keyword
	@Test
	public void retrieve_one_keyword_from_quote(){
		
		assertEquals(1, quote3().getKeywords().getSize());
		
		assertEquals("problem", quote3().getKeywords().get(0));
	}
	
	//quote has multiple keywords
	//returns list containing all those keywords
	@Test
	public void retrieve_multi_keyword_from_quote(){
		//quote4 keywords: "right", "take", "you"
		
		assertEquals(3, quote4().getKeywords().getSize());
		
		assertEquals("right", quote4().getKeywords().get(0));
		assertEquals("take", quote4().getKeywords().get(1));
		assertEquals("you", quote4().getKeywords().get(2));
		
	}
    */
}