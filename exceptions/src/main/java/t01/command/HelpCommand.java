package t01.command;

import t01.ConsoleHelper;

import java.io.File;

/**
 * Created on 19.02.2017.
 */
public class HelpCommand implements Command {

    private File file;

    @Override
    public void execute() {
        ConsoleHelper.write("Current file: " + (file == null ? "no": file.getAbsolutePath()) + "\n");
        ConsoleHelper.writeHelpInfo();
    }

    @Override
    public Command setFile(File file) {
        this.file = file;
        return this;
    }
}
