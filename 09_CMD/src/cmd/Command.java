
package cmd;

import java.io.File;


public abstract class Command {
    
    public static String COMMAND_PACKAGE = "cmd";
    protected String[] parameters; //dir -e .java 

    public void setParameters(String[] parameters) {
        this.parameters = new String[parameters.length];
        System.arraycopy(parameters, 0, this.parameters, 0, parameters.length);
    }
    
    public abstract Position execute(File actualDir);
    /*switch(parameters[0]){
        case "dir": dir();
        break;
        case "cd": cd();
        break;
    }*/
    
    
    
    
    
    public Command(){
    
    }
    
    
}
