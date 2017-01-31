package t03.goods;


import t03.goods.office.OfficeGood;

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

    public static Comparator<OfficeGood> ascendingPriceComparator() {
        return Comparator.comparingDouble(Good::getPrice);
    }

    public static Comparator<OfficeGood> descendingPriceComparator() {
        return ascendingPriceComparator().reversed();
    }

    public static Comparator<OfficeGood> ascendingNameComparator() {
        return Comparator.comparing(Good::getName);
    }

    public static Comparator<OfficeGood> descendingNameComparator() {
        return ascendingNameComparator().reversed();
    }

    public static Comparator<OfficeGood> complexComparator(Comparator<OfficeGood> first, Comparator<OfficeGood> second) {
        return first.thenComparing(second);
    }
}
