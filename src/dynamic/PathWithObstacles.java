package dynamic;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/26 21:13
 */
public class PathWithObstacles {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 0}
        };
        uniquePathsWithObstacles(nums);
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0; // 如果在起点或者终点有路障则路径为1
        if (m == 1 || n == 1) return 1; // 只有一个点时返回1
        int[][] dp = new int[m][n];

        // 初始化 在第0列或第0行若存在一个路障的情况的话，则该路障以后的路都不能走
        for (int i = 1; i < m; i++) {
            if(obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }

        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) break;
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (obstacleGrid[i][j] == 1) continue; // 有路障不考虑
                else if (obstacleGrid[i - 1][j] == 1) dp[i][j] = dp[i][j - 1]; // 若路障在该路径的左边，则到达该路径的路只有其上面这一条路径
                else if (obstacleGrid[i][j - 1] == 1) dp[i][j] = dp[i - 1][j];  // 若路障在该路径的上边，则到达该路径的路只有其左面这一条路径
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[m - 1][n -1];
    }
}
