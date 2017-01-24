package t05;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 19.01.2017.
 */
public enum Subject {
    Mathematics() {
        private Map<Student, Double> students = new HashMap<>();

        public boolean exist(Student student) {
            return students.containsKey(student);
        }

        public String getMark(Student student) {
            return String.valueOf(String.format("%.2f", students.get(student)));
        }

        public void addStudent(Student student) {
            this.students.put(student, Math.random());
        }
    },
    Physics() {
        private Map<Student, Double> students = new HashMap<>();

        public boolean exist(Student student) {
            return students.containsKey(student);
        }

        public String getMark(Student student) {
            return String.valueOf(String.format("%.2f", students.get(student)));
        }

        public void addStudent(Student student) {
            this.students.put(student, Math.random());
        }
    },
    Chemistry() {
        private Map<Student, Double> students = new HashMap<>();

        public boolean exist(Student student) {
            return students.containsKey(student);
        }

        public String getMark(Student student) {
            return String.valueOf(String.format("%.2f", students.get(student)));
        }

        public void addStudent(Student student) {
            this.students.put(student, Math.random());
        }
    },
    English() {
        private Map<Student, Integer> students = new HashMap<>();

        public boolean exist(Student student) {
            return students.containsKey(student);
        }

        public String getMark(Student student) {
            return String.valueOf(students.get(student));
        }

        public void addStudent(Student student) {
            this.students.put(student, (int)(Math.random()*5));
        }
    },
    Literature() {
        private Map<Student, Integer> students = new HashMap<>();

        public boolean exist(Student student) {
            return students.containsKey(student);
        }

        public String getMark(Student student) {
            return String.valueOf(students.get(student));
        }

        public void addStudent(Student student) {
            this.students.put(student, (int)(Math.random()*5));
        }
    };

    public abstract void addStudent(Student student);
    public abstract String getMark(Student student);
    public abstract boolean exist(Student student);
}
