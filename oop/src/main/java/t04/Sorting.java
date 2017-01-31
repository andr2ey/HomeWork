package t04;

import t03.BeginnerKit;
import t03.goods.office.Copybook;
import t03.goods.office.OfficeGood;
import t03.goods.office.Pen;
import t03.goods.office.Pencil;

import java.util.Comparator;
import java.util.List;

/**
 * Created on 19.01.2017.
 */
public class Sorting<G> {

    private List<G> list;
    private Comparator<G> comparator;

    public Sorting(List<G> list, Comparator<G> comparator) {
        this.list = list;
        this.comparator = comparator;
        list.sort(comparator);
    }

    public void sort() {
        list.sort(comparator);
    }

    public void sort(Comparator<G> comparator) {
        this.comparator = comparator;
        list.sort(comparator);
    }

    public static void main(String[] args) {
        OfficeGood[] goods = {new Pen(12.5),
                new Pen(7),
                new Copybook(11.2),
                new Pencil(15.7),
                new Pencil(7)};

        BeginnerKit kit = new BeginnerKit(goods);
        System.out.println(kit);

        List<OfficeGood> list = kit.getKit();

        Sorting<OfficeGood> sorting = new Sorting<>(list, OfficeGood.ascendingNameComparator());
        System.out.println("Name sort");
        System.out.println(kit);

        sorting.sort(OfficeGood.descendingNameComparator());
        System.out.println("Name reverse sort");
        System.out.println(kit);

        sorting.sort(OfficeGood.ascendingPriceComparator());
        System.out.println("Price sort");
        System.out.println(kit);

        sorting.sort(OfficeGood.descendingPriceComparator());
        System.out.println("Price reverse sort");
        System.out.println(kit);

        sorting.sort(OfficeGood.complexComparator(OfficeGood.ascendingNameComparator(),
                                                             OfficeGood.ascendingPriceComparator()));
        System.out.println("Complex sort");
        System.out.println(kit);
    }
}
