package t01.command;

import t01.exception.InvalidOperationException;

import java.io.File;

/**
 * Created on 19.02.2017.
 */
public enum Operation {
    View, Help, Create, Delete, Write;

    private static File currentFile;

    public File getFile() {
        return currentFile;
    }

    public void setFile(File file) {
        currentFile = file;
    }

    public static Operation choose(String command) throws InvalidOperationException {
        String trimmedCommand = command.trim();

        if (trimmedCommand.startsWith("view ")) {
            return verifyingView("", trimmedCommand.split("\\s+"));
        } else if (trimmedCommand.startsWith("viewBefore")) {
            return verifyingViewBefore();
        } else if (trimmedCommand.startsWith("viewAfter ")) {
            return verifyingViewAfter(currentFile + "\\", trimmedCommand.split("\\s+"));
        } else if (trimmedCommand.startsWith("create ")) {
            return verifyingCreate(trimmedCommand.split("\\s+"));
        } else if (trimmedCommand.startsWith("delete ")) {
            return verifyingDelete(trimmedCommand.split("\\s+"));
        } else if (trimmedCommand.startsWith("write ")) {
            return verifyingWrite(trimmedCommand.split("\\s+"));
        } else if (trimmedCommand.equals("help")) {
            return Help;
        }
        throw new InvalidOperationException("Invalid input of command word!");
    }

    private static Operation verifyingView (String prefix, String[] commands) throws InvalidOperationException {
        if (commands.length != 2)
            throw new InvalidOperationException("Invalid input path to directory!");
        if (commands[1].endsWith(":"))
            commands[1] += "\\";
        File file = new File(prefix + commands[1]);
        if (!file.isDirectory())
            throw new InvalidOperationException("Invalid input of path to directory!");
        View.setFile(file);
        return View;
    }

    private static Operation verifyingViewAfter (String prefix, String[] commands) throws InvalidOperationException {
        if (currentFile.isFile())
            throw new InvalidOperationException("Command \"viewAfter\" isn't available, " +
                    "because your current position isn't folder!");
        if (commands.length != 2)
            throw new InvalidOperationException("Invalid input path to directory!");
        File file = new File(prefix + commands[1]);
        if (!file.isDirectory())
            throw new InvalidOperationException("Invalid input of path to directory!");
        View.setFile(file);
        return View;
    }

    private static Operation verifyingViewBefore() throws InvalidOperationException {
        File file = currentFile.getParentFile();
        if (file == null)
            throw new InvalidOperationException("You can't watch folder before!");
        View.setFile(file);
        return View;
    }

    private static Operation verifyingCreate(String[] commands) throws InvalidOperationException {
        if (commands.length != 2)
            throw new InvalidOperationException("Invalid input path to directory!");
        if (currentFile.isFile())
            throw new InvalidOperationException("Command \"create\" isn't available, " +
                    "because your current position isn't folder!");
        Create.setFile(new File(currentFile + "\\" + commands[1]));
        return Create;
    }

    private static Operation verifyingDelete(String[] commands) throws InvalidOperationException {
        if (commands.length != 2)
            throw new InvalidOperationException("Invalid input path to directory!");
        if (currentFile.isFile())
            throw new InvalidOperationException("Command \"delete\" isn't available, " +
                    "because your current position isn't folder!");
        Delete.setFile(new File(currentFile + "\\" + commands[1]));
        return Delete;
    }

    private static Operation verifyingWrite(String[] commands) throws InvalidOperationException {
        if (commands.length != 2)
            throw new InvalidOperationException("Invalid input path to directory!");
        if (currentFile.isFile())
            throw new InvalidOperationException("Command \"write\" isn't available, " +
                    "because your current position isn't folder!");
        File file = new File(currentFile + "\\" + commands[1]);
        if (!currentFile.exists() && !currentFile.canWrite())
            throw new InvalidOperationException("Current file doesn't exist or you can't write in it!");
        Write.setFile(file);
        return Write;
    }
}
// view c:\_test1
// create n.txt
// write n.txt