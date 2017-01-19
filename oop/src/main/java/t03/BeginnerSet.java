package t03;

import t03.goods.office.Copybook;
import t03.goods.office.OfficeGood;
import t03.goods.office.Pen;
import t03.goods.office.Pencil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created on 19.01.2017.
 */
public class BeginnerSet {
    private List<OfficeGood> list = new ArrayList<>();

    public BeginnerSet(OfficeGood... officeGoods) {
        list.addAll(Arrays.asList(officeGoods));
    }

    public List<OfficeGood> getList() {
        return list;
    }

    @Override
    public String toString() {
        if (list.isEmpty()) return "empty set";
        StringBuilder sb = new StringBuilder();
        for (OfficeGood good : list) {
            sb.append(good).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        OfficeGood[] goods = {new Pen(12.5),
                new Pen(7),
                new Copybook(11.2),
                new Pencil(15.7),
                new Pencil(7)};

        BeginnerSet set = new BeginnerSet(goods);
        System.out.println(set);
    }

}
