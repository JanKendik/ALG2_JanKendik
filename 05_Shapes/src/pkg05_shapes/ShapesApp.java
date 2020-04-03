package pkg05_shapes;

import java.util.ArrayList;
import java.util.Scanner;

public class ShapesApp {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Shape> pole = new ArrayList();

    public static void main(String[] args) {
        int volba;
        do {
            volba = Menu();
            switch (volba) {
                case 1:
                    Pridat();
                    break;
                case 2:
                    Vypis();
                    break;
                case 3:
                    System.out.println("Celková polcha vašich struktur je:" + celkovaPlocha());
                    break;
                case 4:
                    pole.clear();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Zadejte validní možnost z menu");
            }
        } while (volba != 5);
    }

    private static int Menu() {
        System.out.println("**********************************");
        System.out.println("Vyberte:");
        System.out.println("1) Přidat strukturu");
        System.out.println("2) Již zadané struktury");
        System.out.println("3) Celkový obsah všech vašich struktur");
        System.out.println("4) Reset seznamu");
        System.out.println("5) Konec");
        System.out.println("**********************************");
        int choice = sc.nextInt();
        return choice;
    }

    private static void Pridat() {
int volba;
do{
    volba = MenuPridani();
    switch(volba){
        case 1:
            System.out.println("Zadej poloměr kružnice");
            double r = sc.nextDouble();
            Circle c1 = Circle.getInstanceR(r);
            pole.add(c1);
            break;
        case 2:
            System.out.println("Zadej délku strany čtverce");
            double a = sc.nextDouble();
            Square s1 = new Square(a);
            pole.add(s1);
            break;
        case 3:
            System.out.println("Zadej délky dvou stran obdelníku");
            double b = sc.nextDouble();
            double c = sc.nextDouble();
            Rectangle r1 = new Rectangle(b,c);
            pole.add(r1);
            break;
        case 4:
            System.out.println("Zadej délku hlavní a vedlejší poloosy");
            double h = sc.nextDouble();
            double v = sc.nextDouble();
            Ellipse e1 = new Ellipse(h,v);
            pole.add(e1);
            break;
        case 5:
            System.out.println("Zadej strany validního trojúhelníka, tedy aby platila trojúhelníková nerovnost");
            double d = sc.nextDouble();
            double e = sc.nextDouble();
            double f = sc.nextDouble();
            if((d+e<f)||(d+f<e)||(e+f<d)){//opatření trojuhelnikove nerovnosti
            throw new IllegalArgumentException("Nebyla dodržena trojúhelníková nerovnost");
            }else {
            Triangle t1 = new Triangle(d,e,f);
            pole.add(t1);
            }
            break;
        case 6:
            System.out.println("Zadej délky čtyřech stran lichoběžníku");
            double g = sc.nextDouble();
            double hh = sc.nextDouble();
            double i = sc.nextDouble();
            double j = sc.nextDouble();
            Trapezoid tr1 = new Trapezoid(g,hh,i,j);
            pole.add(tr1);
            break;
        default:
            System.out.println("Zadej validní možnost z menu");
    }

}while(volba>0 && volba<7);
    }

    private static int MenuPridani() {
        System.out.println("*******************");
        System.out.println("Chcete přidat");
        System.out.println("1) Kružnice");
        System.out.println("2) Čtverec");
        System.out.println("3) Obdelník");
        System.out.println("4) Elipsu");
        System.out.println("5) Trojúhelník");
        System.out.println("6) Lichoběžník");
        System.out.println("*******************");
        int choice = sc.nextInt();
        return choice;
    }

    private static void Vypis() {
        System.out.println("Váš seznam obsahuje momentálně tyto struktury:");
        System.out.println("===============");
        for(Shape struktura : pole){
            System.out.println(struktura);
            System.out.println("---------------");
        }
        System.out.println("===============");
    }

    private static double celkovaPlocha() {
        double celkPlocha = 0;
        for(Shape struktura : pole){
        celkPlocha = celkPlocha + struktura.computeArea();
        }
        return celkPlocha;
    }

}
