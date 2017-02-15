package t04;

import java.io.Serializable;

/**
 * Created on 15.02.2017.
 */
public class Actor implements Serializable {
    private String name;
    private String surname;

    public Actor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
