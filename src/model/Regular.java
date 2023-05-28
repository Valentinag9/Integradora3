package model;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.Arrays;


public class Regular extends User {

    private Products[] newproducts= new Products[7];
	
    private Bill[] bill= new Bill[7]; 

    public Regular(String nameU, String cc, Calendar dateVinculation) {
        super(nameU, cc, dateVinculation);
        this.newproducts = new Products[7];
        this.bill = new Bill[7];
    }

	public Products[] getNewproducts() {
		return newproducts;
	}

	public void setNewproducts(Products[] newproducts) {
		this.newproducts = newproducts;
	}

	@Override
	public boolean buybook(Products purchasedProduct) {
		for(int i = 0; i<newproducts.length;i++){
			if(purchasedProduct instanceof Book){
				if(newproducts[i]==null){
					newproducts[i] = purchasedProduct;
				}
			}
		}
		return true;
	}

	


	@Override
	public boolean buyMagazine(Products purchasedProduct) {
		for(int i = 0; i<newproducts.length;i++){
			if(purchasedProduct instanceof Magazine){
				if(newproducts[i]==null){
					newproducts[i] = purchasedProduct;
				}
			}
		}
		return true;
	}

    public boolean maxMagazine() {
        int cont = 0;
        
        for (int i = 0; i<newproducts.length; i++) {
            if (newproducts[i] instanceof Magazine) {
                cont++;
            }
        }
        if(cont<2){
            return true;
        }else{
            return false;
        }
    }

    public boolean maxBook() {
        int count = 0;
        
        for (int i = 0; i<newproducts.length; i++) {
            if (newproducts[i] instanceof Book) {
                count++;
            }
        }
        if(count<7){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String getProductss(Products geProducts) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductss'");
    }
    
}
