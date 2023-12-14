package de.ait.battleship;

import java.util.Random;
import java.util.Scanner;

/* TODO реализация:
1. Если убит окружить корабли полем куда стрелять не надо
2. Изменить интерфейс картинками
3. Подумать как реализовать игру с компьютером
 */

public class BattleshipGame {
    private final char[][] board;
    private final int size;

    public BattleshipGame(int size) {
        this.size = size;
        this.board = new char[size][size];
        initializeBoard();
    }

    public void placeShipsRandomly() {
        Random random = new Random();
        int[] shipSizes = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1}; // Размеры кораблей

        for (int size : shipSizes) {
            boolean placed = false;
            while (!placed) {
                int x = random.nextInt(board.length);
                int y = random.nextInt(board[0].length);
                boolean isHorizontal = random.nextBoolean();

                if (canPlaceShip(x, y, size, isHorizontal)) {
                    placeShip(x, y, size, isHorizontal);
                    placed = true;
                }
            }
        }
    }

    private boolean canPlaceShip(int x, int y, int size, boolean isHorizontal) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}}; // Все направления для проверки отступов

        if (isHorizontal) {
            if (y + size > this.size) {
                return false; // Корабль выходит за пределы доски по горизонтали
            }
            for (int i = y; i < y + size; i++) {
                if (board[x][i] != '~') {
                    return false; // Есть перекрытие с другим кораблем
                }
                // Проверяем отступы между кораблями
                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = i + dir[1];
                    if (isValidCoordinate(newX, newY) && board[newX][newY] != '~') {
                        return false; // Есть отступы между кораблями
                    }
                }
            }
        } else {
            if (x + size > this.size) {
                return false; // Корабль выходит за пределы доски по вертикали
            }
            for (int i = x; i < x + size; i++) {
                if (board[i][y] != '~') {
                    return false; // Есть перекрытие с другим кораблем
                }
                // Проверяем отступы между кораблями
                for (int[] dir : directions) {
                    int newX = i + dir[0];
                    int newY = y + dir[1];
                    if (isValidCoordinate(newX, newY) && board[newX][newY] != '~') {
                        return false; // Есть отступы между кораблями
                    }
                }
            }
        }
        return true; // Можно разместить корабль
    }

    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < this.size && y >= 0 && y < this.size;
    }

    private void placeShip(int x, int y, int size, boolean isHorizontal) {
        if (isHorizontal) {
            for (int i = y; i < y + size; i++) {
                board[x][i] = 'O'; // Помечаем клетки корабля символом 'O'
            }
        } else {
            for (int i = x; i < x + size; i++) {
                board[i][y] = 'O'; // Помечаем клетки корабля символом 'O'
            }
        }
    }

    public static void displayBothBoards(BattleshipGame playerBoard, BattleshipGame opponentBoard) {
        System.out.println("   Ваша доска             Доска противника");
        System.out.println("   А Б В Г Д Е Ж З И Й    А Б В Г Д Е Ж З И Й");
        for (int i = 0; i < playerBoard.size; i++) {
            System.out.printf("%02d ", i + 1); // Форматирование чисел от 01 до 10

            // Отображение вашей доски
            for (int j = 0; j < playerBoard.size; j++) {
                System.out.print(playerBoard.getCell(i, j) + " ");
            }

            // Отображение разделителя между досками
            System.out.print("   ");

            // Отображение доски противника
            for (int j = 0; j < opponentBoard.size; j++) {
                char cell = opponentBoard.getCell(i, j); // Получение значения ячейки доски противника
                if (cell == 'O') {
                    cell = '~'; // Маскировка кораблей противника
                }
                System.out.print(cell + " ");
            }
            // Отображение чисел в последнем столбце доски противника
            System.out.printf("%02d", i + 1);

            System.out.println();
        }
        System.out.println("   А Б В Г Д Е Ж З И Й    А Б В Г Д Е Ж З И Й");
    }

    private void initializeBoard() {
        // инициализация доски '~' - пустая клетка
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '~';
            }
        }
    }

    public char getCell(int row, int column) {
        return board[row][column];
    }

    public void setCell(int row, int column, char c) {
        board[row][column] = c;
    }

    public boolean playerMove(BattleshipGame opponentBoard) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите координаты для атаки (например, А3): ");
        String input = scanner.next().toUpperCase();

        if (input.length() < 2 || input.length() > 3) {
            System.out.println("Неверный формат ввода!");
            return false;
        }

        char columnChar = input.charAt(0);
        int row;
        try {
            row = Integer.parseInt(input.substring(1)) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат ввода!");
            return false;
        }

        int column = columnChar - 'А'; // Получаем числовое значение столбца
        if (row < 0 || row >= size || column < 0 || column >= size) {
            System.out.println("Неверные координаты!");
            return false;
        }

        char cell = opponentBoard.getCell(row, column);
        if (cell == 'X' || cell == '*') {
            System.out.println("Эта клетка уже была атакована!");
            return false;
        }

        if (cell == '~') {
            System.out.println("Промах!");
            opponentBoard.setCell(row, column, '*');
        } else {
            System.out.println("Попадание!");
            opponentBoard.setCell(row, column, 'X');
        }

        return true;
    }

    public boolean isGameOver() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != '~' && board[i][j] != '*' && board[i][j] != 'X') {
                    return false; // Найден живой корабль - игра продолжается
                }
            }
        }
        return true; // Все корабли уничтожены - игра окончена
    }
}