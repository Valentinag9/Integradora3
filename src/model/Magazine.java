package model;

import java.util.Calendar;

public class Magazine extends Products{
    private Category category;
    private int valueSub;
    private String periodEmission;
    private int numsubActive;

    public Magazine(String code, String name, int numPages, Calendar datePost, String URL, Category category,int valueSub,String periodEmission) {
        super(code, name, numPages, datePost, URL);
        this.category=category;
        this.valueSub = valueSub;
        this.periodEmission= periodEmission;
      
    }

    public Magazine(Magazine copyMagazine){
        super(copyMagazine.getCode(),copyMagazine.getName(),copyMagazine.getNumPages(),copyMagazine.getDatePost(),copyMagazine.getURL());
        this.category= copyMagazine.getCategory();
        this.valueSub= copyMagazine.getValueSub();
        this.periodEmission= copyMagazine.getPeriodEmission();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getValueSub() {
        return valueSub;
    }

    public void setValueSub(int valueSub) {
        this.valueSub = valueSub;
    }

    public String getPeriodEmission() {
        return periodEmission;
    }

    public void setPeriodEmission(String periodEmission) {
        this.periodEmission = periodEmission;
    }

    public int getNumsubActive() {
        return numsubActive;
    }

    public void setNumsubActive(int numsubActive) {
        this.numsubActive = numsubActive;
    }

    public String toString() {

		String msg = "";

	
        msg =  "\nId: "+ code+"\nName: " + name + "\nNumber of Pages: " + numPages + "\nURL: " + URL + "\nCategory: " + category + "\nValue sub: " + valueSub + "\nPeriod of emission: " + periodEmission;

		return msg;

	}

}
