package dynamic;

import java.util.Arrays;

public class MaxProductSubArray {
    // 乘积最大连续子序列
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 4,-6,5,-7};
        System.out.println(maxProduct(nums));

    }
    public static int maxProduct1D(int[] nums) {
        // maxProduct[i] 表示到第i个数为止，乘积最大的连续子数列
        // 错误 无法统计以该数开始的乘积最大连续子数列
        int[] maxProduct = new int[nums.length];
        maxProduct[0] = nums[0];
        for (int i = 1;i < nums.length; i ++){
            if (nums[i] <= nums[i] * maxProduct[i - 1]){
                maxProduct[i] = nums[i] * maxProduct[i - 1];
            }else {
                maxProduct[i] = nums[i];
                //maxProduct[i] = maxProduct[i - 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int num : maxProduct){
            max = Math.max(max, num);
        }
        return max;
    }

    public static int maxProduct2D(int[] nums) {
        // 暴力法
        // a[i][j] 为第i个数开始，第j个数结束的最大子序列的乘积
        // 当数组特别大时超出内存限制
        int [][] a = new int[nums.length][nums.length];
        for (int i = 0;i < nums.length;i ++){
            a[i][i] = nums[i];
        }
        for (int i = 0;i < nums.length;i ++){
            for (int j = i + 1;j < nums.length; j++){
                a[i][j] = nums[j] * a[i][j - 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0;i < nums.length;i ++){
            for (int j = i;j < nums.length; j ++){
                max = Math.max(a[i][j],max);
            }
        }
        return max;
    }

    /**
     * 标签：动态规划
     * 遍历数组时计算当前最大值，不断更新
     * 令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
     * 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
     * 当负数出现时则imax与imin进行交换再进行下一步计算
     * 时间复杂度：O(n)O(n)
     */
    public static int maxProduct(int[] nums){
        // 用一个变量来记录当前的最大值
        // 需要注意的一点是，当下一个数为负数时，最小乘积乘上该数就变为最大值
        // 因此也需要有个变量来记录到目前为止的最小值，当遍历到的数为负数时，把最小值当做最大值
        int max = Integer.MIN_VALUE;
        int maxProduct = 1;
        int minProduct = 1;
        for (int num : nums) {
            if (num < 0) {
                // 如果当前数为负数，则最大乘积和最小乘积交换
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            maxProduct = Math.max(num * maxProduct, num);
            minProduct = Math.min(num * minProduct, num);//只需记录遍历到当前数为止，最小的乘积，仅供当前数为负数时交换使用
            max = Math.max(max, maxProduct);
        }
        return max;
    }
}
