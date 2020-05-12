package cmd;

import java.io.File;

public class Help extends Command{

    @Override
    public Position execute(File actualDir) {
        
        String help = "HELP\n" 
                + String.format("%-7s %s\n", "help", "Display help")
                + String.format("%-7s %s\n", "dir", "Display list of files and folders")
                + String.format("%-7s %s\n", "dir (-o) ", "Display ordered list of files and folders")
                + String.format("%-7s %s\n", "dir (-e)", "Display list of files and folders with this extension")
                + String.format("%-7s %s\n", "dir (-s)", "Display list and files bigger than this size")
                + String.format("%-7s %s\n", "cd ..", "change directory")
                + String.format("%-7s %s\n", "cd   (folder name)", "Move into this folder")
                + String.format("%-7s %s\n", "mkdir (folder name)", "Create new folder with this name")
                + String.format("%-7s %s\n", "rename (from) (onto)", "rename folder from old onto new name")
                + String.format("%-7s %s\n", "exit", "stops CMD");
        return new Position(actualDir, help);
    }
    
}
