/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filehandling;

import app.Calculator;
import app.Item;
import static filehandling.Writer.dataPath;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class BinaryWriter extends Writer {

    @Override
    public void saveOrder(String nameFile, List<Calculator> calculators) throws IOException {
        File orderFile = new File(dataPath, nameFile);
        DataOutputStream stream = new DataOutputStream(new FileOutputStream(orderFile));
        for (Calculator cal : calculators) {
            stream.writeInt(cal.getItem().getProduct().getId());
            stream.writeUTF(cal.getItem().getProduct().getName());
            stream.writeDouble(cal.getItem().getProduct().getPrice());
            stream.writeInt(cal.getItem().getnItems());
            stream.writeDouble(cal.getSumPrice());
        }
    }

}
