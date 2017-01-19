package t02;



import t02.goods.Good;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created on 18.01.2017.
 */
public class Workplace implements Accountable<Good>{

    private static int counterId = 1;
    private int id = counterId++;
    private Map<Good, Integer> goods;

    public Workplace() {
        goods = new TreeMap<>();
    }

    public void addGood(Good good) {
        if (goods.containsKey(good)) {
            int number = goods.get(good);
            goods.put(good, ++number);
        } else {
            goods.put(good, 1);
        }
    }

    public void deleteGood(Good good) {
        if (goods.containsKey(good)) {
            int number = goods.get(good);
            if (number > 1)
                goods.put(good, --number);
            else
                goods.remove(good);
        }
        else {
            goods.put(good, 1);
        }
        goods.remove(good);
    }

    public void clear() {
        goods.clear();
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return Workplace.class.getSimpleName();
    }

    @Override
    public double totalCost() {
        double totalCost = 0;
        for(Map.Entry<Good, Integer> entry : goods.entrySet()) {
            totalCost += entry.getKey().getPrice() * entry.getValue();
        }
        return totalCost;
    }

    @Override
    public int itemsNumber() {
        int counter = 0;
        for (Map.Entry<Good, Integer> entry : goods.entrySet()) {
            counter += entry.getValue();
        }
        return counter;
    }

    @Override
    public Map<Good, Integer> goods() {
        return goods;
    }
}
