package t02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        this.utilBundle = ResourceBundle.getBundle("util", currentLang.getLocale());
        this.questions = Questions.questions(currentLang);
        System.out.println(allQuestions());
    }

    public Language getCurrentLang() {
        return currentLang;
    }

    public ResourceBundle getUtilBundle() {
        return utilBundle;
    }

    public void answer(int number) {
        if (number > questions.size() || number < 1) {
            System.out.println(utilBundle.getString("util.incorrect.input"));
            return;
        }
        System.out.println(questions.get(number).getA());
    }

    public void process(String string) {
        if (string.equals("en"))
            changeLanguage(string);
        else if(string.equals("ru"))
            changeLanguage(string);
        else
            System.out.println(utilBundle.getString("util.incorrect.input"));
    }

    private void changeLanguage(String language) {
        Language changedLang = Language.getLanguage(language);
        if (changedLang == currentLang)
            return;
        currentLang = changedLang;
        questions = Questions.questions(currentLang);
        utilBundle = ResourceBundle.getBundle("util", currentLang.getLocale());
        System.out.println(allQuestions());
    }

    private String allQuestions() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Pair<String, String>> entry : questions.entrySet()) {
            sb.append(entry.getKey()).append(". ").append(entry.getValue().getQ()).append("\n");
        }
        sb.append(utilBundle.getString("util.introduce"));
        return sb.toString();
    }

    public static void main(String[] args) {
        QuestionApp app = new QuestionApp(Language.ENGLISH);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String string = reader.readLine();
            while (!string.equalsIgnoreCase("exit")) {
                try {
                    app.answer(Integer.parseInt(string));
                } catch (NumberFormatException e) {
                    app.process(string);
                }
                string = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("IOException");
        }
    }
}

