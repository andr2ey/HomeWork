package t02;

import java.util.Map;

/**
 * Created on 18.01.2017.
 */
public interface Accountable<G> {
    double totalCost();
    int itemsNumber();
    Map<G, Integer> goods();
}
