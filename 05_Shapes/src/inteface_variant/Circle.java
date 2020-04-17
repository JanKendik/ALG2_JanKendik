
package inteface_variant;



public class Circle implements ShapeInterface {
//data
    private double r;

    private Circle(double r) {
        this.r = r;
    }
    
    //tovární metoda
    public static Circle getInstanceD(double d){
    return new Circle(d/2);
    }

    public static Circle getInstanceR(double r){
    return new Circle(r);
    }
    
    public double getR() {
        return r;
    }

    @Override
    public String toString() {
        return "Circle{" + "r=" + r + '}';
    }

    
    
    public double computeArea(){
    return Math.PI * r * r;
    }
    
    public static void main(String[] args) {
        Circle c1 = Circle.getInstanceR(2);
        Circle c2 = Circle.getInstanceD(10);
        System.out.println(c1.toString());
        System.out.println(c1.computeArea());
        
        
    }
    
}
