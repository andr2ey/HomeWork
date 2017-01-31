package t05;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 19.01.2017.
 */
public enum Discipline {
    Mathematics(false),
    Physics(false),
    Chemistry(false),
    English(true),
    Literature(true);

    private Map<Student, Number> students = new HashMap<>();
    boolean integer = false;

    Discipline(boolean integer){
        this.integer = integer;
    }

    void addStudent(Student student, Number mark) {
        int checkingMark = mark.intValue();
        if (checkingMark < 0 || checkingMark > 10)
            throw new IllegalArgumentException("mark is too negative or too much");
        this.students.put(student, mark);
    }

    String getMark(Student student) {
        Number mark = students.get(student);
        if (integer)
            return String.valueOf(mark.intValue());
        else
            return String.valueOf(Math.round(mark.doubleValue()*10)/10.0);
    }

    boolean exist(Student student) {
        return students.containsKey(student);
    }

    void deleteStudent(Student student) {
        students.remove(student);
    }
}
