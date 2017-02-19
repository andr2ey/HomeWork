package t01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created on 19.02.2017.
 */
public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void write(String message) {
        System.out.println(message);
    }

    public static String read() throws IOException {
        return reader.readLine();
    }
}
