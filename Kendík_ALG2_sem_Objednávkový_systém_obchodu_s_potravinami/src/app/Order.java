/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Order {

    private ArrayList<Item> items = new ArrayList<>();

    public void load(String orderFilepath) throws FileNotFoundException {
        File orderFile = new File(orderFilepath);
        Scanner inOrder = new Scanner(orderFile);
        while(inOrder.hasNext()) {
        String name = inOrder.next();
        int price = inOrder.nextInt();
        int nItems = inOrder.nextInt();
        Item i = new Item(name, price, nItems);
        items.add(i);
        }
    }

    public void saveBill(String billFile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*public int getSumToPay() {
        
    }*/

}
