import java.util.Arrays;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/13 21:39
 */
public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = new int[][]
            {
                new int[]{0,1,0},
                new int[]{0,0,1},
                new int[]{1,1,1},
                new int[]{0,0,0}
            };
        gameOfLife(board);
    }
    /**
     * 标记
     * 1 ： 1-》1
     * -1： 1-》0
     * 0 ： 0-》0
     * -2： 0-》1
     * */
    public static void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
               // System.out.println("start marking.....");
                board[i][j] = checkLoc(board, i, j);
               // System.out.println("marking done....." + board[i][j] + " ");
            }
        }
//        for (int[] a : board){
//            System.out.println(Arrays.toString(a));
//        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                // 如果被标记为 1 或 -2 都代表最后变成1
                board[i][j] = board[i][j] == 1 || board[i][j] == -2 ? 1 : 0;
            }
        }
    }

    public static int checkLoc(int[][] board, int i, int j){
        int count = 0;
        int left = Math.max(j - 1, 0);
        int right = Math.min(j + 1, board[i].length - 1);
        int top = Math.max(i - 1, 0);
        int bottom = Math.min(i + 1, board.length - 1);
        for(int x = top; x <= bottom; x++){
            for(int y = left; y <= right; y++){
                // 统计活细胞的数量，如果是活的算上自己的数量。因为之前有标记-1的代表原先是活的然后变成死的
                count = board[x][y] == 1 || board[x][y] == -1 ? count + 1 : count;
                //System.out.print("mark: " + count + " ");
            }
            //System.out.println();
        }
        // 如果 == 1代表是活细胞 ：看是否周围活细胞的数量为 3 和 4（加上他自己） 如果是 标记为 1
        // 如果是死细胞 看周围的活细胞是否为3个（本身为死细胞无须再加1） 如果是的话标记 -2
        return board[i][j] == 1 ? (count == 3 || count == 4 ? 1 : -1) : (count == 3 ? -2 : 0);
    }
}
