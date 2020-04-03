package pkg05_shapes;

public class Ellipse extends Shape {

    private double a; //hlavni poloosa
    private double b; //vedlejší poloosa

    public Ellipse(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public String toString() {
        return "Ellipse{" + "a=" + a + ", b=" + b + '}';
    }

    public double computeArea(){
    double obsah = this.a * this.b * Math.PI;
    return obsah;
    }

}

