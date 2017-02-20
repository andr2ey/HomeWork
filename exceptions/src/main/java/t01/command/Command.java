package t01.command;

import java.io.File;
import java.io.IOException;

/**
 * Created on 19.02.2017.
 */
public interface Command {
    void execute() throws IOException;
    Command setFile(File file);
}
