package t02;

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
            "instanceof", "enum", "assert", "transient", "strictfp" };

    public Highlighter() {
    }

    @SuppressWarnings("WeakerAccess")
    public void highlight(Reader source, Writer target) {
        try(BufferedReader reader = new BufferedReader(source);
            PrintWriter writer = new PrintWriter(target)) {
            while (reader.ready()) {
                String text = reader.readLine();
                process(text, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("Duplicates")
    private void process(String text, PrintWriter writer) {
        for (String keyWord : keyWords) {
            Pattern pattern = Pattern.compile("(\\W|^)(" + keyWord + ")(?!\\w)");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                writer.println(matcher.group(2));
            }
        }
    }


    public static void main(String[] args) {
        Highlighter highlighter = new Highlighter();
        try (FileReader fr = new FileReader("c://Users//user//IdeaProjects//HomeWork//io//src//main//resources//t01//text.txt");
             FileWriter fw = new FileWriter("c://Users//user//IdeaProjects//HomeWork//io//src//main//resources//t01//key words.txt")) {
            highlighter.highlight(fr, fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}