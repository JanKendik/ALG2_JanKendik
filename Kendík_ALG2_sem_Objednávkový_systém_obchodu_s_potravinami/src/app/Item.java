package app;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class Item implements Comparable<Item> {

    Product product;
    private int nItems;

    public Item(Product product, int nItems) {
        this.product = product;
        this.nItems = nItems;
    }

    public Product getProduct() {
        return product;
    }

    public int getnItems() {
        return nItems;
    }

    @Override
    public String toString() {
        return String.format("%-5d%-20s%-10.2f%-10d", product.getId(), product.getName(), product.getPrice(), nItems);
    }
    

    @Override
    public int compareTo(Item o) {
        return this.product.getId() - o.product.getId();
    }
/**
 * Porovnává podle názvů položek 
 */
    public static Comparator<Item> NameCompare = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            Collator col = Collator.getInstance(new Locale("cs", "CZ"));
            return o1.getProduct().getName().compareTo(o2.getProduct().getName());
        }
    };
}
