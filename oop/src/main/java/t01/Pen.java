package t01;

/**
 * Created by Andrey on 17.01.2017.
 */
public class Pen {
    private boolean automatic;
    private double height;
    private double diameter;
    private Color inkColor;
    private String firm;

    /**
     *  Create default mechanic pen made by Pilot with a blue ink.
     * */
    public Pen(double height, double diameter) {
        this.height = height;
        this.diameter = diameter;
        this.automatic = false;
        this.inkColor = Color.Blue;
        this.firm = "Pilot";
    }

    public Pen(double height, double diameter, boolean automatic, Color inkColor, String firm) {
        this(height, diameter);
        this.automatic = automatic;
        this.inkColor = inkColor;
        this.firm = firm;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (this == other)
            return true;
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Pen otherPen = (Pen)other;
        return this.height == otherPen.height &&
                this.diameter == otherPen.diameter &&
                this.automatic == otherPen.automatic &&
                this.inkColor == otherPen.inkColor &&
                this.firm.equals(otherPen.firm);
    }

    @Override
    public String toString() {
        return automatic ? "automatic" : "mechanics" + " pen" +
                "(d=" + diameter + ", h=" + height +
                ") made by " + firm + " with a " +
                inkColor.toString().toLowerCase() + " ink";
    }
}
