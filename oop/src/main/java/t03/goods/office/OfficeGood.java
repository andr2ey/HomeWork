package t03.goods.office;

import t03.goods.Good;


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

}
