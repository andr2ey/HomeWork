package t01;

import java.io.File;
import java.io.IOException;

/*
 Разработать приложение, позволяющее ПРОСМАТРИВАТЬ (listFiles)
 файлы и каталоги файловой системы, а также СОЗДАВАТЬ и УДАЛЯТЬ (createNewFile, delete)
 текстовые файлы. Для работы с текстовыми файлами необходимо РЕАЛИЗОВАТЬ (canWrite, canRead)
 функциональность записи (дозаписи) в файл.
 Требуется ОПРЕДЕЛИТЬ ИСКЛЮЧЕНИЯ
 для каждого слоя приложения и корректно их обработать.
 */
public class TestFile {

    public static void main(String[] args) throws IOException {
        File file = new File("c://_test1");

        System.out.println();
        System.out.println("isDirectory() " + file.isDirectory());
        System.out.println("getName() " + file.getName());

        System.out.println();
        System.out.println("getAbsolutePath() " + file.getAbsolutePath());
        System.out.println("getCanonicalPath() " + file.getCanonicalPath());

        System.out.println();
        System.out.println("getParent() " + file.getParent());
        System.out.println("canExecute() " + file.canExecute());
        System.out.println("canWrite() " + file.canWrite());
        System.out.println("canRead() " + file.canRead());

        System.out.println();
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println("files " + file1.getName());
        }

        System.out.println();
        System.out.println("getParentFile() " + file.getParentFile());

        System.out.println();
        File[] files1 = file.getParentFile().listFiles();
        for (File file1 : files1) {
            System.out.println("files " + file1.getName());
        }

    }

}
