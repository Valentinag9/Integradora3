package model;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Products {
    private String id;
    protected String name;
    private int numreadedPages;
    private Calendar DatePost;
    private int readedPages;

    public Products(String id, String name, int numreadedPages, Calendar datePost, int readedPages) {
        this.id = id;
        this.name = name;
        this.numreadedPages = numreadedPages;
        this.DatePost = datePost;
        this.readedPages = readedPages;
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
        return numreadedPages;
    }

    public void setNumPages(int numPages) {
        this.numreadedPages = numPages;
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

    
}
