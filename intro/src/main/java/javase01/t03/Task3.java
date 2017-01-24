package javase01.t03;


import java.util.Collections;
import java.util.Formatter;
import java.util.Map;
import java.util.TreeMap;
import static java.lang.Math.*;

public class Task3 {

    public static String table(Map<Double, Double> mapArgValue) {
        if (mapArgValue.isEmpty())
            return "";
        StringBuilder sb = new StringBuilder();
        Formatter f = new Formatter(sb);
        f.format("%10s %10s\n", "argument", "value");
        for (Map.Entry entry : mapArgValue.entrySet())
            f.format("%10.2f %10.2e\n", entry.getKey(), entry.getValue());
        return sb.toString();
    }

    public static Map<Double, Double> getMapArgValue(double start, double finish, double step) {
        if (start > finish || step <= 0)
            return Collections.emptyMap();
        Map<Double, Double> mapArgVal = new TreeMap<>();
        for (double i = start; i < finish; i += step)
            mapArgVal.put(i, function(i));
        mapArgVal.put(finish, function(finish));
        return Collections.unmodifiableMap(mapArgVal);
    }

    public static double function(double x) {
        //checks x is specific when tan(2x) == infinity
        if ( (x % (PI/2)) != 0 && (x % (PI/4)) == 0)
            if ( sin(2*x) < 0 )
                return Double.NEGATIVE_INFINITY;
            else
                return Double.POSITIVE_INFINITY;
        return tan(2*x) - 3;
    }

    public static void main(String[] args) {
        System.out.println(table(getMapArgValue(1*PI*0.25, 10, 1)));
        System.out.println(table(getMapArgValue(2*PI*0.25, 10, 1)));
        System.out.println(table(getMapArgValue(3*PI*0.25, 10, 1)));
        System.out.println(table(getMapArgValue(4*PI*0.25, 10, 1)));
        System.out.println(table(getMapArgValue(5*PI*0.25, 10, 1)));
        System.out.println(table(getMapArgValue(6*PI*0.25, 10, 1)));
        System.out.println(table(getMapArgValue(7*PI*0.25, 10, 1)));
        System.out.println(table(getMapArgValue(8*PI*0.25, 10, 1)));
        System.out.println(table(getMapArgValue(9*PI*0.25, 10, 1)));
        System.out.println(table(getMapArgValue(10*PI*0.25, 10, 1)));
    }
}
