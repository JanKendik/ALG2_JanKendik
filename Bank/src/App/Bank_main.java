package App;

import java.util.ArrayList;
import bank.Account;
import bank.Client;
import bank.Company;
import bank.Person;

public class Bank_main {

    public static ArrayList<Client> ClientArray = new ArrayList();

    public static void main(String[] args) {
        Person p1 = new Person("Pekar");
        Person p2 = new Person("Svecova");
        Company c1 = new Company("Skoda");
        p1.newAccount(1000);
        p1.newAccount(500);
        p2.newAccount(1200);
        c1.newAccount(120);
        ClientArray.add(p1);
        ClientArray.add(p2);
        ClientArray.add(c1);
        for (Client i : ClientArray) {
            System.out.println(i.Sallute() + " " + " " + i.allMoney() + "kč");
        }
    }

}
