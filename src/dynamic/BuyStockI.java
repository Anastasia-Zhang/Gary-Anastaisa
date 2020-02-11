package dynamic;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/11 22:12
 */
public class BuyStockI {
    public int maxProfit(int[] prices) {
        // 只需找到最小谷底之后的最大谷峰（最大利润）
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices){
            minPrice = Math.min(minPrice, price); // 维持当前最小的价格
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    // 暴力法
    public int maxProfit1(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length - 1; i++){
            for (int j = i + 1; j < prices.length; j++){
                if (prices[j] > prices[i]){
                    ans = Math.max(ans, prices[j] - prices[i]);
                }
            }
        }
        return ans;
    }
}
