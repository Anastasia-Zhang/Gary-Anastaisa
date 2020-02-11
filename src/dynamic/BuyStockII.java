package dynamic;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/11 22:18
 */
public class BuyStockII {
    // 寻找连续的峰和谷。贪心的策略，只加价格为正的
    public int maxProfitI(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    // 动态规划
    public class Solution {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len < 2) {
                return 0;
            }

            // 0：持有现金
            // 1：持有股票
            // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
            int[][] dp = new int[len][2];

            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            for (int i = 1; i < len; i++) {
                // 这两行调换顺序也是可以的
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[len - 1][0];
        }
    }

    public int maxProfitWrong(int[] prices) {
        // 这种暴力解法是尽可能的去进行多次交易 ，但是多次交易并不一定适用于 [1,2,3,4,5]
        int ans = 0;
        int i = 0;
        int j = 0;
        boolean isSale = false;
        while (i < prices.length - 1){
            j = i + 1;
            isSale = false;
            while (j < prices.length){
                if (prices[j] > prices[i]){
                    ans += prices[j] - prices[i];
                    isSale = true;
                    break;
                }
                j++;
            }
            i = isSale ? j + 1 : i + 1; // 如果购买了，从购买后的一天开始遍历
        }
        return ans;
    }

    // 递归

    int maxProfit;

    public int maxProfit(int[] prices){
        if (prices.length < 2) return 0;
        maxProfit = 0;
        maxProfit(prices, 0, prices.length, 0, 0);
        return maxProfit;
    }

    /**
     * @param prices 股价数组
     * @param index  当前是第几天，从 0 开始
     * @param status 0 表示不持有股票，1表示持有股票(买入或者卖出），
     * @param profit 当前收益
     */

    private void maxProfit(int[] prices, int index, int len, int status, int profit){
        if (index == len){
            maxProfit = Math.max(profit, maxProfit);
            return;
        }

        maxProfit(prices, index + 1, len, status, profit);

        if (status == 0)
            maxProfit(prices, index + 1, len, 0, profit - prices[index]);
        else
            maxProfit(prices, index + 1, len, 1, profit + prices[index]);
    }
}
