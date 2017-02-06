package t02;

/**
 * Created on 05.02.2017.
 */
public class Pair<Q, A> {
    Q q;
    A a;

    public Pair(Q q, A a) {
        this.q = q;
        this.a = a;
    }

    public Q getQ() {
        return q;
    }

    public A getA() {
        return a;
    }
}
