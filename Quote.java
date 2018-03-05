import java.util.ArrayList;
import java.util.List;

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

   public int keywordLocation(String keyword) {
       return (keywords.indexOf(keyword));
   }

   // Getter for keywords
   public ArrayList<String> getKeywords() {
       //String vals = String.join(", ",this.keywords);
       //System.out.println("Keywords: "+vals + " count: "+this.keywords.size());
      return (this.keywords);
   }

   public Boolean deleteKeyword(String keyword) {
       int location;
       if ((location = keywords.indexOf(keyword.toLowerCase())) != -1) {
           keywords.remove(location);
           return Boolean.TRUE;
       }
       return (Boolean.FALSE);
   }

   public void addKeyword(String new_keyword) {
      if (new_keyword != null &&
              !new_keyword.equals("") &&
              !keywords.contains(new_keyword.toLowerCase())
              ) {
          this.keywords.add(new_keyword.toLowerCase());
          //System.out.println("Added keyword: "+new_keyword+"| "+this.keywords.toString()+"| Totals: "+this.keywords.size());
      }
   }

   @Override
   public String toString ()
   {
      return "Quote {" + "author='" + author + '\'' + ", quoteText='" + quoteText + '\'' + '}';
   }
}
