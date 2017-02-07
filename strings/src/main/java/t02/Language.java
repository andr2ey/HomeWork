package t02;

import java.util.Locale;

/**
 * Created on 05.02.2017.
 */
public enum Language {
    ENGLISH(new Locale("en")),
    RUSSIAN(new Locale("ru"));

    private Locale locale;

    Language(Locale locale) {
        this.locale = locale;
    }

    public Locale getLocale() {
        return locale;
    }

    public static Language getLanguage(String language) {
        if (language.equals("en"))
            return ENGLISH;
        else if (language.equals("ru"))
            return RUSSIAN;
        else
            throw new IllegalArgumentException();
    }
}
