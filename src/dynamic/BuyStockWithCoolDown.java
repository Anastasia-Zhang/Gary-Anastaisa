package dynamic;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/11 21:59
 * 买股票的最佳时期含有冷冻期
 */
public class BuyStockWithCoolDown {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0; // 第0天不持有股票利润 0
        dp[0][1] = -prices[0]; // 第0天持有股票就是负的
        dp[1][0] = Math.max(0, -prices[0] + prices[1]); //按照以前的递推公式初始化
        dp[1][1] = Math.max(-prices[0],-prices[1]);
        for (int i = 2; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]); // 含有冷冻期，必须在冷冻期前一天减去
        }

        return dp[prices.length - 1][0];
    }
}
