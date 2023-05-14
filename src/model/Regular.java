package model;

import java.util.Calendar;

public class Regular extends User {

    private Products[] regularproductsBiblio = new Products[7];

    public Regular(String nameU, String cc, Calendar dateVinculation) {
        super(nameU, cc, dateVinculation);

        
    }
    
}
