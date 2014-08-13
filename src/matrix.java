import java.io.*;
import java.lang.*;

public class matrix {
    public static String fileName;
    public static int x,y;

    public static void main(String[] args) throws IOException {
        setFileName(fileName); setX(x); setY(y);                             // set setters
        BufferedReader reader = new BufferedReader(new FileReader(fileName));//read file
        int[][] matrix = new int[x][y];
        String[] s = new String[x];
        for (int i = 0; i < x; i++) {
            s[i] = reader.readLine();
            for (int j = 0; j < y; j++) {
                matrix[i][j] = Character.getNumericValue(s[i].charAt(j));     //write file matrix in program
            }
        }
        int answer = calculateBlocks(matrix);                                 // calculating domens in matrix
        System.out.println(answer);
    }
    // calculating domens in matrix
    public static int calculateBlocks(int[][] matrix) throws IOException {
        int blockNumber = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] > 0) {
                    if (isStartBlock(i, j, matrix, true)) {
                        blockNumber++;
                        matrix[i][j] = blockNumber;
                    }
                }
            }
        }
        return blockNumber;
    }
    // if block ==1, start finding another 1 around "StartBlock"
    public static boolean isStartBlock(int i, int j, int[][] matrix, boolean bCheckLeft) throws IOException {
        if (bCheckLeft && i > 0 && matrix[i - 1][j] > 0) {
            matrix[i][j] = matrix[i - 1][j];
            return false;
        }
        if (j > 0 && matrix[i][j - 1] > 0) {
            matrix[i][j] = matrix[i][j - 1];
            return false;
        }
        if (i + 1 < x && matrix[i + 1][j] > 0) {
            return isStartBlock(i + 1, j, matrix, false);
        }
        return true;
    }
    // reading Filename
    public static void setFileName(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        matrix.fileName = reader.readLine();
    }
    // count size x-vector
    public static void setX(int x) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String str = "";
        int strings = 0;
        while ((str = reader.readLine()) != null) {
            strings++;
        }
        matrix.x = strings;
}
    // count size y-vector
    public static void setY(int y) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String s = reader.readLine();
        matrix.y = s.length();
    }
}

