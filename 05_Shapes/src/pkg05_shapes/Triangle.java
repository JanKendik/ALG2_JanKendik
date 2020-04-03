
package pkg05_shapes;

public class Triangle extends Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    @Override
    public String toString() {
        return "Triangle{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }
    
    public double computeArea(){
    double s; //poloviční obvod, nutný k použití heronova vzorce
    s=(this.a + this.b + this.c)/2; 
    double pom1 = (s - this.a);
    double pom2 = (s - this.b);
    double pom3 = (s - this.c);
    double obsah = Math.sqrt(s*pom1*pom2*pom3);
    return obsah;
    }
   
    
   /* public static void main(String[] args) {
        Triangle t = new Triangle(4,5,6.4); 
        System.out.println(t.computeArea());
    }*/
}
