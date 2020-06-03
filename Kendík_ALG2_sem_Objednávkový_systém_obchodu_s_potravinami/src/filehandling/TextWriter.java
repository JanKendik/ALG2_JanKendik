/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandling;

import app.Calculator;
import app.Item;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class TextWriter extends Writer {

    @Override
    public void saveOrder(String nameFile, List<Calculator> calculators) {
        File orderFile = new File(dataPath, nameFile);
        try (PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter(orderFile, true)))) {
            p.println("Objednávka ze dne" + LocalDate.now());
            p.format("%-5s%-20s%-10s%-10s%-10s%n", "ID", "Název", "Cena", "Počet", "Suma");
            for (Calculator calculator : calculators) {
                p.println(calculator.toString());
            }
        } catch (IOException ex) {
            Logger.getLogger(TextWriter.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Nepodařilo se uložit");
        }
    }
    //public void add

    /**
     *
     * @param orderFile - Soubor do kterého přidáváme položku
     * @param items - 
     * @throws IOException
     */
    public void updateOrder(String orderFile, ArrayList<Item> items) throws IOException {
        File update = new File(dataPath, orderFile);
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(update)))) {
            for (Item item : items) {
                pw.println(item.toString());
            }
        }
    }
    
    
}
