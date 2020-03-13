package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/11 9:24
 */
public class 面试题60n个骰子的点数 {
    public double[] twoSum(int n) {
        // 动态规划：dp[i][j] 代表第i个骰子和为j的组合数
        // 第 i 个骰子和 j 的范围是 i - 6*i （都是1都是6的情况）
        int[][] dp = new int[n + 1][6 * n + 1];
        // 第 1个骰子的和范围 1-6
        for (int i = 1; i <= 6; i++) dp[1][i] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = i; j <= 6 * i; j++){
                for (int d = 1; d <= 6; d++){
                    if (j - d <= 0) break;
                    dp[i][j] += dp[i - 1][j - d];
                    //System.out.println("--");
                }
            }
        }
        // System.out.println(Arrays.toString(dp[n - 1]));
        // System.out.println(Arrays.toString(dp[n]));
        double total = Math.pow(6, n);
        // 从零开存储答案 下标偏移 s - n
        double[] ans = new double[6 * n - n + 1];
        for (int i = n; i <= 6 * n; i++){
            ans[i - n] = (double)dp[n][i] / total;
        }
        return ans;
    }

    // 空间优化版，注意两个细节 前面的某些状态是否对这个状态有影响
    public double[] twoSum2(int n) {
        // 动态规划：dp[i][j] 代表第i个骰子和为j的组合数
        // 第 i 个骰子和 j 的范围是 i - 6*i （都是1都是6的情况）
        int[] dp = new int[6 * n + 1];
        // 第 1个骰子的和范围 1-6
        for (int i = 1; i <= 6; i++) dp[i] = 1;
        for (int i = 2; i <= n; i++){
            // for (int j = i; j <= 6 * i; j++){
            // 从后往前运算，因为不会覆盖住之前的数值
            for (int j = 6 * i; j >= i; j--){
                // [0, 1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1]
                // 此处的值一定要更新为0.因为不像二维数组一样新开了一个行
                // 而是利用上一次运算的结果继续运算，之前行有结果，dp[j] 要参与本行的状态运算，因此dp[j]初试化
                dp[j] = 0;
                for (int d = 1; d <= 6; d++){
                    // 当前行一定不能把上一个筛子小于最小值的值也算进去
                    // 如 ：dp[3] = dp[3-1]+dp[3-2] dp[3-1] 是没有意义的，他代表的是第二个骰子最小和就是2，因此要保证当前的和大于上一个骰子可能取得的最小值
                    if (j - d < i - 1) break;
                    dp[j] += dp[j - d];
                    //System.out.println("--");
                }
            }
        }
        // System.out.println(Arrays.toString(dp[n - 1]));
        // System.out.println(Arrays.toString(dp));
        double total = Math.pow(6, n);
        // 从零开存储答案 下标偏移 s - n
        double[] ans = new double[6 * n - n + 1];
        for (int i = n; i <= 6 * n; i++){
            ans[i - n] = (double)dp[i] / total;
        }
        return ans;
    }

    // n = 3 :[0, 1, 1, 1, 3, 6, 10, 15, 21, 25, 27, 27, 25, 21, 15, 10, 6, 3, 1]
}
