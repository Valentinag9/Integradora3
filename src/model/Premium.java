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
		initMatrix();
		return  newpProductsR.add(purchasedProduct);
	}

	@Override
	public boolean buyMagazine(Products purchasedProduct) {
		initMatrix();
		return  newpProductsR.add(purchasedProduct);
	}

	public void insertionSort(){
        for (int rojo = 1; rojo <  newpProductsR.size(); rojo++){
            for (int verde = 0; verde < rojo; verde++) {
                if ( newpProductsR.get(rojo).getDatePost().compareTo( newpProductsR.get(verde).getDatePost()) < 0) {
					newpProductsR.add(verde,  newpProductsR.remove(rojo));
                    break;
                }
            }
        }
    }

	public void initMatrix(){
        insertionSort();
        ArrayList<Products[][]> temp = new ArrayList<>();
        int cont = 0;
        for (int h = 0; h < (((int)newpProductsR.size()/25)+1); h++) {
            Products[][] matrix = new Products[5][5];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j <= matrix.length; j++) {
                    if(cont>= newpProductsR.size())break;
					matrix[i][j] = newpProductsR.get(cont);
                    cont++;
                }
            }
            temp.add(matrix);
        }

        setListAllLibraries(temp);
    }

		
	@Override
    public String getProductss(Products getProducts){
        String msg = "[ _ ][ 0 ][ 1 ][ 2 ][ 3 ][ 4 ]\n";
        for (int i = 0; i < getListAllLibraries().size(); i++) {
            for (int j = 0; j < getListAllLibraries().get(i).length; j++) {
				msg+= "[ " + j + " ]";
                for (int j2 = 0; j2 < getListAllLibraries().get(i).length; j2++) {
                    if (getListAllLibraries().get(i)[j][j2] != null) {
                        msg += "[ " + getListAllLibraries().get(i)[j][j2].getId() + " ]";
                    } else {
                        msg += "[ _ ]";
                    }
                    
                }
                msg += "\n";
            }
            msg += "\n";
        }
        
        return msg;
    }
    
}
