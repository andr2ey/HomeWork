package t01.command;

import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

/**
 * Created on 19.02.2017.
 */
public class Executor {
    private static final Executor instance = new Executor();

    private Map<Operation, Command> map = new EnumMap<>(Operation.class);

    private Executor() {
        File file = new File("");
        map.put(Operation.View, new ViewCommand(file));
        map.put(Operation.Help, new HelpCommand());
        map.put(Operation.Create, new CreateCommand());
        map.put(Operation.Delete, new DeleteCommand());
        map.put(Operation.Write, new WriteCommand());
    }

    public static Executor getInstance() {
        return instance;
    }

    public void execute(Operation operation, File file) throws IOException {
        map.get(operation).setFile(file).execute();
    }

}
