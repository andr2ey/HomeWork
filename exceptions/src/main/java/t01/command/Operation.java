package t01.command;

import java.io.File;

/**
 * Created on 19.02.2017.
 */
public enum Operation {
    View;

    private static File currentFile;

    public File getFile() {
        return currentFile;
    }

    public void setFile(File file) {
        currentFile = file;
    }

    public static Operation choose(String command) {
        String trimedCommand = command.trim();

        if (trimedCommand.startsWith("view ")) {
            String[] commands = trimedCommand.split("\\s+");
            View.setFile(new File(commands[1]));
            return View;
        } else if (trimedCommand.startsWith("viewBefore")) {
            View.setFile(currentFile.getParentFile());
            return View;
        } else if (trimedCommand.startsWith("viewAfter ")) {
            String[] commands = trimedCommand.split("\\s+");
            View.setFile(new File(currentFile + "\\" + commands[1]));
            return View;
        }
        return null;
    }
}
