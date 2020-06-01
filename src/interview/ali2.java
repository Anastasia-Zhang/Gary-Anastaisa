package interview;

import java.util.Scanner;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/23 19:25
 */
public class ali2 {
    public static int count = 0;
    public static int countFly = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++){
            board[i] = sc.nextLine().toCharArray();
        }
        int[][] startPosition = new int[1][2];
        int[][] endPosition = new int[1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                if (board[i][j] == 'S'){
                    startPosition[0][0] = i;
                    startPosition[0][1] = j;
                }
                if (board[i][j] == '#'){
                    endPosition[0][0] = i;
                    endPosition[0][1] = j;
                }
            }
        }
        countTimes(board, startPosition, endPosition);
        System.out.println(count);
    }

    public static void countTimes(char[][] boards, int[][] start, int[][] ends){
        int[][] dp = new int[boards.length][boards[0].length];

        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards[0].length; j++){
                if (boards[i][j] == '#') continue;

            }
        }
    }
}
