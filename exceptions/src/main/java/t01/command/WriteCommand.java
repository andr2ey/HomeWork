package t01.command;

import t01.ConsoleHelper;

import java.io.*;

/**
 * Created on 20.02.2017.
 */
public class WriteCommand implements Command {

    private File file;

    @Override
    public void execute() throws IOException {
        ConsoleHelper.write("Enter: text or command \"end\"\n");
        String text = ConsoleHelper.read();
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
            randomAccessFile.seek(randomAccessFile.length());
            while (!text.equalsIgnoreCase("end")) {
                randomAccessFile.write((text + System.lineSeparator()).getBytes());
                text = ConsoleHelper.read();
            }
        }
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