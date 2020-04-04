
package bank;

public class Company extends Client{
    private String name;

    public Company(String name) {
        super(name);
        this.name = name;
    }
    
    public String Sallute(){
    return "firma " + name;
    }
    
}
