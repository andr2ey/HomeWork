package t02.goods;

/**
 * Created on 18.01.2017.
 */
public class OfficeGood implements Comparable<OfficeGood>, Good{
    private double price;
    private String name;

    public OfficeGood(double price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(OfficeGood another) {
        return name.compareTo(another.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OfficeGood good = (OfficeGood) o;

        if (Double.compare(good.price, price) != 0) return false;
        return name != null ? name.equals(good.name) : good.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp = Double.doubleToLongBits(price);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
