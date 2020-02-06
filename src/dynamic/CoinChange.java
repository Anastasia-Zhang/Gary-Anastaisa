package dynamic;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/6 19:57
 * https://leetcode-cn.com/problems/coin-change/solution/ling-qian-dui-huan-by-leetcode/
 */
public class CoinChange {
    // 方法1 带备忘录的动态规划 设金额 amount 面值 coin f(amount) = f(amount - coin) + 1
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int restAmount, int[] count){
        int min = Integer.MAX_VALUE;
        if (restAmount < 0) return -1; // 最后剩余的硬币少于0，表示没有解
        if (restAmount == 0) return 0; // 如果最后的结果减到0，正好表示一个解，回溯 F(0) = 0
        if (count[restAmount - 1] != 0) return count[restAmount - 1]; // 备忘录 记录遍历过的值
        // 遍历硬币的面值
        for (int coin : coins){
            int res = coinChange(coins, restAmount - coin, count);
            if (res >= 0) min = Math.min(res + 1, min); // 更新答案
        }
        count[restAmount - 1] = min == Integer.MAX_VALUE ? -1 : min; // 记录遍历的答案
        return count[restAmount - 1];

    }

    // 动态规划完全背包
    public int coinChangeDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int coin : coins){
            for (int i = coin; i <= amount; i++){
                // 如果当前余额正好为硬币的面额，则正好为1
                if (i == coin) {
                    dp[i] = 1;
                }
                // 如果当前金额没有更新过，则直接就是递推式
                else if (dp[i] == 0 && dp[i - coin] != 0){
                    dp[i] = dp[i - coin] + 1;
                }
                // 选取最优解
                else if (dp[i - coin] != 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

}
