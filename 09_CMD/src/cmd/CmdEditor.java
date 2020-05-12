package cmd;

import java.io.File;

public class CmdEditor implements CmdInterface {

    private boolean isRunning;
    private File actualDir;
    private Command command;

    public CmdEditor() {
        isRunning = true;
        actualDir = new File(System.getProperty("user.dir"));
    }

    @Override
    public String getActualDir() {
        return actualDir.getAbsolutePath();
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public String parseAndExecute(String line) {
       //parse = rozsekat zadany text na zpracovatelné kusy
       command = Parser.parse(line);
       //execure
       if (command == null) {
            return " ";
        }
        //execute
        Position status = command.execute(actualDir);
        actualDir = status.getActualDir();
        if (actualDir == null) {
            isRunning = false;
        }
        return status.getTodo();
    }
       
    }


