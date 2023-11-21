package de.ait.javaio;

import java.io.IOException;

public class TestJavaIO {

    //Путь к интересующему нас файлу
    private static final String PATH = "/Users/developer/Documents/DEVELOPMENT/giftbowRepo/JavaLessonAIT/password.txt";

    //Экземпляр обьекта
    private  static JavaReadWritePassFile javaReadWritePassFile;

    public static void main(String[] args) {

        //инициализируем
        javaReadWritePassFile = new JavaReadWritePassFile(PATH);

        try {
            //читаем файл через вызов метода
            javaReadWritePassFile.readFile();
            //javaReadWritePassFile.writeFile("Hallo Cohort 33");
            javaReadWritePassFile.writeFileTwo("Guten Tag!!!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }



    }
}
