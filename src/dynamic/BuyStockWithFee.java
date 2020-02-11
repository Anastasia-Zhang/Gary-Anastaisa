package dynamic;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/11 21:53
 * 买股票的最佳时期还有交易费用
 */
public class BuyStockWithFee {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        maxProfit(prices,2);
    }

    public static int maxProfit(int[] prices, int fee) {
        if (prices.length < 2) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0; // 第0天不持有股票利润 0
        dp[0][1] = -prices[0]; // 第0天持有股票就是负的
        for (int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee); // 为什么第要在买入的时候减去手续费？？？
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[prices.length - 1][0];
    }

}
