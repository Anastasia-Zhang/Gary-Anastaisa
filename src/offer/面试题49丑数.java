package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/10 17:05
 */
public class 面试题49丑数 {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        int number = 0;
        int uglyCount = 0;
        while (uglyCount < n){
            ++number;
            if (isUgly(number)) uglyCount++;
        }
        return number;
    }

    public int nthUglyNumberDP(int n) {
        // 记录丑数的指针，记录丑数取到的位置
        int p2 = 0, p3 = 0, p5 = 0;
        // dp[i] 代表第 i 个丑数
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++){
            // 每个丑数都由之前的丑数计算而来
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            // 更新指针，只有更新这个指针，指针所指的数的才能保证乘的结果都大于dp[i]
            if (dp[i] == dp[p2] * 2) p2++;
            if (dp[i] == dp[p3] * 3) p3++;
            if (dp[i] == dp[p5] * 5) p5++;
        }
        return dp[n - 1];

    }

    public boolean isUgly(int number){
        while (number % 2 == 0)
            number /= 2;
        while (number % 3 == 0)
            number /= 3;
        while (number % 5 == 0)
            number /= 5;
        return number == 1;
    }
}
