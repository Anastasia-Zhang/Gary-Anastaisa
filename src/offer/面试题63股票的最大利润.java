package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/9 14:09
 */
public class 面试题63股票的最大利润 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        // 刚开始的最大利润是 0 ,因为饿哦可能不卖出
        int maxProfit = 0;
        // 在计算卖出的固定价格的时候，显然买入的价格越低越好，因此在遍历到第 i 个数字中，能够记住 i - 1 个数字中的最小值 就能计算在当前价位卖出的时候锁获得的最大利润，在遍历的时候同时更新最大利润
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 计算 i - 1 个数的最小价格
            min = Math.min(min, prices[i - 1]);
            if (prices[i] > min) {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }
        }
        return maxProfit;
    }
}
