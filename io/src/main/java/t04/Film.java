package t04;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 15.02.2017.
 */
public class Film implements Serializable {

    private String name;
    private List<Actor> actors;

    public Film(List<Actor> actors, String name) {
        this.actors = actors;
        this.name = name;
    }

    public List<Actor> getActors() {
        return actors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if (name != null ? !name.equals(film.name) : film.name != null) return false;
        return actors != null ? actors.equals(film.actors) : film.actors == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (actors != null ? actors.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"").append(name).append("\"").append("\n");
        for (Actor actor : actors) {
            sb.append(actor).append("\n");
        }
        return sb.toString();
    }
}
