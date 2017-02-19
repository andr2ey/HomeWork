package t01.command;

import java.io.File;
import java.util.EnumMap;
import java.util.Map;

/**
 * Created on 19.02.2017.
 */
public class Executor {

    private Map<Operation, Command> map = new EnumMap<>(Operation.class);

    public Executor() {
        File file = new File("");
        map.put(Operation.View, new ViewCommand(file));
    }

    public void execute(Operation operation, File file) {
        map.get(operation).setFile(file).execute();
    }

}
