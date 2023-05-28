package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;


public class ControllerB {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Products> products;

    public ControllerB(){
        
        products = new ArrayList<>();
        testCase();
	}

    public void testCase(){
        User user1 = new Regular("Valentina", "1107839938", null);
        User user2 = new Premium("Juan", "94503232", null);

        users.add(user1);
        users.add(user2);

        Products product1 = new Book("A01", "Las mil y una noches", 430, null, "www.milyunanoches.com", "reseña", 2, 90000);
        Products product2 = new Magazine("AB3", "l", 1220, null, "www.milyunanoches.com", null, 70000, "p");
        products.add(product1);
        products.add(product2);
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
  
   

    public int sumPagesBook(){
        int acumbook = 0;

        for(int i = 0; i < products.size(); i++){
            if(products.get(i) instanceof Book){
                acumbook += products.get(i).getReadedPages();
            }
        }
        return acumbook;
    }

    public int sumPagesMagazine(){
        int acumbook = 0;

        for(int i = 0; i < products.size(); i++){
            if(products.get(i) instanceof Magazine){
                acumbook += products.get(i).getReadedPages();
            }
        }
        return acumbook;
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

        int length=3;
        String hexadecimal = "ABCDEF0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(hexadecimal.length());
            char randomChar = hexadecimal.charAt(randomIndex);
            sb.append(randomChar);
        }
        String code=sb.toString();

        Calendar datePost = new GregorianCalendar(dayPublish, monthPublish- 1,
        yearPublish);
        
        newproducts = new Book(code,name, numPages,datePost, URL,review,genre, priceB);

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
        
        int length=3;
        String alphanumeric = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(alphanumeric.length());
            char randomChar = alphanumeric.charAt(randomIndex);
            sb.append(randomChar);
        }
        String code=sb.toString();
  

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
        
        Products newproducts = new Magazine(code,name, numPages,datePost,URL,typeCategory,valueSub, periodEmission);

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
     * Shows the library of a specific Premium user.
     *
     * @param opt1 the index of the user in the user list
     * @return a string representing the Premium user's library
    */
    public String showUserLibraryPremium(int opt1){
        String msg = "";

        for(int i= 0; i<((Premium)users.get(opt1)).getProducts().length; i++){
            for(int j = 0; j<((Premium)users.get(opt1)).getProducts()[0].length; i++){
                if(users.get(opt1)instanceof Premium){
                    msg+= " "+ ((Premium)users.get(opt1)).getProducts()[i][j]+"";
                }
            }
        }
        return msg;
    }

    /**
     * Shows the library of a specific user.
     *
     * @param opt1 the index of the user in the user list
     * @return a string representing the user's library
    */

    public String showUserLibrary(int opt1){
        String msg = "";

        for(int i= 0; i<((Regular)users.get(opt1)).getProducts().length; i++){
            for(int j = 0; j<((Regular)users.get(opt1)).getProducts()[0].length; i++){
                if(users.get(opt1)instanceof Regular){
                    msg+= " "+ ((Regular)users.get(opt1)).getProducts()[i][j]+"";
                }
            }
        }
        return msg;
    }


    public ArrayList<String>  getListBook(){
        ArrayList<String> listBook = new ArrayList<>();

        for(int i= 0; i <products.size(); i++){
            if(products.get(i) instanceof Book){
                listBook.add(products.get(i).code);
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
                listMagazine+= (i+1)+"."+products.get(i).toString() + "\n";
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

        Calendar newDatePost = new GregorianCalendar(newyearPublish, (newmonthPublish - 1), newdayPublish );

        for(int i = 0; i< products.size(); i++){
            
            Products book = products.get(option);
            if (book instanceof Book) {

                book.setName(newName);
                book.setNumPages(newNumPages);
                book.setDatePost(newDatePost);
                book.setURL(newURL);
                ((Book) book).setReview(newReview);
                ((Book) book).setGenre(newGenre);
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

    /**
     * Make the purchase of a book for a specific user.
     *
     * @param optionBuy the index of the book to buy in the product list
     * @param userBook the user's index in the user list
     * @return true if the purchase was successful, false otherwise
    */
    public boolean purchaseBook(int optionBuy, int userBook){
        Products buybook= null; 
        if(products.get(optionBuy) instanceof Book){
            buybook = new Book((Book)products.get(optionBuy));
        }

        return users.get(userBook).buybook(buybook);
    }
    /**
     * Realiza la compra de una revista para un usuario específico.
     *
     * @param optionBuyM el índice de la revista a comprar en la lista de productos
     * @param userMagazine el índice del usuario en la lista de usuarios
     * @return true si la compra se realizó con éxito, false de lo contrario
    */
    public boolean purchaseMagazine(int optionBuyM, int userMagazine){
        Products buyMagazine= null; 
        if(products.get(optionBuyM) instanceof Magazine){
            buyMagazine = new Magazine((Magazine)products.get(optionBuyM));
        }

        return users.get(userMagazine).buyMagazine(buyMagazine);
    }
   

    /**
     * Search for a regular user by their identification number.
     *
     * @param cc the identification number of the user to search for
     * @return the regular user found or null if no match is found
    */
    
    public User findUser(String cc){
        for(int i= 0; i< users.size(); i ++){
            if(users.get(i) instanceof Regular){
                if(users.get(i).getCc().equals(cc)){
                    return (Regular)users.get(i);
                }
            }
        }
        return null;
    }

    /**
     * Search for a premium user by their identification number.
     *
     * @param cc the identification number of the user to search for
     * @return the premium user found or null if no match is found
    */

    public User findUserP(String cc){
        for(int i= 0; i< users.size(); i ++){
            if(users.get(i) instanceof Premium){
                if(users.get(i).getCc().equals(cc)){
                    return (Premium)users.get(i);
                }
            }
        }
        return null;
    }

    /**
     * Generate a list of premium users.
     *
     * @return a string representing the list of premium users
    */
    public String ListUserPremium(){
        String listUsers = "";

        for(int i= 0; i<users.size(); i++){
            if(users.get(i) instanceof Premium){
                listUsers+= (i+0)+"."+users.get(i).toString() + "\n";
            }
        }
        return listUsers;
    }
    /**
     * Genera una lista de usuarios regulares.
     *
     * @return una cadena que representa la lista de usuarios regulares
    */
    public String ListUserRegular(){
        String listUsersR = "";

        for(int i= 0; i<users.size(); i++){
            if(users.get(i) instanceof Regular){
                listUsersR+= (i+0)+"."+users.get(i).toString() + "\n";
            }
        }
        return listUsersR;
    }
    
}
    

    


