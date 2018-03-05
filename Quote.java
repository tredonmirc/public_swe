import java.util.ArrayList;

/**
 * Quote data object.
 * @author Mongkoldech Rajapakdee & Jeff offutt
 *         Date: Nov 2009
 * A quote has two parts, an author and a quoteText.
 * This bean class provides getters and setters for both, plus a toString()
 */
public class Quote
{
   private String author;
   private String quoteText;
   private ArrayList<String> keywords;

   // Default constructor does nothing
   public Quote ()
   {
      this.keywords = new ArrayList<>();
   }

   // Constructor that assigns both strings
   public Quote (String author, String quoteText)
   {
      this.author = author;
      this.quoteText = quoteText;
      this.keywords = new ArrayList<>();
   }

   // Getter and setter for author
   public String getAuthor ()
   {
      return author;
   }
   public void setAuthor (String author)
   {
      this.author = author;
   }

   // Getter and setter for quoteText
   public String getQuoteText ()
   {
      return quoteText;
   }
   public void setQuoteText (String quoteText)
   {
      this.quoteText = quoteText;
   }

   // Getter for keywords
   public ArrayList<String> getKeywords() {
      return keywords;
   }

   public void addKeyword(String new_keyword) {
      if (new_keyword != null && new_keyword != "")
         keywords.add(new_keyword);
   }

   @Override
   public String toString ()
   {
      return "Quote {" + "author='" + author + '\'' + ", quoteText='" + quoteText + '\'' + '}';
   }
}
