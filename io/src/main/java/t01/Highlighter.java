package t01;

import java.io.*;
import java.util.Scanner;
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
            "instanceof", "enum", "assert", "transient", "strictfp" };

    public Highlighter() {
    }

    public void highlight(InputStream source, OutputStream target) {
        try(Scanner scanner = new Scanner(source);
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(target))) {
//            keyWords = "(\\W|^)(int)(?!\\w)";

            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                for (String keyWord : keyWords) {
                    Pattern pattern = Pattern.compile("(\\W|^)(" + keyWord + ")(?!\\w)");
                    Matcher matcher = pattern.matcher(text);
                    while (matcher.find()) {
                        writer.println(matcher.group(2));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Highlighter highlighter = new Highlighter();
        try (FileInputStream fis = new FileInputStream("c://Users//user//IdeaProjects//HomeWork//io//src//main//resources//t01//text.txt");
             FileOutputStream fos = new FileOutputStream("c://Users//user//IdeaProjects//HomeWork//io//src//main//resources//t01//key words.txt")) {
            highlighter.highlight(fis, fos);
        } catch (FileNotFoundException e) {
            System.out.print("FileNotFoundException");
        } catch (IOException e) {
            System.out.print("IOException in main");
        }
    }
}
