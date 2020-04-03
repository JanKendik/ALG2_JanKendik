
package pkg05_shapes;

public class Square extends Rectangle {
    private double a;
    
    public Square(double a){
    super(a, a);
        this.a = a;
    }

    @Override
    public String toString() {
        return "Square{" + "a=" + a + '}';
    }
    
    /*public static void main(String[] args) {
        Square s1 = new Square(5);
        System.out.println(s1.computeArea()); //vychází správně --> 25
    }*/
    
}
