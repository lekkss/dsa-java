import java.util.Arrays;

public class ArraysExample{
    public static void main(String[] args) {
        // int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
        // for (int i = 0; i < myNumbers.length; ++i) {
        //     for (int j = 0; j < myNumbers[i].length; j++) {
        //         System.out.println(myNumbers[i][j]);
        //     }
        // }

        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j]= '-';
            }
        }
        board[0][0]='O';
        board[1][0]='O';
        board[2][0]='O';
       System.out.println(Arrays.deepToString(board));
    }
    
}