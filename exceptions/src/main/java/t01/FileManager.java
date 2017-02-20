package t01;


import t01.command.Executor;
import t01.command.Operation;
import t01.exception.InvalidOperationException;

import java.io.File;
import java.io.IOException;

/**
 * Created on 19.02.2017.
 */
public class FileManager {


    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeHelpInfo();
        String command = ConsoleHelper.read();
        Executor executor = Executor.getInstance();

        while (!command.equalsIgnoreCase("exit")) {
            try {
                Operation operation = Operation.choose(command);
                executor.execute(operation, operation.getFile());
            } catch (InvalidOperationException e) {
                ConsoleHelper.write(e.getMessage());
            }
            command = ConsoleHelper.read();
        }
    }

}
