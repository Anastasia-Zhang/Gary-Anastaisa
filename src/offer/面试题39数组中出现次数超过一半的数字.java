package offer;

import java.util.Arrays;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/4 22:39
 */
public class 面试题39数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        majorityElement(new int[]{2,3,2,2,2,5,4,2});
    }
    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // 和最小的 k 个数思路一样，基于 partition 是划分
        int low = 0;
        int high = nums.length - 1;
        int center = nums.length / 2;
        while (low < high) {
            int index = partition(nums, low, high);
            if (index < center) low = index + 1;
            if (index >= center) high = index - 1;
        }
        return nums[center];
    }



    private static int partition(int[] nums, int low, int high){
        int pivot = nums[low];
        while (low < high){
            // 注意：一个坑，快排必须有一个是等号有一种情况 [2,3,2,2,2,5,4,2] 两端相等
            // nums[low] == nums[left] == pivot 在这个循环中，指针不会动，就一直卡死在这里了
            while(low < high && nums[high] > pivot) high--;
            nums[low] = nums[high];
            while(low < high && nums[low] <= pivot) low++;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

    public int majorityElement2(int[] nums) {
        if (nums == null && nums.length == 0) return 0;
        // 投票，因为他出现的次数一定比其他数字出现的次数都要多，因此采用投票法
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++){
            // 数字一样 count++，不一样count--,减到0选取新的数字当做候选者
            // 为什么不一样的时候 不选取新的数字？  -》 首先弄清楚投票的意义，投票是为了计算连续的一样的数字
            // 如果两个数不一样直接选取新的数字，那么以前的投票数没有什么意义了
            // [3,3,4] if candidate != nums[i] candidate = nums[i];
            if (candidate == nums[i]) count++;
                // else {
                //     candidate = nums[i];
                //     count = 1;
                // }

            else if (count == 0){
                candidate = nums[i];
                count = 1;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
