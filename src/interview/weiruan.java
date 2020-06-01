package interview;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/2 10:09
 */
public class weiruan {
    public static void main(String[] args) {
        int[] nums = new int[]{2,4,-3,6};
        int[] nums2 = new int[]{-1,-2,-3,3};
        System.out.println(findMathSum(nums2));
    }

    public static int findMathSum(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int maxSum = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            // dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i - 1] < 0){
                dp[i] = nums[i];
            } else {
                dp[i] = nums[i] + dp[i - 1];
            }
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
