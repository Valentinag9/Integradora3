package model;

import java.util.Calendar;

public class Magazine extends Products{
    private Category category;
    private String urlM;
    private int valueSub;
    private String periodEmission;
    private int numsubActive;

    public Magazine(String id, String name, int numreadedPages, Calendar datePost, int readedPages,Category category,String urlM,int valueSub,String periodEmission,int numsubActive) {
        super(id, name, numreadedPages, datePost, readedPages);
        this.category = category;
        this.urlM = urlM;
        this.valueSub = valueSub;
        this.periodEmission= periodEmission;
        this.numsubActive= numsubActive;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getUrlM() {
        return urlM;
    }

    public void setUrlM(String urlM) {
        this.urlM = urlM;
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
