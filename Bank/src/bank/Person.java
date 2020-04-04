package bank;

public class Person extends Client {

    private String name;

    public Person(String name) {
        super(name);
        this.name = name;
    }

    public String Sallute() {
        if ("ova".equals(name.substring(name.length() - 3))) {
            return "paní " + name;
        } else {
            return "pan " + name;
        }
    }

}
