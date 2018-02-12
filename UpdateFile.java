/* Code heavily references: https://kodehelp.com/remove-line-file-java/ */
/*  Author: Tor Fredericks
    Date: 2/11/2017
 */

import java.io.*;

public class UpdateFile implements Closeable{

    private String xml_close;
    private String filename;
    private File orig_file, temp_file;
    private BufferedReader br;
    private PrintWriter pw;
    boolean empty;


    public UpdateFile(String filename,String xml_closure) {

        xml_close = xml_closure;
        this.filename = filename;

        orig_file = new File(filename);
        if (!orig_file.isFile()) {
            System.out.println("Error loading file");
            return;
        }

        temp_file = new File("quotes.tmp");
        int count = 0;

        //Read the original xml file and build the tmp file without the XML
        //closure
        try {
            br = new BufferedReader(new FileReader(orig_file));
            pw = new PrintWriter(new FileWriter(temp_file));
            String line;

            //Read each line in the xml file and if delete the closure phrase
            //This will allow us to add more to the xml file before we write
            //an close it
            while ( (line = br.readLine()) != null) {
               count++;
               if (!line.contentEquals(xml_closure)) {
                   pw.print(line);
                   pw.print(System.getProperty("line.separator"));
                   pw.flush();
               }
            }
            br.close();

        } catch (Exception e) {
            System.out.println("Problems in opening the file for edit");
            e.printStackTrace();
        }
        if (count==0)
            empty = true;
    }

    public void addQuotes(QuoteList quotes) {
        if (quotes.getSize()==0) {
            System.out.println("Nothing to add");
        }
        StringBuilder sb = new StringBuilder();
        if (empty) {
            sb.append("<?xml version-\"1.0\"");
            sb.append(System.getProperty("line.separator"));
            sb.append("<quote-list>");
            sb.append(System.getProperty("line.separator"));
        }
        int list_len = quotes.getSize();
        for (int i=0;i<list_len;i++) {
            Quote quote = quotes.getQuote(i);
           sb.append("   <quote>");
           sb.append(System.getProperty("line.separator"));
           sb.append("      <quote-text>"+ quote.getQuoteText()+"</quote-text>");
           sb.append(System.getProperty("line.separator"));
           sb.append("      <author>"+ quote.getAuthor()+"</author>");
           sb.append(System.getProperty("line.separator"));
           sb.append("   </quote>");
           sb.append(System.getProperty("line.separator"));
        }

        //Try to write the StringBuilder to the printwriter
       try {
          pw.print(sb.toString());
       } catch (Exception e) {
           System.out.println("Problem building new quotes; quiting");
           return;
       }
    }

    /* This will enforce the closing of the file once the ops are complete
     */
    @Override
    public void close() throws IOException {
        try {
            //We're done updating the file, close the print writer
            pw.print("</quote-list>");
            pw.print(System.getProperty("line.separator"));
            pw.close();
            File path = orig_file.getAbsoluteFile();
            //Delete the old file.
            if (!orig_file.delete()) {
                System.out.println("Cannot delete original file - update canceled");
                return;
            }
            //Rename the temp file to the original
            if (!temp_file.renameTo(path)) {
                System.out.println("Cannot rename temp file - update cancelled");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}