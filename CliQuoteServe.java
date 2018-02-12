class CliQuoteServe {

    private QuoteList quotelist;
    private String quotesFilename, xml_closure;


    public CliQuoteServe() {
        quotesFilename = "quotes.xml";
        xml_closure = "</quote-list>";
        QuoteSaxParser qParser = new QuoteSaxParser(quotesFilename);
        quotelist = qParser.getQuoteList();

        //Test Quote to add
        Quote test = new Quote();
        test.setAuthor("Tor Fredericks");
        test.setQuoteText("This shit better work");
        QuoteList testList = new QuoteList();
        testList.setQuote(test);

    }


    //Return a random quote from the list
    public String randomeQuote() {
        return convertString(quotelist.getRandomQuote());
    }

    public String[] searchQuote(String phrase, int mode) {
        QuoteList response = quotelist.search(phrase,mode);
        int resp_size = response.getSize();
        String[] converted_res = new String[resp_size];
        for (int i=0;i<resp_size;i++) {
            Quote quote = response.getQuote(i);
            converted_res[i] = convertString(quote);
        }
        return converted_res;
    }

    public void addQuotes(QuoteList quotes) {
        UpdateFile uf = new UpdateFile(quotesFilename, xml_closure);
        uf.addQuotes(quotes);
        try {
            uf.close();
        } catch (Exception ex) {
            System.out.println("Error updating quote list");
            ex.printStackTrace();
            return;
        }
    }

    /* Convert the quote to human readable
    *  @input: Quote to_convert
    *  @output: String Human readable quote string
     */
    public String convertString(Quote original) {
        StringBuilder sb = new StringBuilder();
        sb.append(original.getQuoteText());
        sb.append("\n- ");
        sb.append(original.getAuthor());
        return sb.toString();
    }


    //checks to see if a user's input is already in the list
    public boolean exactQuote(String userQuote, String userAuthor){
   
    //the author and quote will be saved as strings 
     String quote = userQuote.trim();
     String author = userAuthor.trim();
     //those strings are then converted into a quote
     Quote combinedQuote = new Quote(author, quote);

     //the quotes that will be searched from the list will be saved in this QuoteList
     QuoteList quotePresent = quotelist.search(quote,1);
     
     for(int qIndex=0; qIndex < quotePresent.getSize(); qIndex++ ){             //iterates through the quotes
    	 //if the quote from the quotePresent (.toString()) == the combinedQuote (.toString())
        if(quotePresent.getQuote(qIndex).toString().equals(combinedQuote.toString())){
         return true;
        }
     }
     return false;
    }
}