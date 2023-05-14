package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class ControllerB {
    private ArrayList<User> users;
    private ArrayList<Products> products;

    public ControllerB(){
        users = new ArrayList<>();
        products = new ArrayList<>();
    }

    /**
        * Register a new user in the system.
        *
        * @param nameU The name of the user to register.
        * @param cc The identification number of the user to register.
        * @param optionRegister The registration option that determines the type of user.
        * It must be 1 for a Regular user and 2 for a Premium user.
        * @return true if the user registration was successful and added to the user collection,
        * false otherwise.
    */

    public boolean registerUser(String nameU, String cc,  int optionRegister){
        User newUser = null;
        Calendar vinculationDate = Calendar.getInstance();
        
        if (optionRegister == 1) {
            newUser = new Regular(nameU, cc, vinculationDate);
        } else if (optionRegister == 2) {
            newUser = new Premium(nameU, cc, vinculationDate);
        }
       return users.add(newUser);
    }

    /**
     * Register a new book in the system.
     *
     * @param name The name of the book.
     * @param numPages The number of pages in the book.
     * @param dayPublish The day the book was published.
     * @param monthPublish The month the book was published.
     * @param yearPublish The year the book was published.
     * @param URL The URL of the book.
     * @param review The book review.
     * @param genre The genre of the book. 1 for science fiction, 2 for fantasy
     * and 3 for historical novel.
     * @param priceB The price of the book.
     * @return true if the book registration was successful and it was added to the product collection,
     * false otherwise.
    */

    public boolean registerBook(String name, int numPages, int dayPublish, int monthPublish , int yearPublish, String URL,String review,int genre, double priceB){
        Products newproducts = null;

        Genre typegenre;
			
        if(genre==1){
        typegenre= Genre.FICTION_SCIENCE;
        }else if(genre==2){
        typegenre= Genre.FANTASY;
        }else {
        typegenre= Genre.HISTORICAL_NOVEL;
        }

        Calendar datePost = new GregorianCalendar(dayPublish, monthPublish- 1,
        yearPublish);
        
        newproducts = new Book(name, numPages,datePost, URL,review,genre, priceB);

        return products.add(newproducts);
    }

    /**
     * Register a new journal in the system.
     *
     * @param name The name of the journal.
     * @param numPages The number of pages in the journal.
     * @param dayPublish The day the journal was published.
     * @param monthPublish The publication month of the journal.
     * @param yearPublish The year the magazine was published.
     * @param URL The URL of the journal.
     * @param category The category of the journal. 1 for varieties, 2 for design
     * and 3 for scientific.
     * @param valueSub The subscription value of the journal.
     * @param periodEmission The issue period of the journal.
     * @return true if the magazine registration was successful and it was added to the product collection,
     * false otherwise.
    */

    
    public boolean registerMagazine(String name, int numPages, int dayPublish, int monthPublish , int yearPublish,  String URL,int category,int valueSub,String periodEmission){
        Products newproducts = null;

       Category typeCategory;

       if(category==1){
        typeCategory= Category.VARIETIES;
        }else if(category==2){
        typeCategory= Category.DESIGN;
        }else {
        typeCategory= Category.SCIENTIFIC;
        }

    
        Calendar datePost = new GregorianCalendar(dayPublish, monthPublish- 1,
        yearPublish);
        
        newproducts = new Magazine(name, numPages,datePost,URL,category,valueSub, periodEmission);

        return products.add(newproducts);
    }
    /**
     * List of books registered in the system.
     *
     * @return A string representing the list of registered books.
    */

    public String ListBook(){
        String listBook = "";

        for(int i= 0; i <products.size(); i++){
            if(products.get(i) instanceof Book){
                listBook+= (i+0)+"."+products.get(i).toString() + "\n";
            }
        }
        return listBook;
    }

    /**
     * Generates a message with the modified information of a book.
     *
     * @param option The option number of the book to modify.
     * @param newName The new name of the book.
     * @param newNumPages The new number of pages in the book.
     * @param newdayPublish The new day the book was published.
     * @param newmonthPublish The new month the book was published.
     * @param newyearPublish The new year the book was published.
     * @param newURL The new URL of the book.
     * @param newReview The new book review.
     * @param newGenre The new genre of the book.
     * @param newPriceB The new price of the book.
     * @return A message displaying the modified book information.
    */

    public String ListModifyBook(int option, String newName, int newNumPages, int newdayPublish, int newmonthPublish, int newyearPublish,String newURL, String newReview, int newGenre, double newPriceB){
        String msg = "";

        msg= "Name: " + newName + "\nNumber of pages: " + newNumPages+ 
        "\nURL: "+newURL +"\nDay of publish: "+ newdayPublish+ "\nMonth of publish: "+ newmonthPublish+ "\nYear of publish: "+newyearPublish+"\nReview: "+ newReview+ "\nGenre: "+ newGenre +"\nPrice: "+ newPriceB;
        
        return msg;
    }

    /**
     * List of journals registered in the system.
     *
     * @return A string representing the list of registered journals.
    */

    public String ListMagazine(){
        String listMagazine= "";

        for(int i=0; i<products.size();i++){
            if(products.get(i) instanceof Magazine){
                listMagazine+= (i+1)+"."+products.get(i).getName()+"\n";
            }
        }
        return listMagazine;
    }

    /**
     * Generates a message with the modified information of a magazine.
     *
     * @param optionM The option number of the journal.
     * @param newName The new name of the journal.
     * @param newNumPages The new number of pages in the journal.
     * @param newdayPublish The new publication day of the journal.
     * @param newmonthPublish The new month of publication for the magazine.
     * @param newyearPublish The new year of publication of the magazine.
     * @param newURL The new URL of the journal.
     * @param newcategory The new category of the magazine.
     * @param newvalueSub The new subscription value of the journal.
     * @param newperiodEmission The new issue period for the journal.
     * @return A message that displays the modified journal information.
    */

    public String ListModifyMagazine(int optionM, String newName, int newNumPages, int newdayPublish, int newmonthPublish, int newyearPublish,String newURL,int newcategory,int newvalueSub,String newperiodEmission){
        String msg = "";

        msg= "Name: " + newName + "\nNumber of pages: " + newNumPages+ 
        "\nDay of publish: "+ newdayPublish+ "\nMonth of publish: "+ newmonthPublish+ "\nYear of publish: "+newyearPublish+"\nURL: "+newURL +"\nCategory: "+ newcategory+ "\nValue subscription: "+ newvalueSub +"\nPrice: "+ newperiodEmission;
        
        return msg;
    }

    /**
     * Modify the attributes of a book.
     *
     * @param option The option number of the book to modify.
     * @param newName The new name of the book.
     * @param newNumPages The new number of pages in the book.
     * @param newdayPublish The new day the book was published.
     * @param newmonthPublish The new month the book was published.
     * @param newyearPublish The new year the book was published.
     * @param newURL The new URL of the book.
     * @param newReview The new book review.
     * @param newGenre The new genre of the book. 1 for science fiction,
     * 2 for fantasy and 3 for historical novel.
     * @param newpriceB The new price of the book.
     * @return true if the book modification was successful, false otherwise.
    */

    public boolean modifyBooks(int option, String newName, int newNumPages, int newdayPublish, int newmonthPublish, int newyearPublish,String newURL,String newReview, int newGenre, Double  newpriceB){

        Genre genre = Genre.FICTION_SCIENCE;
		if(newGenre==2){
			genre = Genre.FANTASY;
		} else if(newGenre ==3){
			genre = Genre.HISTORICAL_NOVEL;
		}

        Calendar newDatePost = new GregorianCalendar(newyearPublish, (newmonthPublish - 1), newdayPublish );

        for(int i = 0; i< products.size(); i++){
            
            Products book = products.get(option);
            if (book instanceof Book) {

                book.setName(newName);
                book.setNumPages(newNumPages);
                book.setDatePost(newDatePost);
                book.setURL(newURL);
                ((Book) book).setReview(newReview);
                ((Book) book).setGenre(genre);
                ((Book) book).setPriceB(newpriceB);
        
                return true; 
            }   
        }
        
        return false;
    }

    /**
     * Modify the attributes of a magazine.
     *
     * @param optionM The option number of the magazine to modify.
     * @param newName The new name of the journal.
     * @param newNumPages The new number of pages in the journal.
     * @param newdayPublish The new publication day of the magazine.
     * @param newmonthPublish The new month of publication for the magazine.
     * @param newyearPublish The new year of publication of the magazine.
     * @param newURL The new URL of the journal.
     * @param newcategory The new category of the magazine. 1 for varieties,
     * 2 for design and 3 for science.
     * @param newvalueSub The new subscription value of the journal.
     * @param newperiodEmission The new issue period for the journal.
     * @return true if the journal modification was successful, false otherwise.
    */

    public boolean modifyMagazines(int optionM, String newName, int newNumPages, int newdayPublish, int newmonthPublish, int newyearPublish,String newURL, int newcategory,int newvalueSub,String newperiodEmission){

        Category typeCategory;

        if(newcategory==1){
        typeCategory= Category.VARIETIES;
        }else if(newcategory==2){
        typeCategory= Category.DESIGN;
        }else {
        typeCategory= Category.SCIENTIFIC;
        }

        Calendar newDatePost = new GregorianCalendar(newyearPublish, (newmonthPublish - 1), newdayPublish );

        for(int i = 0; i< products.size(); i++){
            
            Products magazine= products.get(optionM);
            if (magazine instanceof Magazine) {

                magazine.setName(newName);
                magazine.setNumPages(newNumPages);
                magazine.setDatePost(newDatePost);
                magazine.setURL(newURL);
                ((Magazine) magazine).setCategory(typeCategory);
                ((Magazine) magazine).setValueSub(newvalueSub);
                ((Magazine) magazine).setPeriodEmission(newperiodEmission);            
            
                return true; 
            } 
        }
        
        return false;
    }

    /**
     * Delete a book from the system.
     *
     * @param bookIndex The index of the book to remove.
     * @return true if the book was removed successfully, false if the book was not found at the specified index.
    */

    public boolean deleteBooks(int bookIndex) {
        if(bookIndex>products.size()){
            return false;
        }
        products.remove(bookIndex);
 
        return true;
    }

    /**
     * Removes a magazine from the system.
     *
     * @param magazineIndex The index of the magazine to remove.
     * @return true if the journal was successfully removed, false if the journal was not found at the specified index.
    */

    public boolean deleteMagazines(int magazineIndex){
        if(magazineIndex>products.size()){
            return false;
        }
        products.remove(magazineIndex);
        return true;
    }
    
}
    

    


