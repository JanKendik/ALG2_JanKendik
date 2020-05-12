
package cmd;

import java.io.File;

public class mkdir extends Command{

    @Override
    public Position execute(File actualDir) {
if(parameters.length == 2){
File folder = new File(actualDir.getAbsolutePath() + "/" + parameters[1]);
folder.mkdir();
return new Position(actualDir, "You have a new folder");
}else{
return new Position(actualDir, "invalid input");
}
    }
    
}
