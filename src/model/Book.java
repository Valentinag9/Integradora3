package model;

import java.net.URL;
import java.util.Calendar;

public class Book extends Products {
    private String review; 
    private Genre genre;
    private double priceB;
  
    public Book( String code,String name, int numPages, Calendar datePost,String URL,String review,int genre, double priceB) {
        super( code, name, numPages, datePost, URL);

        this.review= review;
        setGenre(genre);
        this.priceB= priceB;
   
    }
    public Book(Book copyBook){
        super(copyBook.getCode(),copyBook.getName(),copyBook.getNumPages(),copyBook.getDatePost(),copyBook.getURL());
        this.review = getReview();
        this.priceB= getPriceB();
        this.genre = getGenre();
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
    public void setGenre(int genre) {
        Genre typegenre;
			
        if(genre==1){
        typegenre= Genre.FICTION_SCIENCE;
        }else if(genre==2){
        typegenre= Genre.FANTASY;
        }else {
        typegenre= Genre.HISTORICAL_NOVEL;
        }
        this.genre = typegenre;
    }

    public double getPriceB() {
        return priceB;
    }
    public void setPriceB(double priceB) {
        this.priceB = priceB;
    }

    public String toString() {

		String msg = "";

	
        msg = "\nId: "+ code+"\nName: " + name + "\nNumber of Pages: " + numPages + "\nURL " + URL + "\nReview: " + review + "\nGenre: " + genre + "\nPrice: " + priceB;

		return msg;

	}
}
