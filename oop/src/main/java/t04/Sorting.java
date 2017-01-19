package t04;

import t03.BeginnerSet;
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
    }

    public void applyComparator() {
        list.sort(comparator);
    }

    public void applyComparator(Comparator<G> comparator) {
        this.comparator = comparator;
        list.sort(comparator);
    }

    public static void main(String[] args) {
        OfficeGood[] goods = {new Pen(12.5),
                new Pen(7),
                new Copybook(11.2),
                new Pencil(15.7),
                new Pencil(7)};

        BeginnerSet set = new BeginnerSet(goods);
        System.out.println(set);

        List<OfficeGood> list = set.getList();

        Sorting<OfficeGood> sorting = new Sorting<OfficeGood>(list, OfficeGood.ascendingNameComparator());
        sorting.applyComparator();
        System.out.println("Name sort");
        System.out.println(set);

        sorting.applyComparator(OfficeGood.descendingNameComparator());
        System.out.println("Name reverse sort");
        System.out.println(set);

        sorting.applyComparator(OfficeGood.ascendingPriceComparator());
        System.out.println("Price sort");
        System.out.println(set);

        sorting.applyComparator(OfficeGood.descendingPriceComparator());
        System.out.println("Price reverse sort");
        System.out.println(set);

        sorting.applyComparator(OfficeGood.complexComparator(OfficeGood.ascendingNameComparator(),
                                                             OfficeGood.ascendingPriceComparator()));
        System.out.println("Complex sort");
        System.out.println(set);
    }
}
