package t02;

import java.util.Map;

/**
 * Created on 18.01.2017.
 */
public interface Accountable<G> {
    int getId();
    String getName();
    double totalCost();
    int overallAmount();
    Map<G, Integer> goods();
}
