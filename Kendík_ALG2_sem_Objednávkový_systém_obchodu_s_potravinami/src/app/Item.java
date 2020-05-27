
package app;

public class Item extends Order{
    private String name;
    private int price;
    private int nItems;

    public Item(String name, int price, int nItems) {
        this.name = name;
        this.price = price;
        this.nItems = nItems;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setnItems(int nItems) {
        this.nItems = nItems;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", price=" + price + ", nItems=" + nItems + '}';
    }

    
    
}
