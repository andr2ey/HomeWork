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
        CheckingLinks checking = new CheckingLinks(file, Charset.forName("utf-8"));
        System.out.println(checking.isSequence());

        String html = "(<(/?[^>]+)>)";
        String pattern2 = ".*?(<body>)((.*[\\s]*)*)(</body>).*?";
        // (\<(/?[^>]+)>)
        // (\<(\/?[^>]+)>)
        try(Scanner scanner = new Scanner(new FileInputStream(file))) {
            scanner.useDelimiter("YYYYYYY");
            String text = new String(scanner.next().getBytes(), Charset.forName("utf-8"));
            Matcher matcher = Pattern.compile(pattern2).matcher(text);
            System.out.println(matcher.find());
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            String string = matcher.group(2);

            Matcher matcherNEW = Pattern.compile(html).matcher(string);
            String deletedHTML = matcherNEW.replaceAll("");
            System.out.println(deletedHTML);
//            String result = matcher.replaceAll("");
//            System.out.println(result);

        }
    }
}
