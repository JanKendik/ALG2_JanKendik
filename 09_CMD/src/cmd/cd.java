
package cmd;

import java.io.File;

public class cd extends Command {//change directory

    public Position execute(File actualDir) {
        File file;
if(parameters.length == 1){
    return new Position(actualDir, "Insert name of folder or ..");
}
if(parameters.length>2){
return new Position(actualDir, "Invalid input");
}
if (parameters[1].equals("..")) {
            file = new File(actualDir.getParent());
        } else {
            try {
                file = new File(actualDir.getAbsolutePath() + "\\" + parameters[1]);
            } catch (Exception e) {
                throw new RuntimeException("This file does not exist");
            }
        }
        return new Position(file, "  ");
    }
}
    
    

