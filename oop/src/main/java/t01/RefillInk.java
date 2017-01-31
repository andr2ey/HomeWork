package t01;

/**
 * Created on 31.01.2017.
 */
public class RefillInk {
    private Color inkColor;

    public RefillInk(Color inkColor) {
        this.inkColor = inkColor;
    }

    public RefillInk() {
        this.inkColor = Color.Black;
    }

    public Color getInkColor() {
        return inkColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        RefillInk refillInk = (RefillInk) o;
        return inkColor == refillInk.inkColor;
    }

    @Override
    public int hashCode() {
        return inkColor.hashCode();
    }
}
