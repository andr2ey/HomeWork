package t02;


import t02.goods.Good;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created on 18.01.2017.
 */
public class Workplace implements Accountable<Good> {

    private static int counterId = 1;
    private int id = counterId++;
    private Map<Good, Integer> goods;

    public Workplace() {
        goods = new TreeMap<>();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return Workplace.class.getSimpleName();
    }

    public void addGood(Good good) {
        if (goods.containsKey(good)) {
            int amount = goods.get(good);
            goods.put(good, ++amount);
        } else {
            goods.put(good, 1);
        }
    }

    public void deleteGood(Good good) {
        if (!goods.containsKey(good))
            return;
        int amount = goods.get(good);
        if (amount > 0)
            goods.put(good, --amount);
    }

    public void deleteAllGoods(Good good) {
        goods.put(good, 0);
    }

    public void clearGood(Good good) {
        goods.remove(good);
    }

    public void clear() {
        goods.clear();
    }

    @Override
    public double totalCost() {
        double totalCost = 0;
        for (Map.Entry<Good, Integer> good : goods.entrySet())
            totalCost += good.getKey().getPrice() * good.getValue();
        return totalCost;
    }

    @Override
    public int overallAmount() {
        int counter = 0;
        for (Map.Entry<Good, Integer> good : goods.entrySet()) {
            counter += good.getValue();
        }
        return counter;
    }

    @Override
    public Map<Good, Integer> goods() {
        return goods;
    }
}
