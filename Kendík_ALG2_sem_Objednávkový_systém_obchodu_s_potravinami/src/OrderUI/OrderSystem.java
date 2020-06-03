package OrderUI;

import app.Item;
import app.Order;
import app.Product;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import utils.InvalidInput;
import utils.OrderInterface;

public class OrderSystem {

    public static Scanner sc = new Scanner(System.in);
    public static OrderInterface o;

    /**
     * Spouštění celého programu
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        o = new Order();
        boolean end = false;
        String choice;
        while (!end) {
            seeMenu();
            choice = sc.next();
            try {
                int choiceInt = Integer.parseInt(choice);
                switch (choiceInt) {
                    case 1:
                        orderMenu();
                        break;
                    case 2:
                        end = true;
                        break;
                    default:
                        System.out.println(new InvalidInput("Nevalidní vstup"));
                }
            } catch (NumberFormatException x) {
                System.out.println(new InvalidInput("Nevalidní vstup"));
            }
        }

    }

    /**
     * Přidání položky do existující objednávky
     */
    public static void addItemToOrderUI() {
        boolean end = false;
        try {
            while (!end) {
                Item i;
                i = addItem();
                o.addItemToOrder(i);
                System.out.println(o.getItemInfo());
                System.out.println("Přídat další položku? a/n");
                String choice = sc.next();
                end = choice.toLowerCase().charAt(0) == 'n';
            }
            System.out.println("Zadejte název souboru objednávky");
            String orderFile = sc.next();
            o.saveItemToOrder(orderFile);
        } catch (IOException x) {
            System.out.println("nesprávný vstup");
        }
    }

    /**
     * Definování položky, kterou chceme přidat do objednávky
     */
    private static Item addItem() {
        Product p;
        Item i;
        try {
            System.out.println("definování produktu");
            System.out.println("Zadej ID produktu");
            String idIn = sc.next();
            System.out.println("Zadej název produktu");
            sc.useDelimiter(Pattern.compile("[\\n;]"));
            String nameIn = sc.next();
            if (nameIn.matches("[a-zA-Z0-20._-]+[ ]+[a-zA-Z0-20._-]+")) {
                nameIn = nameIn.replace(" ", "_");
            }
            System.out.println("Zadej cenu produktu");
            String priceIn = sc.next();

            System.out.println("definování položky na objednávce");
            System.out.println("Zadej kolik kusů zadaného produktu objednáváte");
            String nItemsIn = sc.next();

            int id = Integer.parseInt(idIn);
            double price = Double.parseDouble(priceIn);
            int nItems = Integer.parseInt(nItemsIn);
            p = new Product(id, nameIn, price);
            i = new Item(p, nItems);
            return i;
        } catch (NumberFormatException e) {
            System.out.println("Nepodařilo se naparsovat");
        }
        return null;
    }

    /**
     * Vizuální stránka hlavního menu programu
     */
    public static void seeMenu() {
        System.out.println("=====================================================");
        System.out.println("Objednávkový systém ");
        System.out.println("Vyberte:");
        System.out.println("1 - Správa objednávky");
        System.out.println("2 - Konec");
        System.out.println("=====================================================");
    }

    /**
     * Vizuální stránka objednávkového menu
     */
    public static void seeOrderMenu() {
        System.out.println("=====================================================");
        System.out.println("Vyberte co chcete dělat s objednávkou:");
        System.out.println("1 - Přidat položku");
        System.out.println("2 - Vypsat objednávku do konzole se sumou cen");
        System.out.println("3 - Vypsat objednávku do konzole setříděnou podle ID");
        System.out.println("4 - Vypsat objednávku do konzole setříděnou podle názvů");
        System.out.println("5 - Celková suma k úhradě");
        System.out.println("6 - Uložit a ukončit");
        System.out.println("=====================================================");

    }
/**
 * Programová realizace objednávkového menu
 */
    private static void orderMenu() {
        System.out.println("Načítání objednávky:");
        try {
            loadOrder();
            boolean end1 = false;
            int choice1;
            while (!end1) {
                seeOrderMenu();
                String choice = sc.next();
                try {
                    choice1 = Integer.parseInt(choice);
                    switch (choice1) {
                        case 1:
                            addItemToOrderUI();
                            break;
                        case 2:
                            o.calculateSumPrice();
                            System.out.println(o.getCalculatorInfo());
                            break;
                        case 3:
                            System.out.println(o.getItemInfoSortedByID());
                            break;
                        case 4:
                            System.out.println(o.getItemInfoSortedByName());
                            break;
                        case 5:
                            System.out.println(o.getSumToPay() + "Kč");
                            break;
                        case 6:
                            System.out.println("Uložení objednávky:");
                            System.out.println("Zadej název výstupního souboru(povolené formáty: .txt , .xlsx , .dat)");
                            String billFile = sc.next();
                            try {
                                o.saveBill(billFile);
                            } catch (IOException ex) {
                                System.out.println("Nepodařilo se uložit");
                            }
                            end1 = true;
                            break;
                        default:
                            System.out.println(new InvalidInput("Nevalidní vstup"));
                    }
                } catch (NumberFormatException x) {
                    System.out.println("Nevalidní vstup (očekává se číslo)");
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Soubor se nezdařilo nalézt");
        }
    }

    /**
     * Načítání objednávky, se kterou se poté bude operovat
     * @throws FileNotFoundException
     */
    private static void loadOrder() throws FileNotFoundException {
        System.out.println("Zadej název souboru objednávky:");
        String orderFile = sc.next();
        o.load(orderFile);
    }

}

    

//menu
