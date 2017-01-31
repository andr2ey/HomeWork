package t03;

import t03.goods.office.Copybook;
import t03.goods.office.OfficeGood;
import t03.goods.office.Pen;
import t03.goods.office.Pencil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 19.01.2017.
 */
public class BeginnerKit {
    private List<OfficeGood> kit = new ArrayList<>();

    public BeginnerKit(OfficeGood... officeGoods) {
        kit.addAll(Arrays.asList(officeGoods));
    }

    public List<OfficeGood> getKit() {
        return kit;
    }

    @Override
    public String toString() {
        if (kit.isEmpty()) return "empty kit";
        StringBuilder sb = new StringBuilder();
        for (OfficeGood good : kit) {
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

        BeginnerKit set = new BeginnerKit(goods);
        System.out.println(set);
    }

}
