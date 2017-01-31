package t02;

/**
 * Created on 18.01.2017.
 */
public class Worker {
    private Workplace workplace;
    private String name;

    public Worker(String name, Workplace workplace) {
        this.name = name;
        this.workplace = workplace;
    }

    public Workplace getWorkplace() {
        return workplace;
    }

    public String getName() {
        return name;
    }
}
