
package cmd;

import java.io.File;

public class exit extends Command{

    @Override
    public Position execute(File actualDir) {
return new Position(null, "end");
    }
    
}
