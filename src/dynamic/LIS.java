package dynamic;

import java.util.Arrays;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/31 13:28
 */
public class LIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    // 如果有比他小的数，则也算在最长递增子序列里面
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int num : dp){
            max = Math.max(max, num);
        }
        return max;
    }

    // 贪心算法 + 二分查找

    public int LIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        // tail 数组的定义，长度为 i + 1 的上升子序列的末尾最小是几
        int[] tail = new int[len];
        tail[0] = nums[0];
        // tail 最后的一个已经赋值的元素的索引
        int end = 0;
        for (int i = 1; i < nums.length; i++){
            // 如果遍历到的数比tails的结尾的数还要大
            if (nums[i] > tail[end]){
                // 直接加在 tails 数组的后面
                tail[++end] = nums[i];
            } else {
                // 二分查找，在有序数组 tail 中找到第一个大于等于 nums[i] 的元素
                int left = 0;
                int right = end;
                while (left < right){
                    int mid = left + ((right - left) >>> 1);
                    // 记住这个等于号 当nums[i]和tail的某个数相等时还应该往前找
                    if (nums[i] <= tail[mid]){
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                // 找到的那个位置是left，直接赋值
                tail[left] = nums[i];
            }
        }
        // end 是最后一个元素的索引 此题要求返回的是长度，+1后返回
        return ++end;
    }
}
