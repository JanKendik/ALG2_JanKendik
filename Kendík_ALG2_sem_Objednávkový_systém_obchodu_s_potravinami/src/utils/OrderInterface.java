package utils;

import app.Item;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author HP
 */
public interface OrderInterface {

    /**
     * Metoda co z načteného souboru ukládá jednotlivé položky do ArrayListu items
     * @param orderFilepath - cesta k složce se soubory
     * @throws FileNotFoundException
     */
    public void load(String orderFilepath) throws FileNotFoundException;
 
    /**
     * Metoda pro ukládání/vpisování účtu objednávky
     * @param billFile - výstupní soubor do kterého se ukládá objednávka s vypočtenými cenami popř. přidanými položkami
     * @throws IOException
     */
    public void saveBill(String billFile) throws IOException;
  
    
    public String getItemInfo();
   
    /**
     * Třízení podle názvů položek
     * @return
     */
    public String getItemInfoSortedByName();
   
    /**
     * Třízení podle ID
     * @return
     */
    public String getItemInfoSortedByID();
   
    /**
     * Hledání položka na seznamu podle ID
     * @param id
     * @return
     */
    public Item findItem(int id);
   
    /**
     * Výpis položek na seznamu calculators, což je objednávka rozšířená o vypočtené ceny
     * @return
     */
    public String getCalculatorInfo();
   
    /**
     * Počíta jednotlivé ceny položek
     */
    public void calculateSumPrice();
   
    /**
     * Výpočet celkové ceny objednávky
     * @return
     */
    public double getSumToPay();

    /**
     * Přidá již vytvořenou položku na objednávku
     * @param i
     */
    public void addItemToOrder(Item i);

    /**
     * Vepsání položky do objednávky
     * @param orderFile - Soubor objednávky do které položku přidáváme
     * @throws IOException
     */
    public void saveItemToOrder(String orderFile)throws IOException;
    
}
