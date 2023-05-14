package model;

import java.util.Calendar;

public class Magazine extends Products{
    private Category category;
    private int valueSub;
    private String periodEmission;
    private int numsubActive;

    public Magazine( String name, int numPages, Calendar datePost, String URL, int category,int valueSub,String periodEmission) {
        super( name, numPages, datePost, URL);
        
        this.valueSub = valueSub;
        this.periodEmission= periodEmission;
      
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

}
