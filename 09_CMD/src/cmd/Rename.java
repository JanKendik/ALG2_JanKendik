
package cmd;

import java.io.File;

public class Rename extends Command{

    @Override
    public Position execute(File actualDir) {
        if(parameters.length == 3){
        File folder1 = new File(actualDir.getAbsolutePath() + "/" + parameters[1]);
        File folder2 = new File(actualDir.getAbsolutePath() + "/" + parameters[2]);
        return new Position(actualDir, "folder has been renamed");
        }else{
        return new Position(actualDir, "Invalid input");
        }
    }
    
}
