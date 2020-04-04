/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public abstract class Client {

    private String name;
    private ArrayList<Account> accountArray = new ArrayList();//list ůčtú jistého klienta

    public abstract String Sallute();
    
    public Client(String name) {
        this.name = name;
    }

    public void newAccount(double money) {
        Account a = new Account(money);
        accountArray.add(a);
    }

    public double allMoney() {
        double all = 0;
        for (Account i : accountArray) {
            all = all + i.getMoney();
        }
        return all;
    }
    

}
