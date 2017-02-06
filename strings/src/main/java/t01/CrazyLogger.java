package t01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 05.02.2017.
 */
public class CrazyLogger {
    public static final CrazyLogger instance = new CrazyLogger();

    private StringBuilder storage = new StringBuilder();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY : hh-mm");
    private final int PATTERN_LENGTH = 21;
    private String pattern = "[0-3]\\d-[0-1]\\d-2\\d{3} : [0-1]\\d-[0-6]\\d - ";

    private CrazyLogger() {
    }

    public static CrazyLogger getInstance() {
        return instance;
    }

    public void log(String message) {
        storage.append(sdf.format(new Date())).append(" - ").append(message).append("\n");
    }

    public void write(String regex, OutputStream outputStream) throws IOException {
        Matcher mainMatcher = Pattern.compile(pattern).matcher(storage);
        int beginDate = 0;
        int endMsg = 10;
        while (mainMatcher.find(beginDate+1)) {
            endMsg = mainMatcher.start();
            Matcher matcher = Pattern.compile(regex).matcher(storage.substring(beginDate, endMsg));
            if (matcher.find())
                write(beginDate, endMsg, outputStream);
            beginDate = mainMatcher.start();
        }
        Matcher matcher = Pattern.compile(regex).matcher(storage.substring(beginDate));
        if (matcher.find())
            write(beginDate, storage.length(), outputStream);
    }

    public void write(Date date, OutputStream outputStream) throws IOException {
        Matcher mainMatcher = Pattern.compile(pattern).matcher(storage);
        String dateStr = sdf.format(date) + " - ";
        int beginDate = 0;
        int endDate = PATTERN_LENGTH;
        int endMsg = 0;
        while (mainMatcher.find(beginDate+1)) {
            endMsg = mainMatcher.start();
            if (dateStr.equals(storage.substring(beginDate, endDate)))
                write(beginDate, endMsg, outputStream);
            beginDate = mainMatcher.start();
            endDate = mainMatcher.end();
        }
        if (dateStr.equals(storage.substring(beginDate, endDate)))
            write(beginDate, storage.length(), outputStream);
    }

    public void write(Date date, String regex, OutputStream outputStream) throws IOException {
        Matcher mainMatcher = Pattern.compile(pattern).matcher(storage);
        String dateStr = sdf.format(date) + " - ";
        int beginDate = 0;
        int endDate = PATTERN_LENGTH;
        int endMsg = 0;
        while (mainMatcher.find(beginDate+1)) {
            endMsg = mainMatcher.start();
            String dateWithMessage = storage.substring(beginDate, endMsg);
            Matcher matcher = Pattern.compile(regex).matcher(dateWithMessage);
            if (dateStr.equals(storage.substring(beginDate, endDate)) && matcher.find())
                write(beginDate, endMsg, outputStream);
            beginDate = mainMatcher.start();
            endDate = mainMatcher.end();
        }
        String dateWithMessage = storage.substring(beginDate, endMsg);
        Matcher matcher = Pattern.compile(regex).matcher(dateWithMessage);
        if (dateStr.equals(storage.substring(beginDate, endDate)) && matcher.find())
            write(beginDate, storage.length(), outputStream);
    }

    private void write(int start, int end, OutputStream outputStream) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write(storage.substring(start, end));
    }

    @Override
    public String toString() {
        return storage.toString();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        CrazyLogger logger = getInstance();

        logger.log("First error!");
        logger.log("Second error! \n Additional error!");
        logger.log("Third Error!");

        System.out.println(logger);
        System.out.println();

        System.out.println("search of REGEXP - [eE]rror");
        logger.write("[eE]rror", null);
        System.out.println();

        System.out.println("search of DATE");
        logger.write(new Date(), null);
        System.out.println();

        System.out.println("search of DATE and REGEXP - error");
        logger.write(new Date(), "error", null);
        System.out.println();
    }
}
