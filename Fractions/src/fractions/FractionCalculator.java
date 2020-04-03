package fractions;

public class FractionCalculator {

    private FractionCalculator() {
    }

    public static Fraction Add(Fraction f1, Fraction f2) {
        int spolj = f1.getJmenovatel() * f2.getJmenovatel();
        Fraction vysl = new Fraction(((spolj / f1.getJmenovatel()) * f1.getCitatel()) + ((spolj / f2.getJmenovatel()) * f2.getCitatel()), spolj);
        return vysl;
    }

    public static Fraction Subtract(Fraction f1, Fraction f2) {
        int spolj = f1.getJmenovatel() * f2.getJmenovatel();
        Fraction vysl = new Fraction(((spolj / f1.getJmenovatel()) * f1.getCitatel()) - ((spolj / f2.getJmenovatel()) * f2.getCitatel()), spolj);
        return vysl;
    }

    public static Fraction Multiply(Fraction f1, Fraction f2) {
        Fraction vysl = new Fraction((f1.getCitatel() * f2.getCitatel()), (f1.getJmenovatel() * f2.getJmenovatel()));
        return vysl;
    }

    public static Fraction Divide(Fraction f1, Fraction f2) {
        Fraction revf2 = new Fraction(f2.getJmenovatel(), f2.getCitatel());
        Fraction vysl = Multiply(f1, revf2);
        return vysl;
    }

}
