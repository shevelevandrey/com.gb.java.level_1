package ru.geekbrains.java.level_1.lesson_4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    /**
     *
     * 1. Полностью разобраться с кодом, попробовать переписать с нуля
     * 2. Доработать все возможные варианты победы
     * 3. Предусмотреть ничью
     * 4. Предусмотреть проверку на допустимый диапазон значений вводимых координат пользователем, чтобы не выйти за пределы массива
     * 5. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока
     *
     * */

    private static final String gameTitle = "Tic tac toe";

    private static final char emptyCell = '-';
    private static final char playerCell = 'X';
    private static final char computerCell = 'O';

    private static int mapSize = 3;
    private static char[][] map;

    public static void main(String[] args) {
        runGame();
    }

    public static void setSizeMap(int size) {
        mapSize = size;
    }

    private static void setDefaultSetting() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nPlease, enter the size of the playing map: ");
        setSizeMap(scanner.nextInt());
    }

    private static void initMap() {
        map = new char[mapSize][mapSize];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = emptyCell;
            }
        }
    }

    private static void printMap() {
        String cell;

        System.out.println();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                cell = (j < map[i].length-1) ? String.format("%s|", map[i][j]) : String.format("%s", map[i][j]);
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    private static void doPlayerMove() {
        int xValue, yValue;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.printf("%nPlease enter the coordinates of your move, in the range [1, %s].%n", map.length);

            System.out.print("Y: ");
            yValue = scanner.nextInt();

            System.out.print("X: ");
            xValue = scanner.nextInt();
        } while(!isValidMove(xValue-1, yValue-1));

        map[yValue-1][xValue-1] = playerCell;
        printMap();
    }

    private static void doComputerMove() {
        int xValue, yValue;
        Random random = new Random();

        int[] cell = getTheBestCoordinates(computerCell, emptyCell);
        if (cell[0] != -1 && cell[1] != -1) {
            System.out.println("\nAI picked the best move:");
            yValue = cell[0];
            xValue = cell[1];
        } else {
            cell = getTheBestCoordinates(playerCell, emptyCell);
            if (cell[0] != -1 && cell[1] != -1) {
                System.out.println("\nAI picked the block move:");
                yValue = cell[0];
                xValue = cell[1];
            } else {
                do {
                    System.out.println("\nComputer generates coordinates.");
                    yValue = random.nextInt(map.length);
                    xValue = random.nextInt(map.length);
                } while (!isValidMove(xValue, yValue));
            }
        }
        System.out.printf("Y: %s%n", yValue + 1);
        System.out.printf("X: %s%n", xValue + 1);

        map[yValue][xValue] = computerCell;
        printMap();
    }

    private static int[] getTheBestCoordinates(char targetСell, char emptyCell) {
        int[] cell = new int[]{-1, -1};
        char[] verticalCells = new char[map.length];

        int diagonalCounterLef = 0;
        char[] diagonalCellsLeft = new char[map.length];

        int diagonalCounterRight = map.length-1;
        char[] diagonalCellsRight = new char[map.length];

        for (int i = 0; i < map.length; i++) {
            cell[1] = getPosTerminatingEmptyCell(map[i], targetСell, emptyCell);
            cell[0] = (cell[1] != -1) ? i : -1;
            if (cell[0] != -1 && cell[1] != -1) return cell;

            for (int j = 0; j < map[i].length; j++)
                verticalCells[j] = map[j][i];
            cell[0] = getPosTerminatingEmptyCell(verticalCells, targetСell, emptyCell);
            cell[1] = (cell[0] != -1) ? i : -1;
            if (cell[0] != -1 && cell[1] != -1) return cell;

            diagonalCellsLeft[diagonalCounterLef] = map[i][diagonalCounterLef];
            diagonalCounterLef++;

            diagonalCellsRight[diagonalCounterRight] = map[i][diagonalCounterRight];
            diagonalCounterRight--;
        }

        cell[0] = getPosTerminatingEmptyCell(diagonalCellsLeft, targetСell, emptyCell);
        cell[1] = cell[0];
        if (cell[0] != -1 && cell[1] != -1) return cell;

        cell[1] = getPosTerminatingEmptyCell(diagonalCellsRight, targetСell, emptyCell);
        if (cell[1] != -1) {
            diagonalCounterRight = map.length-1;
            for (int i = 0; i < map.length; i++) {
                if (diagonalCounterRight == cell[1]) {
                    cell[0] = i;
                }
                diagonalCounterRight--;
            }
        }

        return cell;
    }

    private static boolean isValidMove(int xValue, int yValue) {
        if ( (yValue < 0 || yValue >= map.length) || (xValue < 0 || xValue >= map.length) ) return false;
        if (map[yValue][xValue] != emptyCell) return false;

        return true;
    }

    private static boolean isFilledMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == emptyCell) return false;
            }
        }

        return true;
    }

    private static boolean isCellsEqual(char[] array, char cell) {
        int equalityCounter = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == cell) {
                equalityCounter++;
            } else {
                break;
            }
        }

        return (equalityCounter == array.length);
    }

    private static int getPosTerminatingEmptyCell(char[] array, char targetCell, char emptyCell) {
        int cellCounter = 0;
        int emptyCounter = 0;
        int pos = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == emptyCell) {
                emptyCounter++;
                pos = i;
            } else if (array[i] == targetCell) {
                cellCounter++;
            }
        }

        pos = ( emptyCounter == 1 && ((emptyCounter+cellCounter) == array.length) ) ? pos : -1;

        return pos;
    }

    private static boolean checkWin(char cell) {
        char[] verticalCells = new char[map.length];

        int diagonalCounterLef = 0;
        char[] diagonalCellsLeft = new char[map.length];

        int diagonalCounterRight = map.length-1;
        char[] diagonalCellsRight = new char[map.length];

        for (int i = 0; i < map.length; i++) {
            if (isCellsEqual(map[i], cell)) return true;

            for (int j = 0; j < map[i].length; j++)
                verticalCells[j] = map[j][i];
            if (isCellsEqual(verticalCells, cell)) return true;

            diagonalCellsLeft[diagonalCounterLef] = map[i][diagonalCounterLef];
            diagonalCounterLef++;

            diagonalCellsRight[diagonalCounterRight] = map[i][diagonalCounterRight];
            diagonalCounterRight--;
        }

        if (isCellsEqual(diagonalCellsLeft, cell)) return true;
        if (isCellsEqual(diagonalCellsRight, cell)) return true;

        return false;
    }

    public static void runGame() {
        System.out.printf("Good day! We offer you to play the game \"%s\".%n", gameTitle);

        setDefaultSetting();
        initMap();
        printMap();

        while (true) {
            doPlayerMove();
            if (checkWin(playerCell)) {
                System.out.println("\nPlayer win!!! ;)");
                break;
            } else if (isFilledMap()) {
                System.out.println("\nDraw in the game. :|");
                break;
            }

            doComputerMove();
            if (checkWin(computerCell)) {
                System.out.println("\nGame over. Computer win! :(");
                break;
            } else if (isFilledMap()) {
                System.out.println("\nDraw in the game. :|");
                break;
            }
        }

    }

}
