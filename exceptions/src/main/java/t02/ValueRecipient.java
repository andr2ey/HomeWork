package t02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
Создать “универсальный” класс, позволяющий получить значение из любого properties-файла.
Физическое чтение файла должно происходить только один раз.
Обработайте следующие исключительные ситуации: нет файла *.properties, нет ключа в properties-файле.
 */
public class ValueRecipient {

    private String pathToFile;
    private Properties properties;

    public ValueRecipient(String pathToFile) {
        this.pathToFile = pathToFile;
        File file = new File(pathToFile);
        properties = new Properties();
        try {
            properties.load(new FileReader(file));
        } catch (IOException e) {
            System.err.println("File doesn't exist or it was mistake at reading.");
        }
    }

    public String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value != null) {
            return value;
        } else {
            System.err.println("Such value doesn't exist.");
            return "";
        }
    }

    public static void main(String[] args) {
        ValueRecipient valueRecipient = new ValueRecipient(
                "c://Users//user//IdeaProjects//HomeWork//exceptions//src//main//resources//util.properties");
        System.out.println(valueRecipient.getProperty("exit"));
    }
}
