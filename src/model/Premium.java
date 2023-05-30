package model;
import java.util.ArrayList;

import java.util.Calendar;

public class Premium extends User{

    private ArrayList<Products> newpProductsR;
    

    public Premium(String nameU, String cc, Calendar dateVinculation) {
        super(nameU, cc, dateVinculation);
		newpProductsR = new ArrayList<>();
    }

    public String toString() {

		String msg = "";

	
        msg = "\nName: " + nameU + "\nCedula " + cc;

		return msg;

	}

	@Override
	public boolean buybook(Products purchasedProduct) {
		createMatrix();
		return  newpProductsR.add(purchasedProduct);
	}

	@Override
	public boolean buyMagazine(Products purchasedProduct) {
		createMatrix();
		return  newpProductsR.add(purchasedProduct);
	}

    public void organizeProducts() {
        for (int i = 1; i <newpProductsR.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (newpProductsR.get(i).getDatePost().compareTo(newpProductsR.get(j).getDatePost()) < 0) {
                    newpProductsR.add(j, newpProductsR.remove(i));
                    break;
                }
            }
        }
    }

    public void createMatrix() {
        organizeProducts();
        ArrayList<Products[][]> temp = new ArrayList<>();
        int cont = 0;
        for (int h = 0; h < (((int) newpProductsR.size() / 25) + 1); h++) {
            Products[][] matrix = new Products[5][5];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j <= matrix.length; j++) {
                    if (cont >= newpProductsR.size()) break;
                    matrix[i][j] = newpProductsR.get(cont);
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
        for (int i = 0; i < getListAllLibraries().size(); i++) {
            for (int j = 0; j < getListAllLibraries().get(i).length; j++) {
                msg += "|  " + j + "  |";
                for (int j2 = 0; j2 < getListAllLibraries().get(i).length; j2++) {
                    if (getListAllLibraries().get(i)[j][j2] != null) {
                        msg += "| " + getListAllLibraries().get(i)[j][j2].getId() + " |";
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
