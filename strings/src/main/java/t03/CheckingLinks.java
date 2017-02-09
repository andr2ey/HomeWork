package t03;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 07.02.2017.
 */

/*
Необходимо определить в тексте статьи* (html-файл) t03.html, ссылается ли автор на рисунки последовательно
(т.е. )
или нет, а также выделить все предложения, в которых встречаются ссылки на рисунки. Для разбора текста использовать
регулярные выражения.
Все виды ссылок:
(рис. 8)
(Рис. 1)
(Рис. 1, 2)
(Рис. 25 и 26)
(Рис. 8-б)
(Рис. 8-г,д)
рисунке 1
рисунка 17
рисунках (а,б,в)
*/
public class CheckingLinks {
    private String pattern = "(\\([рР]ис\\. \\d+[,и \\d]*\\))|(рисунк[ае] \\d+)";
    private File file =
            new File("c://Users//user//IdeaProjects//HomeWork//strings//src//main//resources//t03.html");
    private Charset fileCharset;

    public CheckingLinks(File file, Charset fileCharset) {
        this.file = file;
        this.fileCharset = fileCharset;
    }

    public boolean isSequence()  throws FileNotFoundException {
        if (!file.exists())
            throw new FileNotFoundException();
        try(Scanner scanner = new Scanner(new FileInputStream(file))) {
            scanner.useDelimiter("</body>");
            String text = new String(scanner.next().getBytes(), fileCharset);
            return sequence(pattern, text);
        }
    }

    private boolean sequence(String pattern, String text) {
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        int counterLinks = 0;
        while (matcher.find()) {
            Matcher matcherForGroup = Pattern.compile("\\d+").matcher(matcher.group());
            while (matcherForGroup.find()) {
                int currentReference = Integer.parseInt(matcherForGroup.group());
                if (currentReference > counterLinks + 1)
                    return false;
                else if (currentReference == counterLinks + 1)
                    counterLinks++;
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file =
                new File("c://Users//user//IdeaProjects//HomeWork//strings//src//main//resources//t03.html");

        String html = "(<(/?[^>]+)>)|(&nbsp[;]?)";
        String textPattern = ".*<body>((.*[\\s]*)*)</body>.*";
        String sentencePattern = "([А-Я](.+?)([^рР][^и][^сА-Я])[.?!])";
        String linksPattern = "(\\([рР]ис\\. \\d+[,и \\d]*\\))|(рисунк[ае] \\d+)";


        try(Scanner scanner = new Scanner(new FileInputStream(file))) {
            scanner.useDelimiter("AaA");//for full text
            String text = new String(scanner.next().getBytes(), Charset.forName("utf-8"));

            Matcher textMatcher = Pattern.compile(textPattern).matcher(text);
            //noinspection ResultOfMethodCallIgnored
            textMatcher.find();
            String textWithTags = textMatcher.group(1);

            Matcher tagsMatcher = Pattern.compile(html).matcher(textWithTags);
            String textWithoutTags = tagsMatcher.replaceAll("");

            Matcher sentenceMatcher = Pattern.compile(sentencePattern).matcher(textWithoutTags);
            for (int i = 1; sentenceMatcher.find(); i++) {
                System.out.println(i + "# " + sentenceMatcher.group());
            }

            System.out.println("--------------------------------------------------------------------");
            System.out.println("SEARCH of SENTENCES WITH LINKS");
            System.out.println("--------------------------------------------------------------------");

            sentenceMatcher.reset();
            boolean isConsistent = true;
            int counterLinks = 0;
            for (int i = 1; sentenceMatcher.find(); i++) {
                Matcher linksMatcher = Pattern.compile(linksPattern).matcher(sentenceMatcher.group());
                while (linksMatcher.find()) {
                    System.out.println(i + "# " + sentenceMatcher.group());
                    Matcher numberMatcher = Pattern.compile("\\d+").matcher(linksMatcher.group());
                    while (numberMatcher.find()) {
                        int currentReference = Integer.parseInt(numberMatcher.group());
                        if (currentReference > counterLinks + 1)
                            isConsistent = false;
                        else if (currentReference == counterLinks + 1)
                            counterLinks++;
                    }
                }
            }
            System.out.println("Are links consistent: " + isConsistent);

        }
    }
}
