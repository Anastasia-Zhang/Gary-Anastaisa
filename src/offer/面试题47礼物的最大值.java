package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/5 0:02
 */
public class 面试题47礼物的最大值 {
    public static void main(String[] args) {
        maxValue(new int[][]{
                new int[] {1,3,1},
                new int[] {2,5,1},
                new int[] {4,2,1}
        });
    }
    public static int maxValue(int[][] grid) {
        if (grid == null) return 0;
        int m = grid.length;
        int n = grid[0].length;
        // dp[i][j] 表示走到 i,j 结点的时候的最大价值
        // int[][] dp = new int[m][n];
        // dp[0][0] = grid[0][0];
        // for (int i = 1; i < n; i++){
        //     dp[0][i] = dp[0][i - 1] + grid[0][i];
        // }
        // for (int i = 1; i < m; i++){
        //     dp[i][0] = dp[i - 1][0] + grid[i][0];
        // }
        // 优化 使用一位数组
        int[] dp = new int[n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                //dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                int left = 0; // dp[i][0] .... dp[i][j - 1] 的最大值
                int up = 0; // dp[i - 1][j] ... dp[i - 1][m - 1] 的最大值
                // 每一次更新的时候，当前的 dp[j] 就是上一次 dp[i - 1][j - 1] 的值
                if (i > 0) up = dp[j];
                if (j > 0) left = dp[j - 1]; // dp[i][i - 1]
                dp[j] = Math.max(left, up) + grid[i][j];
                System.out.print(dp[j] + " ");
            }
            System.out.println();
        }
        return dp[n - 1];
    }
}
