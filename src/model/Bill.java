package model;
import java.util.Calendar;

public class Bill {
    private Calendar DateOperation;
    private int amountPaid;

    public Bill(Calendar dateOperation, int amountPaid) {
        this.DateOperation = dateOperation;
        this.amountPaid = amountPaid;
    }

    
}
