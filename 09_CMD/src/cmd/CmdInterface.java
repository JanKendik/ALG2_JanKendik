/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

/**
 *
 * @author HP
 */
public interface CmdInterface {

    public String getActualDir();

    public boolean isRunning();

    public String parseAndExecute(String line);
    
}
