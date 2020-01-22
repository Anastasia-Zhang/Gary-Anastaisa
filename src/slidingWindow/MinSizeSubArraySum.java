package slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/9 18:44
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * 示例: 
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组
 */
public class MinSizeSubArraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        // System.out.println(minSubArrayLen(7,nums));
    }

    /**
     * 滑动窗口：（可借助队列实现）
     * 先把元素从头开始往后开始加入数组求和
     * 当窗口的内的数组大于给定值之后，从头开始减去数，找满足条件的最小窗口值
     * 直到不满足之后再新入新加元素
     * */
    public static int minSubArrayLen1(int s, int[] nums) {
        int i = 0; // 窗口的初始值
        int sum = 0;
        int len = 0;
        for (int j = 0; j < nums.length; j ++){
            sum += nums[j];
            while (sum >= s){
                len = len == 0 ? j - i + 1 : Math.min(j - i + 1, len);
                sum -= nums[i++]; // 从头开始去掉数组
            }
        }
        return len;
    }
}

