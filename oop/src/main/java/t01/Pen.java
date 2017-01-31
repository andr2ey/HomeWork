package t01;

/**
 * Created on 17.01.2017.
 *
 */
public class Pen {
    private boolean automatic;
    private double length;
    private double price;
    private RefillInk refillInk;
    private String firm;

    public Pen(double length, boolean automatic, RefillInk refillInk, String firm, double price) {
        this(length, automatic, refillInk);
        this.firm = firm;
        this.price = (price < 0) ? 0 : price;
    }

    public Pen(double length, boolean automatic, RefillInk refillInk) {
        this.length = (length < 20) ? 20 : length;
        this.automatic = automatic;
        this.refillInk = (refillInk == null) ? new RefillInk(Color.Blue) : refillInk;
        this.firm = "unknown firm";
        this.price = 0;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    public double getLength() {
        return length;
    }

    public double getPrice() {
        return price;
    }

    public RefillInk getInkColor() {
        return refillInk;
    }

    public String getFirm() {
        return firm;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (this == other)
            return true;
        if (getClass() != other.getClass()) {
            return false;
        }
        Pen otherPen = (Pen)other;
        return Double.compare(length, otherPen.length) == 0 &&
                Double.compare(price, otherPen.price) == 0 &&
                (automatic == otherPen.automatic) &&
                (refillInk == null ? otherPen.refillInk == null : refillInk.equals(otherPen.refillInk)) &&
                (firm == null ? otherPen.firm == null : firm.equals(otherPen.firm));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37*result + (firm == null? 0 : firm.hashCode());
        result = 37*result + (refillInk == null? 0 : refillInk.hashCode());
        result = 37*result + (automatic ? 1 : 0);
        long d = Double.doubleToLongBits(price);
        result = 37*result + (int)(d ^ (d >>> 32));
        long l = Double.doubleToLongBits(length);
        return  37*result + (int)(l ^ (l >>> 32));
    }

    @Override
    public String toString() {
        return (automatic ? "automatic" : "mechanics") + " pen" +
                "(price=" + price + ", length=" + length +
                ") made by " + firm + " with a " +
                refillInk.getInkColor() + " ink";
    }

    public static void main(String[] args) {
        System.out.println(new Pen(22.1, true, new RefillInk(Color.Black), "Pilot", 22));
    }
}
