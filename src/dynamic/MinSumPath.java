package dynamic;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/26 22:55
 */
public class MinSumPath {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        if (m == 1 && n == 1) return grid[0][0];

        // 初始化
        for (int i = 1; i < m; i ++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++){
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];

    }
}
