package t01.command;

import java.io.File;

/**
 * Created on 19.02.2017.
 */
public interface Command {
    void execute();
    Command setFile(File file);
}
