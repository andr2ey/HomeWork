package t01;


import t01.command.Executor;
import t01.command.Operation;

import java.io.File;
import java.io.IOException;

/**
 * Created on 19.02.2017.
 */
public class FileManager {


    public static void main(String[] args) throws IOException {
        ConsoleHelper.write("Enter: \"view (path to directory)\"\n" +
                "       \"viewAfter (name of current directory\'s folder)\"\n" +
                "       \"viewBefore\"\n" +
                "       \"help\"\n" +
                "       \"exit\"\n");
        String command = ConsoleHelper.read();
        Executor executor = new Executor();

        while (!command.equalsIgnoreCase("exit")) {

            Operation operation = Operation.choose(command);
            File file = operation.getFile();
            ConsoleHelper.write("Current path: " + file.getAbsolutePath());

            executor.execute(operation, file);

            command = ConsoleHelper.read();
        }
    }

}
