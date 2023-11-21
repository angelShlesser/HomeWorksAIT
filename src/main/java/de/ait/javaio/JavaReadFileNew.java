package de.ait.javaio;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JavaReadFileNew {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/developer/Documents/DEVELOPMENT/giftbowRepo/JavaLessonAIT/MyDirectory/Book.txt");
        file.createNewFile();

        Path path = Paths.get(file.getAbsolutePath());
        int counter = 0;
        String wordToCount = "Yesterday";
        List<String> linesInDocument = Files.readAllLines(path, StandardCharsets.UTF_8);
        for (String line: linesInDocument){
            System.out.println(line);
            if (line.contains(wordToCount)){
                counter ++;
            }
        }
        System.out.println("Counter --> " + counter);
        //linesInDocument.forEach(System.out::println);
    }
}
