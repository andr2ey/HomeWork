package t02;

import t02.goods.OfficeGood;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 18.01.2017.
 */
public class Workplace {
    private static int counter = 1;
    private int id = counter++;
    private List<OfficeGood> officeGoods;

    public Workplace() {
        this.id = id;
        officeGoods = new ArrayList<>();
    }

    public void addGood(OfficeGood good) {
        officeGoods.add(good);
    }

    public void addGood(int position, OfficeGood good) {
        officeGoods.add(position - 1, good);
    }

    public void deleteGood(OfficeGood good) {
        officeGoods.remove(good);
    }

    public void deleteGood(int position) {
        officeGoods.remove(position);
    }

    public void clear() {
        officeGoods.clear();
    }

    public double costsOfGoods() {
        double totalPrice = 0;
        for(OfficeGood good : officeGoods) {
            totalPrice += good.getPrice();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        return sb.toString();
    }
}
