package model;

import java.util.Calendar;

public class Book extends Products {
    private String review; 
    private Genre genre;
    private String urlb;
    private double priceB;
    private int numSouldB;
  
    public Book(String id, String name, int numPages, Calendar datePost, int readedPages,String review,Genre genre, String urlb, double priceB,int numSouldB) {
        super(id, name, numPages, datePost, readedPages);
        this.review= review;
        this.genre= genre;
        this.urlb= urlb;
        this.priceB= priceB;
        this.numSouldB= numSouldB;
   

    }
    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }
    public Genre getGender() {
        return genre;
    }
    public void setGender(Genre gender) {
        this.genre = gender;
    }
    public String getUrlb() {
        return urlb;
    }
    public void setUrlb(String urlb) {
        this.urlb = urlb;
    }
    public double getPriceB() {
        return priceB;
    }
    public void setPriceB(double priceB) {
        this.priceB = priceB;
    }
    public int getNumSouldB() {
        return numSouldB;
    }
    public void setNumSouldB(int numSouldB) {
        this.numSouldB = numSouldB;
    }

    
}
