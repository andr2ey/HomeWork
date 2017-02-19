package t04;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Дана коллекция фильмов, содержащая информацию об актерах, снимавшихся в главных ролях (один актер мог сниматься и в
нескольких фильмах).
Необходимо написать приложение, позволяющее при запуске восстанавливать коллекцию фильмов,
позволять ее модифицировать, а по завершении работы приложения – сохранять (в файл). Для восстановления/сохранения
коллекции использовать  сериализацию/десериализацию.
*/
public class FilmCollection implements Serializable {

    private Set<Film> films;
    private File pathToFile;

    @SuppressWarnings("WeakerAccess")
    public FilmCollection(File pathToFile) {
        try {
            films = read(pathToFile);
        } catch (ClassNotFoundException | IOException e) {
            films = new HashSet<>();
        }
        this.pathToFile = pathToFile;
    }

    public Set<Film> getFilms() {
        return films;
    }

    @SuppressWarnings("WeakerAccess")
    public void add(Film film) {
        films.add(film);
    }

    @SuppressWarnings("WeakerAccess")
    public void remove(Film film) {
        films.remove(film);
    }

    @SuppressWarnings("WeakerAccess")
    public void write() throws IOException {
        try(ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(pathToFile))) {
            objectOut.writeObject(films);
        }
    }

    private Set<Film> read(File pathToFile) throws IOException, ClassNotFoundException {
        try(ObjectInputStream objectOut = new ObjectInputStream(new FileInputStream(pathToFile))) {
            @SuppressWarnings("unchecked")
            Set<Film> set = (HashSet<Film>) objectOut.readObject();
            return set;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Film Collection").append("\n");
        for (Film film : films) {
            sb.append(film);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String path = "c://Users//user//IdeaProjects//HomeWork//io//src//main//resources//t04//films.txt";
        File pathToFile = new File(path);

        FilmCollection filmCollection = new FilmCollection(pathToFile);

        System.out.println(filmCollection);

        Actor actorIvan = new Actor("Ivan", "Petrov");
        Actor actorValentin = new Actor("Valentin", "Semenov");

        List<Actor> actorsOfComedy = new ArrayList<>();
        actorsOfComedy.add(actorIvan);
        actorsOfComedy.add(actorValentin);
        List<Actor> actorsOfThriller = new ArrayList<>();
        actorsOfThriller.add(actorIvan);

        Film comedy = new Film(actorsOfComedy, "Comedy");
        Film thriller = new Film(actorsOfThriller, "Thriller");
        filmCollection.add(comedy);
        filmCollection.remove(thriller);

        System.out.println(filmCollection);

        filmCollection.write();
    }
}
