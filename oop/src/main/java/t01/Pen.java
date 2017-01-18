package t01;

/**
 * Created on 17.01.2017.
 *
 */
public class Pen {
    private boolean automatic;
    private double length;
    private double price;
    private Color inkColor;
    private String firm;

    /**
     *  Create default mechanic pen made by Pilot with a blue ink.
     * */
    public Pen(double length, double price) {
        this.length = length;
        this.price = price;
        this.automatic = false;
        this.inkColor = Color.Blue;
        this.firm = "Pilot";
    }

    public Pen(double length, double price, boolean automatic, Color inkColor, String firm) {
        this(length, price);
        this.automatic = automatic;
        this.inkColor = inkColor;
        this.firm = firm;
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

    public Color getInkColor() {
        return inkColor;
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
        return (length == otherPen.length) &&
                (price == otherPen.price) &&
                (automatic == otherPen.automatic) &&
                (inkColor == otherPen.inkColor) &&
                (firm == null ? otherPen.firm == null : firm.equals(otherPen.firm));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37*result + (firm == null? 0 : firm.hashCode());
        result = 37*result + (inkColor == null? 0 : inkColor.hashCode());
        result = 37*result + (automatic ? 1 : 0);
        long d = Double.doubleToLongBits(price);
        result = 37*result + (int)(d ^ (d >>> 32));
        long l = Double.doubleToLongBits(length);
        return  37*result + (int)(l ^ (l >>> 32));
    }

    @Override
    public String toString() {
        return automatic ? "automatic" : "mechanics" + " pen" +
                "(price=" + price + ", length=" + length +
                ") made by " + firm + " with a " +
                inkColor.toString().toLowerCase() + " ink";
    }

    public static void main(String[] args) {
        Pen pen1 = new Pen(10.1, 22);
        System.out.println(pen1);

        Pen pen4 = new Pen(10.2, 22);
        System.out.println(pen1.equals(pen4));
        System.out.println(pen1.getLength() == pen4.getLength());
    }
}
