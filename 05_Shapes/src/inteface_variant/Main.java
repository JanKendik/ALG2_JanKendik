package inteface_variant;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Circle c1 = Circle.getInstanceD(8);
        Rectangle r1 = new Rectangle(2, 3);
        Circle c2 = Circle.getInstanceR(2.6);

        //plocha všech
        System.out.println("1. varianta");
        double allArea = c1.computeArea() + r1.getArea() + c2.computeArea();
        System.out.println(allArea);

        System.out.println("2. varianta, pomocí pole");
        ArrayList shapes2 = new ArrayList(); //dynamicke pole objektů typu Object
        shapes2.add(c1);
        shapes2.add(c2);
        shapes2.add(r1);
        // shapes2.add(Circle.getInstanceR(2.6));

        double allArea2 = 0;
        for (int i = 0; i < shapes2.size(); i++) {
            if (shapes2.get(i) instanceof Circle) {
                allArea2 += ((Circle) shapes2.get(i)).computeArea();
            } else if (shapes2.get(i) instanceof Rectangle) {
                allArea2 += ((Rectangle) shapes2.get(i)).computeArea();
            }
        }
        System.out.println(allArea2);

        System.out.println("3. varianta");//dynamicke pole objektů pro cokoli kompatibilni s shapeinterface 
        ArrayList<ShapeInterface> shapes3 = new ArrayList<>();
        shapes3.add(c1);
        shapes3.add(c2);
        shapes3.add(r1);
//muze obsahovat cokoli co je typově kompatibilni s "Shape"
        //ShapeInterface s = new Rectangle(6, 5);
        double allArea3 = 0;
        for (ShapeInterface shape : shapes3) {
            allArea3 += shape.computeArea();//polymorfismus
        }
        System.out.println(allArea3);
    }

}
