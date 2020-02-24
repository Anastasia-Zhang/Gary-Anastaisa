package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/24 16:25
 */
public class 面试题14_1剪绳子1 {
    public int cuttingRope(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++){
            for (int j = 1; j <= i - 1; j++){
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
