package de.ait.javaio;

import ch.qos.logback.core.subst.Tokenizer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class JavaReadFile {

    public static void main(String[] args) throws IOException {


        File file = new File("/Users/developer/Documents/DEVELOPMENT/giftbowRepo/JavaLessonAIT/MyDirectory/Book.txt");
        file.createNewFile();
        //Создаем и инициализируем FileReader для чтения содержимого файла
        FileReader fileReader = new FileReader(file);
        //Создаем и инициализируем BufferReader для считывания строк
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int counter = 0;
        String wordToCount = "Yesterday";
        String lineInDocument = bufferedReader.readLine();
        if( lineInDocument != null && lineInDocument.contains(wordToCount)){
            counter++;
        }
        //если документ не пустой то запускаем цикл на построчное считывание
        while (lineInDocument != null){
            System.out.println(lineInDocument);
            //считываем строку
            lineInDocument = bufferedReader.readLine();
            if( lineInDocument != null && lineInDocument.contains(wordToCount)){
                counter++;
            }
        }
        System.out.println("Counter --> " + counter);
    }




}
