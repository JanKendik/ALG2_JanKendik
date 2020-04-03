
package fractions;

public class Fractions {

    public static void main(String[] args) {
    Fraction z1 = new Fraction(4,3);
    Fraction z2 = new Fraction(2,5);
    Fraction z3 = new Fraction(33,11);
        System.out.println(z1.toString());
        System.out.println(z2.toString());
        System.out.println(z3.toString()); //správně zkrátí na 3/1
        System.out.println(FractionCalculator.Add(z1, z2));
        System.out.println(FractionCalculator.Subtract(z1, z2));
        System.out.println(FractionCalculator.Multiply(z1, z2));
        System.out.println(FractionCalculator.Divide(z1, z2));
    }
    
}
