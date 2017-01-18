package t02.goods;

/**
 * Created on 18.01.2017.
 */
public class OfficeGood {
    private double price;
    private String firm;

    public OfficeGood(double price, String firm) {
        this.price = price;
        this.firm = firm;
    }

    public double getPrice() {
        return price;
    }
}
