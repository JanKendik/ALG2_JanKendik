package pkg05_shapes;

public class Trapezoid extends Shape {

    private double a;
    private double b;
    private double c;
    private double d;

    public Trapezoid(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    @Override
    public String toString() {
        return "Trapezoid{" + "a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + '}';
    }

    public double computeArea() {
        double s = (this.a + this.b + this.c + this.d) / 2;
        double v = (2 / (Math.abs(this.a - this.c))) * Math.sqrt((s - this.a) * (s - this.c) * (s - this.b - this.c) * (s - this.d - this.c));
        double obsah = (((this.a + this.c) * v)/2);
        return obsah;  
    }

    /*public static void main(String[] args) {
        Trapezoid t = new Trapezoid(3,2.4,3,2.4);
        System.out.println(t.computeArea());
    }*/
}
