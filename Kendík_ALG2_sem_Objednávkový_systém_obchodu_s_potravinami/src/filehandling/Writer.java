/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandling;

import app.Calculator;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author HP
 */
public abstract class Writer {
    
    /**
     * Cesta do složky data, ze které se berou vstupní soubory a ukládají se do ní výstupní soubory
     */
    public static File dataPath = new File(System.getProperty("user.dir")+File.separator+"data");
    
    /**
     * Metoda pro zápis nových dat do souboru
     * @param nameFile - název výstupního souboru
     * @param calculators - objednávka s kalkulacemi
     * @throws IOException
     */
    public abstract void saveOrder(String nameFile, List<Calculator> calculators) throws IOException;
    
  
    
}
