package model;

import java.net.URL;
import java.util.Calendar;

public class Book extends Products {
    private String review; 
    private Genre genre;
    private double priceB;
  
    public Book( String name, int numPages, Calendar datePost,String URL,String review,int genre, double priceB) {
        super( name, numPages, datePost, URL);
        this.review= review;
        this.priceB= priceB;
   

    }
  
    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }
    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public double getPriceB() {
        return priceB;
    }
    public void setPriceB(double priceB) {
        this.priceB = priceB;
    }

    public String toString() {

		String msg = "";

	
        msg = "\nName: " + name + "\nNumber of Pages " + numPages + "\nURL " + URL + "\nReview" + review + "\nGenre" + genre + "Price" + priceB;

		return msg;

	}

    

    
}
