package javase01.t03;


import java.util.Formatter;
import java.util.Map;
import java.util.TreeMap;

public class Task3 {

    public static String tableOfArgumentValue(Map<Double, Double> mapArgValue) {
        if (mapArgValue.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Formatter f = new Formatter(sb);
        f.format("%10s %10s\n", "argument", "value");
        for (Map.Entry entry : mapArgValue.entrySet()) {
            f.format("%10.2f %10.2e", entry.getKey(), entry.getValue());
            f.format("\n");
        }
        return sb.toString();
    }

    public static Map<Double, Double> getMapArgValue(double start, double finish, double step) {
        if (start > finish || step <= 0) {
            throw new RangeException();
        }
        Map<Double, Double> mapArgVal = new TreeMap<>();
        for (double i = start; i < finish; i += step) {
            mapArgVal.put(i, function(i));
        }
        mapArgVal.put(finish, function(finish));
        return mapArgVal;
    }

    public static double function(double x) {
        //checks is x specific?
        double value = Math.cos(2*x);
        if (value < 6.1232339957367E-16 && value > -1.83697019872103E-16) {
            return Double.POSITIVE_INFINITY;
        }
        return Math.tan(2*x) - 3;
    }

    public static void main(String[] args) {
        System.out.println(tableOfArgumentValue(getMapArgValue(3*Math.PI*0.25, 10, 1)));
    }
}
