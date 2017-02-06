package t02;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created on 06.02.2017.
 */
public class QuestionApp {
    private Map<Integer, Pair<String, String>> questions;
    private Language currentLang;
    private ResourceBundle utilBundle;

    public QuestionApp(Language language) {
        this.currentLang = language;
        this.utilBundle = ResourceBundle.getBundle("util", language.getLocale());
        this.questions = Questions.questions(language);
    }

    public String answer(int number) {
        return questions.get(number).getA();
    }

    public String allQuestions() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Pair<String, String>> entry : questions.entrySet()) {
            sb.append(entry.getKey()).append(". ").append(entry.getValue().getQ()).append("\n");
        }
        return sb.toString();
    }

    public void changeLanguage(String language) {
        Language lang = Language.getLanguage(language);
        questions = Questions.questions(lang);
        utilBundle = ResourceBundle.getBundle("resources/util", lang.getLocale());
    }


    public static void main(String[] args) {
        QuestionApp app = new QuestionApp(Language.ENGLISH);
        ConsoleHelper.write(app.allQuestions());
        exit:
        while (true) {
            ConsoleHelper.write("Введите номер вопроса, чтобы получить ответ.\n" +
                    "Для изменение языка наберите en - Английский, ru - Русский.\n" +
                    "Введите exit, если желаете выйти из программы.");
            String string = null;
            try {
                string = ConsoleHelper.readStr();
                System.out.println(string);
                int number = Integer.parseInt(string);
            }
            catch (IOException e) {
                ConsoleHelper.write("Ошибка ввода.");
            }
            catch (NumberFormatException e) {
                switch (string) {
                    case "en":
                        app.changeLanguage(string);
                        ConsoleHelper.write(app.allQuestions());
                        break;
                    case "ru":
                        app.changeLanguage("ru");
                        ConsoleHelper.write(app.allQuestions());
                        break;
                    case "exit":
                        break exit;
                    default:
                        ConsoleHelper.write("Некоректный ввод");
                }
            }
        }
    }
}
