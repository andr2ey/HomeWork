package t01.command;

import com.sun.istack.internal.NotNull;
import t01.ConsoleHelper;

import java.io.File;

/**
 * Created on 19.02.2017.
 */
public class ViewCommand implements Command {

    private File file;

    public ViewCommand(@NotNull File file) {
        this.file = file;
    }

    public ViewCommand setFile(File file) {
        this.file = file;
        return this;
    }

    @Override
    public void execute() {
        //noinspection ConstantConditions
        for (File f : file.listFiles()) {
            if (f.canRead()) {
                ConsoleHelper.write(f.getName());
            }
        }
    }
}
