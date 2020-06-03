package app;

/**
 *
 * @author HP
 */
public class Calculator {

    private Item item;
    private double sumPrice;

    public Calculator(Item item) {
        this.item = item;
    }

    /**
     * Metoda počítající cenu položky, tedy cenu za kus položky násobenou počtem objednaných kusů
     * @param i
     */
    public void calculateSum(Item i) {
        this.item = i;
        sumPrice = i.getProduct().getPrice() * i.getnItems();

    }

    public Item getItem() {
        return item;
    }

    public double getSumPrice() {
        return sumPrice;
    }

    @Override
    public String toString() {
        return item.toString()+ String.format("%-10.2f", sumPrice);
    }
    

}
