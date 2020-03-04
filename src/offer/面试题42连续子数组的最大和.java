package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/3 23:31
 */
public class 面试题42连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // 以第i个数组为结尾的最大连续子数组的和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = dp[0];
        for (int i = 1; i < nums.length; i++){
            // 当前 i - 1 个和比 nums[i] 大的时候，把nums[i] 加上，当 i - 1 个和比nums[i] 小的时候 舍弃，从当前数开始算
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
