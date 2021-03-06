package t01;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 12.02.2017.
 */
public class Highlighter {

    private static String[] keyWords = {"byte", "short", "int", "long", "char",
            "float", "double", "boolean", "if", "else",
            "switch", "case", "default", "while", "do",
            "break", "continue", "for", "try ", "catch",
            "finally", "throw", "throws", "private", "protected",
            "public", "import", "package", "class", "interface",
            "extends", "implements", "static", "final", "void",
            "abstract", "native", "new", "return", "this",
            "super", "synchronized", "volatile", "const", "goto",
            "instanceof", "enum", "assert", "transient", "strictfp"};

    public Highlighter() {
    }


    @SuppressWarnings("WeakerAccess")
    public void highlight(InputStream source, OutputStream target) {
        try (BufferedInputStream inputStream = new BufferedInputStream(source);
             PrintStream printer = new PrintStream(target)) {
            String text = readAll(inputStream);
            process(text, printer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("Duplicates")
    private static void process(String text, PrintStream printer) {
        for (String keyWord : keyWords) {
            Pattern pattern = Pattern.compile("(\\W|^)(" + keyWord + ")(?!\\w)");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                printer.println(matcher.group(2));
            }
        }
    }

    private String readAll(BufferedInputStream source) throws IOException {
        StringBuilder sb = new StringBuilder();
        byte[] buffer = new byte[1024];
        int len;
        while (source.available() != 0) {
            len = source.read(buffer);
            sb.append(new String(buffer, 0, len));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Highlighter highlighter = new Highlighter();
        try (FileInputStream fis = new FileInputStream("c://Users//user//IdeaProjects//HomeWork//io//src//main//resources//t01//text.txt");
             FileOutputStream fos = new FileOutputStream("c://Users//user//IdeaProjects//HomeWork//io//src//main//resources//t01//key words.txt")) {
            highlighter.highlight(fis, fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
