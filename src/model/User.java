package model;
import java.util.Calendar;

public abstract class User {
    private String nameU;
    private String cc;
    private Calendar dateVinculation;

    public User(String nameU, String cc, Calendar dateVinculation) {
        this.nameU = nameU;
        this.cc = cc;
        this.dateVinculation = dateVinculation;
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
}
