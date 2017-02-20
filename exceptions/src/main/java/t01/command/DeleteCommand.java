package t01.command;

import t01.ConsoleHelper;

import java.io.File;
import java.io.IOException;

/**
 * Created on 19.02.2017.
 */
public class DeleteCommand implements Command {

    private File file;

    @Override
    public void execute() throws IOException {
        //noinspection ResultOfMethodCallIgnored
        file.delete();
        File parentFile = file.getParentFile();
        Operation.Write.setFile(parentFile);
        Executor.getInstance().execute(Operation.View, parentFile);
    }

    @Override
    public Command setFile(File file) {
        this.file = file;
        return this;
    }
}

