package dynamic;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/19 15:00
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 */
public class ClimbStairs {
    /**
     * 不难发现，这个问题可以被分解为一些包含最优子结构的子问题，即它的最优解可以从其子问题的最优解来有效地构建，我们可以使用动态规划来解决这一问题。
     * 第 ii 阶可以由以下两种方法得到：
     * (1):在第 (i-1)阶后向上爬一阶。
     * (2):在第 (i-2)阶后向上爬 2 阶。
     * 所以到达第 i 阶的方法总数就是到第 (i-1) 阶和第 (i-2)阶的方法数之和。
     * 令 dp[i]dp[i] 表示能到达第 ii阶的方法总数
     * dp[i]=dp[i-1]+dp[i-2]
     * */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
