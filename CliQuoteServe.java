class CliQuoteServe {

    private QuoteList quotelist;


    public CliQuoteServe() {
        String quotesFilename = "quotes.xml";
        QuoteSaxParser qParser = new QuoteSaxParser(quotesFilename);
        quotelist = qParser.getQuoteList();
    }


    //Return a random quote from the list
    public String randomeQuote() {
        return quotelist.getRandomQuote().toString();
    }

    public String[] searchQuote(String phrase, int mode) {
        QuoteList response = quotelist.search(phrase,mode);
        int resp_size = response.getSize();
        String[] converted_res = new String[resp_size];
        for (int i=0;i<resp_size;i++) {
            StringBuilder sb = new StringBuilder();
            Quote quote = response.getQuote(i);
            sb.append(quote.getQuoteText());
            sb.append("\n- ");
            sb.append(quote.getAuthor());
           converted_res[i] = sb.toString();
        }
        return converted_res;
    }

}