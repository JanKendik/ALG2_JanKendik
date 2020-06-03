/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import filehandling.BinaryWriter;
import filehandling.ExcelWriter;
import filehandling.TextWriter;
import filehandling.Writer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;
import utils.OrderInterface;

/**
 *
 * @author HP
 */
public class Order implements OrderInterface{

    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Calculator> calculators = new ArrayList<>();
    private LocalDate dateofOrder;

    /**
     * Metoda co z načteného souboru ukládá jednotlivé položky do ArrayListu items
     * @param orderFilepath - cesta k složce se soubory
     * @throws FileNotFoundException
     */
    public void load(String orderFilepath) throws FileNotFoundException {
        File orderFile = new File(Writer.dataPath, orderFilepath);
        Scanner inOrder = new Scanner(orderFile);
        while (inOrder.hasNext()) {
            int ID = inOrder.nextInt();
            String name = inOrder.next();
            double price = inOrder.nextDouble();
            Product p = new Product(ID, name, price);
            int nItems = inOrder.nextInt();
            Item i = new Item(p, nItems);
            items.add(i);
        }
    }

    /**
     * Metoda pro ukládání/vpisování účtu objednávky
     * @param billFile - výstupní soubor do kterého se ukládá objednávka s vypočtenými cenami popř. přidanými položkami
     * @throws IOException
     */
    public void saveBill(String billFile) throws IOException {

        Writer w = null;
        if (billFile.endsWith(".txt")) {
            w = new TextWriter();
        } else if (billFile.endsWith(".xlsx")) {
            w = new ExcelWriter();
        } else if (billFile.endsWith(".dat")) {
            w = new BinaryWriter();
        } else {
            System.err.println("Nevalidní koncovka");
        }
        w.saveOrder(billFile, calculators);
    }

    
    public String getItemInfo() {
        StringBuilder sb = new StringBuilder("");
        sb.append(String.format("%-5s%-20s%-10s%-4s%n", "ID", "Název", "Cena", "Počet"));
        for (Item item : items) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }

    /**
     * Třízení podle názvů položek
     * @return
     */
    public String getItemInfoSortedByName() {
        Collections.sort(items, Item.NameCompare);
        StringBuilder sb = new StringBuilder("");
        sb.append(String.format("%-5s%-20s%-10s%-4s%n", "ID", "Název", "Cena", "Počet"));
        for (Item item : items) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }

    /**
     * Třízení podle ID
     * @return
     */
    public String getItemInfoSortedByID() {
        Collections.sort(items);
        StringBuilder sb = new StringBuilder("");
        sb.append(String.format("%-5s%-20s%-10s%-4s%n", "ID", "Název", "Cena", "Počet"));
        for (Item item : items) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }

    /**
     * Hledání položka na seznamu podle ID
     * @param id
     * @return
     */
    public Item findItem(int id) {
        for (Item item : items) {
            if (item.getProduct().getId() == id) {
                return item;
            }
        }
        throw new NoSuchElementException("Výrobek se zadaným ID neexistuje");
    }

    /**
     * Výpis položek na seznamu calculators, což je objednávka rozšířená o vypočtené ceny
     * @return
     */
    public String getCalculatorInfo() {
        StringBuilder sb = new StringBuilder("");
        sb.append(String.format("%-5s%-20s%-10s%-10s%-10s%n", "ID", "Název", "Cena", "Počet", "Suma"));
        for (Calculator calc : calculators) {
            sb.append(calc).append("\n");
        }
        return sb.toString();
    }

    /**
     * Počíta jednotlivé ceny položek
     */
    public void calculateSumPrice() {
        for (Item item : items) {
            Calculator c = new Calculator(item);
            c.calculateSum(item);
            calculators.add(c);
        }
    }

    /**
     * Výpočet celkové ceny objednávky
     * @return
     */
    public double getSumToPay() {
        double finalSum = 0;
        for (Calculator calculator : calculators) {

            finalSum = finalSum + calculator.getSumPrice();

        }
        return finalSum ;
    }

    /**
     * Přidá již vytvořenou položku na objednávku
     * @param i
     */
    public void addItemToOrder(Item i) {
        if (items != null) {
        items.add(i);
        }
    }

    /**
     * Vepsání položky do objednávky
     * @param orderFile - Soubor objednávky do které položku přidáváme
     * @throws IOException
     */
    public void saveItemToOrder(String orderFile) throws IOException {
        TextWriter tw = new TextWriter();
        tw.updateOrder(orderFile, items);

    }


}
