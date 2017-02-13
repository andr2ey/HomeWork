package t03;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created on 13.02.2017.
 */
public class Copier {

    @SuppressWarnings("WeakerAccess")
    public static void copy(InputStream source, Charset charsetSrc,
                            OutputStream target, Charset charsetTarget) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(source, charsetSrc));
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(target, charsetTarget))) {
            while (reader.ready()) {
                writer.append(reader.readLine()).append("\n");
            }
        }
    }

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(
                "c://Users//user//IdeaProjects//HomeWork//io//src//main//resources//t03//utf-8");
             FileOutputStream fos = new FileOutputStream(
                     "c://Users//user//IdeaProjects//HomeWork//io//src//main//resources//t03//utf-16")) {
            copy(fis, Charset.forName("utf-8"), fos, Charset.forName("utf-16"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
