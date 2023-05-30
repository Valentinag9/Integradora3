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

    public void organizeProducts() {
        for (int i = 1; i < newproducts.length; i++) {
            for (int j = 0; j < i; j++) {
                if (newproducts[i] != null && newproducts[j] != null
                        && newproducts[i].getDatePost().compareTo(newproducts[j].getDatePost()) < 0) {
                    Products temp = newproducts[i];
                    for (int k = i; k > j; k--) {
                        newproducts[k] = newproducts[k - 1];
                    }
                    newproducts[j] = temp;
                    break;
                }
            }
        }
    }

    public void createLibrary() {
        organizeProducts();
        ArrayList<Products[][]> temp = new ArrayList<>();
        int cont = 0;
        for (int h = 0; h < (((int) newproducts.length / 25) + 1); h++) {
            Products[][] matrix = new Products[5][5];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (cont >= newproducts.length) break;
                    matrix[i][j] = newproducts[cont];
                    cont++;
                }
            }
            temp.add(matrix);
        }
        setProducts(temp);
    }

    @Override
    public String getMatrix() {
        String msg = "| _ ||  0  ||  1  ||  2  ||  3  ||  4  |\n";
        for (int i = 0; i <getListAllLibraries().size(); i++) {
            for (int j = 0; j < getListAllLibraries().get(i).length; j++) {
                msg += "|  " + j + "  |";
                for (int h = 0; h < getListAllLibraries().get(i).length; h++) {
                    if (getListAllLibraries().get(i)[j][h] != null) {
                        msg += "| " + getListAllLibraries().get(i)[j][h].getId() + " |";
                    } else {
                        msg += "| _ |";
                    }
                }
                msg += "\n";
            }
            msg += "\n";
        }
        return msg;
    }
    
}
