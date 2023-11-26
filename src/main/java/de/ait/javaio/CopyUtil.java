package de.ait.javaio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CopyUtil {
    public static void main(String[] args) throws IOException {
        File fileSource = new File("files/source.txt");
        File fileDestination = new File("files/sourceCopy.txt");
        Files.copy(fileSource.toPath(),fileDestination.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
