package dynamic;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/26 17:56
 */
public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));

    }

    public static int maxSubArray1(int[] nums) {
        int maxSum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++){
            // 用一个变量来记录到nums[i]的最大子序列值
            // -2 -1 -3 4 3 5 6 1 5
            maxSum = Math.max(maxSum + nums[i], nums[i]);
            // 用变量来记录当前最大值 max = 6
            max = Math.max(max, maxSum);
        }
        return max;
    }

    // 分治法求解
    // 问题分成三种情况： 最大值的子序列在左边、右边、跨中心
    // 问题的合并：求这三种情况的最大值
    public static int maxSubArray(int[] nums){
        return findMaxSubArray(nums, 0, nums.length - 1);
    }

    public static int findMaxSubArray(int[] nums, int left, int right){
        if (left == right) return nums[left];
        int mid = (left + right) / 2;
        int leftSum = findMaxSubArray(nums, left, mid);
        int acrossSum = findAcrossSubArray(nums, left, mid, right);
        int rightSum = findMaxSubArray(nums, mid + 1, right);
        int result = Math.max(leftSum, rightSum);
        return Math.max(acrossSum, result);

    }

    public static int findAcrossSubArray(int[] nums, int left, int mid, int right){
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        // for (int i = 0; i <= mid; i++)
        for (int i = mid; i >= left; i--){
            sum += nums[i];
            leftSum = Math.max(sum, leftSum);
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++){
            sum += nums[i];
            rightSum = Math.max(sum, rightSum);
        }

        return (rightSum + leftSum);
    }

}
