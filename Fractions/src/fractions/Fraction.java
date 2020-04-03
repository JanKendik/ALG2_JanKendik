package fractions;

public class Fraction {

    private int citatel;
    private int jmenovatel;

    public Fraction(int citatel, int jmenovatel) {
        if (jmenovatel == 0) {
            throw new IllegalArgumentException("Jmenovatel nesmí být 0!");
        }
        this.citatel = citatel;
        this.jmenovatel = jmenovatel;
        simplyfy();
        //nevím jak udělat construktor pro zadávání čitatele a jmenovatele textovým řetězcem
    }

    public int getCitatel() {
       return citatel;
    }

    public int getJmenovatel() {
        return jmenovatel;
    }

    @Override
    public String toString() {
        return citatel + "/" + jmenovatel;
    }

    
    private int nejvetsiDelitel() {//eukliduv algoritmus
        int a = this.citatel;
        int b = this.jmenovatel;
        int pom;
        while (a != 0) {
            pom = a;
            a = b % a;
            b = pom;
        }
        return b;
    }

    private void simplyfy() {
        int faktor = nejvetsiDelitel();
        if (faktor > 1) {
            this.citatel = this.citatel / faktor;
            this.jmenovatel = this.jmenovatel / faktor;
        }

        if ((jmenovatel < 0 && citatel > 0) || (jmenovatel > 0 && citatel < 0)) {
            this.citatel = this.citatel * (-1);
            this.jmenovatel = this.jmenovatel * (-1);
        }
    }

}
