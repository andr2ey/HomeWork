package t02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created on 06.02.2017.
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void write(String message) {
        System.out.println(message);
    }

    public static int readInt() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public static String readStr() throws IOException {
        return reader.readLine();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader readerTest = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(readerTest.readLine());
    }
}
