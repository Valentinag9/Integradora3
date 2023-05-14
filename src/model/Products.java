package model;
import java.util.Calendar;

public class Products {
    private String id;
    protected String name;
    protected int numPages;
    protected Calendar DatePost;
    private int readedPages;
    protected String URL;

    public Products( String name, int numPages, Calendar datePost, String URL) {
       
        this.name = name;
        this.numPages = numPages;
        this.DatePost = datePost;
        
        this.URL= URL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public Calendar getDatePost() {
        return DatePost;
    }

    public void setDatePost(Calendar datePost) {
        DatePost = datePost;
    }

    public int getReadedPages() {
        return readedPages;
    }

    public void setReadedPages(int readedPages) {
        this.readedPages = readedPages;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String ModifyBook() {
        return null;
    }

    
}
