package de.ait.javaio;

import java.io.File;
import java.io.IOException;

public class JavaFiles {
    public static void main(String[] args) throws IOException {
        /*
   Создаем объект File для файла "fileOne.txt" внутри директории "files"
   и выводим информацию о файле
*/
        File fileOne = new File("files/fileOne.txt");
        fileOne.mkdir(); // создаем директорию (если ее нет)
        // Создаем объект File для файла "fileOne.txt" внутри директории "files";

        try {
            // Пытаемся создать новый файл
            boolean created = fileOne.createNewFile();

            if (created) {
                System.out.println("Файл fileOne успешно создан.");
            } else {
                System.out.println("Файл fileOne уже существует.");
            }
        } catch (IOException e) {
            // Обрабатываем исключение, если произошла ошибка при создании файла
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }
        // Получаем путь к файлу в виде строки и выводим его в консоль
        String filePath = fileOne.getPath();
        System.out.println("Путь к файлу fileOne: " + filePath);

        // Получаем абсолютный путь к файлу в виде строки и выводим его в консоль
        String absolutePath = fileOne.getAbsolutePath();
        System.out.println("Абсолютный путь к файлу fileOne: " + absolutePath);

        // Получаем имя файла в виде строки и выводим его в консоль
        String fileName = fileOne.getName();
        System.out.println("Имя файла fileOne: " + fileName);

        // Создаем объект File для абсолютного пути к файлу "fileOne.txt"
        File fileOneAbsolute = new File("C:\\Users\\Vitali\\Documents\\GitHub\\homeworks\\files\\fileOne.txt");

        // Проверяем, является ли путь абсолютным и выводим результат в консоль
        System.out.println("Относительный путь: " + fileOne.isAbsolute()); // Вернет false
        System.out.println("Абсолютный путь: " + fileOneAbsolute.isAbsolute()); // Вернет true

        // Проверяем, можно ли читать файл, и выводим результат в консоль
        System.out.println("Доступ к чтению (canRead): " + fileOne.canRead());

        // Проверяем, можно ли записывать в файл, и выводим результат в консоль
        System.out.println("Доступ к записи (canWrite): " + fileOne.canWrite());

        // Проверяем, существует ли файл, и выводим результат в консоль
        System.out.println("Файл существует: " + fileOne.exists());

        // Проверяем, является ли объект File файлом, и выводим результат в консоль
        System.out.println("Это файл: " + fileOne.isFile());

        // Проверяем, является ли файл скрытым, и выводим результат в консоль
        System.out.println("Файл скрыт: " + fileOne.isHidden());

        // Получаем размер файла и выводим результат в консоль
        System.out.println("Размер файла в байтах (length): " + fileOne.length());

        // Получаем список файлов и подкаталогов в директории fileOne
        String[] filesInDirectory = fileOne.list();

        // Проверяем, не является ли fileOne файлом
        if (filesInDirectory != null) {
            System.out.println("Содержимое директории files:");
            for (String file : filesInDirectory) {
                System.out.println(fileName);
            }
        } else {
            System.out.println("fileOne представляет собой файл, а не директорию.");
        }

/*
   Переименование файла fileOne.txt в renamedFileOne.txt
   и выводим результат переименования
*/
        File renamedFile = new File("files/renamedFileOne.txt");
        boolean isRenamed = fileOne.renameTo(renamedFile);
        if (isRenamed) {
            System.out.println("Файл успешно переименован в 'renamedFileOne.txt'");
        } else {
            System.out.println("Не удалось переименовать файл");
        }

/*
   getTotalSpace(): Этот метод возвращает общий размер диска (или раздела), на котором находится файл или директория,
   в байтах. Общий размер диска - это общее физическое пространство, доступное на диске.
*/
        System.out.println("TotalSpace: " + fileOne.getTotalSpace() + " bytes");

/*
   getFreeSpace(): Этот метод возвращает количество свободного пространства на диске (или разделе), в байтах.
   Свободное пространство - это количество пространства, которое доступно на диске и может быть использовано.
*/
        System.out.println("FreeSpace: " + fileOne.getFreeSpace() + " bytes");

/*
   getUsableSpace() - это метод класса File, который возвращает количество доступного пространства на диске (или разделе), в байтах.
*/
        System.out.println("UsableSpace: " + fileOne.getUsableSpace() + " bytes");

/*
   Расскомментируйте следующий блок кода, если вы хотите удалить файл
   (раскомментируйте аккуратно, чтобы не случилось удаление по ошибке)
*/
/*
if (renamedFile.exists() && renamedFile.isFile()) {
    System.out.println("Удален файл " + renamedFile.getName() + " " + renamedFile.delete());
}
*/

/*
   File fileTwo = new File("C:\\Users\\Vitali\\Documents\\GitHub\\homeworks\\files\\fileTwo.txt");
   System.out.println("Путь в проекте fileTwo: " + fileTwo.getPath());
   System.out.println("Создание файла fileTwo " + fileTwo.createNewFile());
   System.out.println("AbsolutePath: " + fileTwo.getAbsolutePath());
   System.out.println("Проверка на создание абсолютного пути: " +fileTwo.isAbsolute());
*/

    }
}
