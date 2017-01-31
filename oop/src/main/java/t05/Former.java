package t05;

/**
 * Created on 19.01.2017.
 */
public class Former {

    private Discipline[] disciplines = Discipline.values();

    public void add(Student student, Discipline discipline) {
        discipline.addStudent(student, Math.random()*5);
    }

    public void addEverywhere(Student student) {
        for (Discipline discipline : disciplines)
            add(student, discipline);
    }

    public void delete(Student student, Discipline discipline) {
        discipline.deleteStudent(student);
    }

    public String marks(Student student) {
        StringBuilder sb = new StringBuilder();
        sb.append(student).append(": ").append("\n");
        for (Discipline discipline : disciplines) {
            if (discipline.exist(student)) {
                sb.append(discipline).
                        append("_").
                        append(discipline.getMark(student)).
                        append(" ");
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Student andrey = new Student("Andrey");
        Student dima = new Student("Dima");

        Former former = new Former();
        former.addEverywhere(dima);

        former.add(andrey, Discipline.Mathematics);
        former.add(andrey, Discipline.English);

        System.out.println(former.marks(andrey));
        System.out.println(former.marks(dima));
    }
}
