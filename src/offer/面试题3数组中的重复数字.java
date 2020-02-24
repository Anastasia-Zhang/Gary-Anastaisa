package offer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/22 10:14
 */
public class 面试题3数组中的重复数字 {


    // 排序 + 遍历
    public int findRepeatNumber1(int[] nums) {
         Arrays.sort(nums);
         for (int i = 1; i < nums.length; i++){
             if (nums[i] == nums[i - 1]) return nums[i];
         }
         return -1;
    }
    // 哈希表
    public int findRepeatNumber2(int[] nums){
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int num : nums){
            if (hash.containsKey(num)){
                return num;
            }else{
                hash.put(num, 1);
            }
        }
        return -1;
    }

    // 桶，避免排序，原地交换，可设置额外数组
    public int findRepeatNumber3(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        for (int num : nums) {
            if (num < 0 || num > nums.length - 1) return -1;
        }
        int i = 0;
        // 定义一个辅助数组 ,这样不改变原数组
        // int[] helper = new int[nums.length];
        while (i < nums.length){
            // 一个萝卜一个坑，遍历到的时候就顺便把他放到该放的位置
            while (nums[i] != i){
                //if (nums[i] == helper[nums[i]]) return nums[i];
                if (nums[i] == nums[nums[i]]) return nums[i];
                // 辅助数组赋值 helper[nums[i]] = nums[i];
                // 交换
                nums[i] ^= nums[nums[i]];
                nums[nums[i]] ^= nums[i];
                nums[i] ^= nums[nums[i]];
            }
            i++;
        }
        return -1;
    }

    // 二分查找思路，判断数组在某个区间内的数字个数是否超过这个区间
    // 如果超过这个区间，再去这个区间内进行查找，直到找到这个重复的数字（没有办法找到所有的重复数字）
    // 在数字连续的前提下

    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        // start 和 end 代表数字大小的范围，0 - n - 1
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            int count = countRange(nums, start, mid);
            // 看看最后有没有找到这个数字
            if (start == end) {
                if (count > 1) return start;
                else break;
            }
            if (count > (mid - start)) end = mid;
            else start = mid + 1;
        }
        return start;
    }


    public int countRange(int[] nums, int start, int end){
        if (nums == null) return 0;
        int count = 0;
        for (int num : nums){
            if (num >= start && num <= end) count++;
        }

        return count;
    }


}
