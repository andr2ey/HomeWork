package t01;

/**
 * Created by Andrey on 17.01.2017.
 */
public enum Color {
    Blue(0, 0, 255),
    Black(0, 0, 0),
    Red(255, 0, 0),
    Green(0, 255, 0);

    private int red;
    private int green;
    private int blue;

    Color(int red, int green, int blue) {
        this.red = (red < 0) ? 0 : (red > 255 ? 255 : red);
        this.green = (green < 0) ? 0 : (green > 255 ? 255 : green);
        this.blue = (blue < 0) ? 0 : (blue > 255 ? 255 : blue);
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase() + "(" + red + ", " + green + ", " + blue + ")";
    }


}
