package t03.goods.office;

import t03.goods.Good;

import java.util.Comparator;


/**
 * Created on 19.01.2017.
 */
public abstract class OfficeGood extends Good {

    private static int idCounter = 1;
    private final int id = idCounter++;

    protected OfficeGood(double price, String name) {
        super(price, name);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + "# " + super.toString();
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
