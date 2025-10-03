import java.io.BufferedReader;
import java.io.FileReader;
/**
 * Challenge-10 --MapNavigator
 *
 * This program proivdes a playing broad where
 * depending on what file which has different moves will
 * move X to the corresponding motion, up down left and right
 *
 * @author Katie O'Daniel, L35
 *
 * @version October 30, 2023
 *
 */
public class MapNavigator extends Thread {
    private static int currentRow = 4;
    private static int currentColumn = 4;
    private static int moveNumber = 0;
    private static boolean started = false;
    private static char[][] map = new char[10][10];

    private int playerNumber;
    private String fileName;

    public MapNavigator(int playerNumber, String fileName) {
        this.playerNumber = playerNumber;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        if (!started) {
            initializeMap();
            started = true;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                int move = Integer.parseInt(line);
                processMove(move);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeMap() {
        synchronized (MapNavigator.class) {
            if (!started) {
                System.out.println("Welcome! Initial map:");
                for (int i = 0; i < 10; i++) {
                    System.out.print("[");
                    for (int j = 0; j < 10; j++) {
                        if (i == currentRow && j == currentColumn) {
                            map[i][j] = 'X';
                        } else {
                            map[i][j] = ' ';
                        }
                        System.out.print(map[i][j]);
                        if (j < 9) {
                            System.out.print("|");
                        }
                    }
                    System.out.println("]");
                    if (i < 9) {
                        System.out.println("---------------------");
                    }
                }
                System.out.println("---------------------");
            }
        }
    }

    private void processMove(int move) {
        synchronized (MapNavigator.class) {
            if (move < 1 || move > 4) {
                System.out.println("Move number: " + moveNumber);
                System.out.println("Player: " + playerNumber);
                System.out.println("Move: Error, invalid input!");
                printMap();
                return;
            }

            switch (move) {
                case 1: // Left
                    moveLeft();
                    break;
                case 2: // Right
                    moveRight();
                    break;
                case 3: // Up
                    moveUp();
                    break;
                case 4: // Down
                    moveDown();
                    break;
            }

            moveNumber++;
            System.out.println("Move number: " + moveNumber);
            System.out.println("Player: " + playerNumber);
            System.out.println("Move: " + getMoveName(move));
            printMap();
        }
    }

    private void moveLeft() {
        map[currentRow][currentColumn] = ' ';
        if (currentColumn == 0) {
            currentColumn = 9;
        } else {
            currentColumn--;
        }
        map[currentRow][currentColumn] = 'X';
    }

    private void moveRight() {
        map[currentRow][currentColumn] = ' ';
        if (currentColumn == 9) {
            currentColumn = 0;
        } else {
            currentColumn++;
        }
        map[currentRow][currentColumn] = 'X';
    }

    private void moveUp() {
        map[currentRow][currentColumn] = ' ';
        if (currentRow == 0) {
            currentRow = 9;
        } else {
            currentRow--;
        }
        map[currentRow][currentColumn] = 'X';
    }

    private void moveDown() {
        map[currentRow][currentColumn] = ' ';
        if (currentRow == 9) {
            currentRow = 0;
        } else {
            currentRow++;
        }
        map[currentRow][currentColumn] = 'X';
    }

    private void printMap() {
        synchronized (MapNavigator.class) {
            for (int i = 0; i < 10; i++) {
                System.out.print("[");
                for (int j = 0; j < 10; j++) {
                    System.out.print(map[i][j]);
                    if (j < 9) {
                        System.out.print("|");
                    }
                }
                System.out.println("]");
                if (i < 9) {
                    System.out.println("---------------------");
                }
            }
            System.out.println("---------------------");
        }
    }

    private String getMoveName(int move) {
        switch (move) {
            case 1:
                return "Left";
            case 2:
                return "Right";
            case 3:
                return "Up";
            case 4:
                return "Down";
            default:
                return "Unknown";
        }
    }
}
