package t05;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 19.01.2017.
 */
public class Former {

    private Subject[] subjects = Subject.values();

    public String getMarks(Student student) {
        StringBuilder sb = new StringBuilder();
        sb.append(student).append(": ");
        for (Subject subject : subjects) {
            if (subject.exist(student))
                sb.append(subject).append("_").append(subject.getMark(student)).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Former former = new Former();

        Student andrey = new Student("Andrey");
        Student dima = new Student("Dima");

        for (Subject subject : former.subjects) {
            subject.addStudent(dima);
        }

        Subject.Chemistry.addStudent(andrey);
        Subject.Mathematics.addStudent(andrey);
        Subject.English.addStudent(andrey);

        System.out.println(former.getMarks(andrey));
        System.out.println(former.getMarks(dima));

        System.out.println((int)(Math.random()*5));
    }
}
