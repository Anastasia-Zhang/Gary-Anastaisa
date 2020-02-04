package dynamic;

import java.util.Arrays;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/1 19:59
 */
public class TargetSum {
    int count = 0;
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        findTargetSumWays2(nums,3);
    }
    public static int findTargetSumWays1(int[] nums, int target){
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum < target || (sum - target) % 2 == 1){
            return 0;
        }
        target = (sum - target) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[target];

    }

    public static int findTargetSumWays2(int[] nums, int target){
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum < target || (sum + target) % 2 == 1){
            return 0;
        }
        target = (sum + target) / 2;
        int[][] dp = new int[nums.length +  1][target + 1];
        //int[][] dp = new int[nums.length][target + 1];

        dp[0][0] = 1;
        // 要么多加一行计算使用，要么初始化第一行
        //if (nums[0] <= target) dp[0][nums[0]] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
         for (int i = 0; i < dp.length; i++) {
             for (int j = 0; j < dp[0].length; j++) {
                 System.out.print(dp[i][j] + " ");
             }
             System.out.println();
         }


        return dp[nums.length - 1][target];

    }


    // 暴力递归
    public  int findTargetSumWays3(int[] nums, int target) {
        caculate(nums, 0, 0, target);
        return count;
    }

    // 可能是加也可能是减
    /***
     * 计算组合个的个数
     * @param nums 数组
     * @param i 数组下标，用于控制遍历数组，只能是 i + 1
     * @param sum  现在数组的和
     * @param target 目标和
     */

     public void caculate(int[] nums, int i, int sum, int target){
         if (i == nums.length){
             if (sum == target) count++;
         } else {
             // 枚举每一个数加或者减的情况
             caculate(nums, i + 1, sum + nums[i], target);
             caculate(nums, i + 1, sum - nums[i], target);
         }
     }

}
