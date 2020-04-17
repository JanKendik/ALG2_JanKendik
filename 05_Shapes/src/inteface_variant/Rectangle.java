
package inteface_variant;



public class Rectangle implements ShapeInterface{
    private double a;
    private double b;
    private double area; //vypocitana

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
        this.area = area();
    }

    public double getArea() {
        return area;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public String toString() {
        return "Rectangle{" + "a=" + a + ", b=" + b + '}';
    }

    
    
    private double area(){
    return a*b;
    }
    
    public double computeArea(){
    return area;
    }
}
