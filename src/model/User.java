package model;
import java.util.Calendar;
import java.util.ArrayList;

public abstract class User {
    protected String nameU;
    protected String cc;
    private Calendar dateVinculation;

    private ArrayList<Products[][]> listAllLibraries;

    private String [][] products= new String[5][5];


    public User(String nameU, String cc, Calendar dateVinculation) {

        this.nameU = nameU;
        this.cc = cc;
        this.dateVinculation = dateVinculation;
  
    }

    public ArrayList<Products[][]> getListAllLibraries() {
        return listAllLibraries;
    }

    public void setListAllLibraries(ArrayList<Products[][]> listAllLibraries) {
        this.listAllLibraries = listAllLibraries;
    }

    public String getNameU() {
        return nameU;
    }

    public void setNameU(String nameU) {
        this.nameU = nameU;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public Calendar getDateVinculation() {
        return dateVinculation;
    }

    public void setDateVinculation(Calendar dateVinculation) {
        this.dateVinculation = dateVinculation;
    }
    public String[][] getProducts() {
		return products;
	}
    public void setProducts(String[][] products) {
		this.products = products;
	}

    public abstract boolean buybook(Products purchasedProduct);
    public abstract boolean buyMagazine(Products purchasedProduct);
    public abstract String getProductss(Products getProducts);
}
