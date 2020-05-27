package OrderUI;

import app.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Kendík_ALG2_sem_Objednávkový_systém_obchodu_s_potravinami {

    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws FileNotFoundException {
    Order o = new Order();
       System.out.println("Zadej název vstupního soubotu s objednávkou");
       String orderFile = sc.next();
       while(true){
           
           o.load(orderFile);
           break;
           
       }
       //System.out.println(o.getSumToPay());
       System.out.println("Zadej název výstupního souboru");
       String billFile = sc.next();
       o.saveBill(billFile);
    }
    
}
