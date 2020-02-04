package dynamic;

import java.util.Arrays;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/1 14:51
 */
public class Partition2Subsets {
//    public static void main(String[] args) {
//        canPartition(new int[]{2,2,3,5});
//    }
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        int capacity = sum / 2;

        boolean[][] dp = new boolean[nums.length][capacity + 1];

        // 初始化
        dp[0][0] = true;
        if (nums[0] <= capacity) dp[0][nums[0]] = true;

        for (int i = 1; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                if (j >= nums[i]){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
            if (dp[i][capacity]) return true;
        }

        return dp[nums.length - 1][capacity];
    }
    public boolean canPartition2(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }


        // 遍历每个物品的“体积”
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; nums[i] <= j; j--) {
                if (dp[target]) {
                    return true;
                }

                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
