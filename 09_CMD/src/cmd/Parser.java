package cmd;

public class Parser {

    public static Command parse(String line) {
        
        String[] p = line.split(" +");//+ zanamena ze oddelovac je jedna nebo více mezer
        //p[0] = dir
        //p[1] = -e
        //p[2] = .java
         //TODO prazdny prikaz
        char first = Character.toUpperCase(p[0].charAt(0)); // máme D
        String name = Command.COMMAND_PACKAGE + "." + first + p[0].substring(1); //cmd.Dir
        try {
            Class c = Class.forName(name);
            Command command = (Command) c.newInstance();
            command.setParameters(p);
            return command;
        } catch (Exception e) {
            throw new RuntimeException("Nepodařilo se příkaz naparsovat.");
        }

    }

}
