package t02;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created on 05.02.2017.
 */
public class Questions {
    private static int QUESTIONS_NUMBER = 2;
    private static ResourceBundle resourceBundle;

    public static Map<Integer, Pair<String, String>> questions(Language language) {
        resourceBundle = ResourceBundle.getBundle("question", language.getLocale());
        Map<Integer, Pair<String,String>> map = new HashMap<>();
        for (int i = 1; i <= QUESTIONS_NUMBER; i++) {
            Pair<String, String> pair = new Pair<>(resourceBundle.getString("question.q" + i),
                    resourceBundle.getString("question.a" + i));
            map.put(i, pair);
        }
        return map;
    }

}
