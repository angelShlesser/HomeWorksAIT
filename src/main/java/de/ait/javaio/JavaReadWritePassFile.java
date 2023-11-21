package de.ait.javaio;


import java.io.*;

public class JavaReadWritePassFile {

    //для чтения файла
    private InputStream inputStream;

    //для внесения изменения в файл
    private OutputStream outputStream;

    //путь с интересующему файлу
    private String path;

    public JavaReadWritePassFile(String path) {
        this.path = path;
    }

    //считываем файл
    public void readFile() throws IOException {
        //инициализируем чтение потока
        inputStream = new FileInputStream(path);

        //считываем первый символ
       int data = inputStream.read();
       double  content;
       //считываем содержимое файла побайтово
       while (data != -1){

           //байт-->символ
           content = (double) data;

           //Выводим полученный символ
           System.out.println(content);

           data = inputStream.read();

       }
        //закрываем поток
       inputStream.close();
    }

    // записываем в файл
    public void writeFile(String stringToWrite) throws IOException {
        //инициализируем поток на запись
        outputStream =  new FileOutputStream(path);

        //вносим внесение записи в файл/поток
        outputStream.write(stringToWrite.getBytes());


        //закрытие потока
        outputStream.close();

    }


    public void writeFileTwo(String stringToWrite)  {
        //инициализируем поток на запись
        try {
            outputStream =  new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        }

        //вносим внесение записи в файл/поток
        try {
            outputStream.write(stringToWrite.getBytes());
            //закрытие потока
            outputStream.close();
        } catch (IOException e) {
           System.out.println("IOException");
        }





    }

}
