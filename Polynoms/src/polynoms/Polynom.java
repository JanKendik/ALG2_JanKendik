package polynoms;

import java.util.Arrays;

public class Polynom {
//data

    private double[] coef;

//konstruktory    
    private Polynom(double[] coef) {
        //defensivni kopie:
        double[] coefTemp = new double[coef.length];
        System.arraycopy(coef, 0, coefTemp, 0, coef.length);
        this.coef = coefTemp;
    }

//tovarni metoda (obal konstruktoru, abychom mohli mít více konstruktorů)
    public static Polynom getInstanceReverted(double[] coef) {
        return new Polynom(coef);
    }

    public static Polynom getInstance(double...coef) {
        double[] coefTemp = new double[coef.length];
        for (int i = 0; i < coef.length; i++) {
            coefTemp[coefTemp.length - 1 - i] = coef[i];
        }
        return new Polynom(coefTemp);
    }

    public int getDegree() {
        return coef.length - 1;
    }

    //metody
    //DC:
    //  5x3 + 3x2 + 6  pro x = 1, y= 5 + 3 + 6 =14....
    //pouzit hornerovo schema  
    public double computeValue(double x) {
       double vysledek = coef[coef.length - 1];
        for (int i = coef.length - 1; i > 0; i--) {
            vysledek = vysledek * x + coef[i - 1];
        }
        return vysledek;
    }
    public double getCoefAt(int exponent) {
        return coef[exponent];
    }

    public double[] getAllCoef() {
        return Arrays.copyOf(coef, coef.length);
    }

    //TODO
    //vypsat matematicky správně jako polynom
    @Override
    public String toString() {
        String tvar = "";
        if (coef[coef.length - 1] < 0) {
            tvar = "-";
        }
        for (int i = coef.length - 1; i > 0; i--) {
            if (coef[i] != 0) {
                tvar = tvar + Math.abs(coef[i]) + "x^" + i;
                if (coef[i - 1] >= 0) {
                    tvar = tvar + "+";
                } else {
                    tvar = tvar + "-";
                }
            }
        }
        tvar = tvar + coef[0];
        return tvar;
    }

    public Polynom derivate() {
        double[] coefD = new double[this.coef.length - 1]; //this. tam nemusí být pokud v matode nemam lokalní promennou
        for (int i = 0; i < coefD.length; i++) {
            coefD[i] = coef[i + 1] * (i + 1);
        }
        return new Polynom(coefD);
    }

    //TODO BONUS
    //metoda --> integral
    public double integrate(double a, double b) {

        double vysledek1;
        double[] coefIntegr = new double[coef.length + 1];
        for (int i = 1; i < coefIntegr.length; i++) {
            coefIntegr[i] = coef[i - 1] / i;
        }
        Polynom p = new Polynom(coefIntegr);
        vysledek1 = p.computeValue(b) - p.computeValue(a);
        return vysledek1;
    }

    public static void main(String[] args) {

        double[] a = {6, 0, 3, 5};
        Polynom P1 = Polynom.getInstanceReverted(a);
        System.out.println(P1);
        System.out.println(P1.getCoefAt(3));
        System.out.println(P1.derivate());
    }
}
