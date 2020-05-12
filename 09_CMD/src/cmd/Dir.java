package cmd;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Date;

public class Dir extends Command {

    @Override
    public Position execute(File actualDir) {
        File[] files;
        switch (parameters.length) {
            case 1:
                // => obyčený dir
                files = actualDir.listFiles();
                return new Position(actualDir, dirToString(files));
            case 2:
                if (parameters[1].equals("-o")) {
                    files = actualDir.listFiles();
                    Arrays.sort(files);
                    return new Position(actualDir, dirToString(files));
                } else {
                    return new Position(actualDir, "Invalid command");
                }
            case 3:
                switch (parameters[1]) {
                    case "-e": {
                        String extension = parameters[2];
                        FileFilter filefilter = (File pathname) -> pathname.getName().endsWith(extension);
                        files = actualDir.listFiles(filefilter);
                        return new Position(actualDir, dirToString(files));
                    }
                    case "-s": {
                        int size = Integer.parseInt(parameters[2]);
                        FileFilter filefilter = (File pathname) -> pathname.length() > size;
                        files = actualDir.listFiles(filefilter);
                        return new Position(actualDir, dirToString(files));
                    }
                    default:
                        return new Position(actualDir, "Invalid command");

                }
            default:
                return new Position(actualDir, "Invalid command");
        }

    }

    private String dirToString(File[] files) {
        StringBuilder sb = new StringBuilder("");
        for (File file : files) {
            if (file.isDirectory()) {
                String.format("%s\n", file.getName());
            } else {
                sb.append(String.format("%-20s%6d", file.getName(), file.length()));
                sb.append(new Date(file.lastModified())).append("\n");
            }
        }
        return sb.toString();
    }

}
