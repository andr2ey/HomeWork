package t06;

import t07.MetaInfo;

/**
 * Created on 20.01.2017.
 */
@MetaInfo(author = "Andrey", lastModified = "20/01/2017")
public class NuclearSubmarine {

    private Engine engine = new Engine();

    private class Engine {
        private void start() {
            System.out.println("Engine has started");
        }
    }

    public void startEngine() {
        engine.start();
        System.out.println("Submarine is working and it can be floating");
    }

    public static void main(String[] args) {
        NuclearSubmarine submarine = new NuclearSubmarine();
        submarine.startEngine();

        NuclearSubmarine.Engine engine = submarine.new Engine();
        engine.start();
    }
}
