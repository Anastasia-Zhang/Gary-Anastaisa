package dynamic;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/27 23:05
 */
public class RangeSum {

    private int[] sum;

    private int[][] dp;

    // 可以转换为 sum[j + 1] - sum[i]，其中 sum[i] 为 0 ~ i - 1 的和
    // 原构造函数
    public void NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            // sum[0] = 0; 减少预处理
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        // 区间 i - j 的和也包括 i 和 j，需要到 j 的和减去到 i - 1 的和
        return sum[j + 1] - sum[i];
    }

    // 原构造函数
    // 类比上一题的情况，换成矩阵之后用一个和矩阵等行二维数组，二维数组的每一行来存储矩阵每一行的累加值
    public void NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        dp = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                dp[i][j + 1] = dp[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        // 结果先计算区域内每行的和，再将区域内每一行的和累加
        for (int i = row1; i <= row2; i++){
            sum += dp[i][col2 + 1] - dp[i][col1];
        }
        return sum;
    }

    // 优化查找时间为 O(1)
    public void NumMatrix2(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
            }
        }
    }

    public int sumRegion2(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }


}
