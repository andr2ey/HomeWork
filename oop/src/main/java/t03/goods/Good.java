package t03.goods;


import java.util.Comparator;

/**
 * Created on 19.01.2017.
 */
public abstract class Good implements t02.goods.Good {

    private double price;
    private final String name;

    protected Good(double price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%-10.10s%.2f $", name, price);
    }
}
