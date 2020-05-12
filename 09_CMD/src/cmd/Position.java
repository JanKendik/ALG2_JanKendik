
package cmd;

import java.io.File;

public class Position {
    private File actualDir;
    private String whatToDo;

    public Position(File actualDir, String todo) {
        this.actualDir = actualDir;
        this.whatToDo = todo;
    }

    public File getActualDir() {
        return actualDir;
    }

    public String getTodo() {
        return whatToDo;
    }
    
    
}
