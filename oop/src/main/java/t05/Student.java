package t05;

/**
 * Created on 19.01.2017.
 */
public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
