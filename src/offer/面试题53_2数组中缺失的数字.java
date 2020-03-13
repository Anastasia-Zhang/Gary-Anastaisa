package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/10 19:18
 */
public class 面试题53_2数组中缺失的数字 {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // 二分查找第一个和下标元素不相等的数字，他的下标就是那个缺失的元素
        int i = 0;
        int j = nums.length - 1;
        int mid = 0;
        while (i <= j){
            mid = (i + j) / 2;
            // 如果下标相等去后面查找
            if (nums[mid] == mid) i = mid + 1;
            else {
                // if (mid > 0 && nums[mid - 1] == mid - 1) mid = 0 d 情况
                if ((mid > 0 && nums[mid - 1] == mid - 1) || mid == 0) return mid;
                if (mid > 0 && nums[mid - 1] != mid - 1) j = mid - 1;
            }
        }
        // 缺失最后一个数的情况,在上述循环中由于数组的是数一直和下标相等，则i会一直往后查找，j 一直不动，直到i == nums.length
        if (i == nums.length) return i;
        return mid;
    }
}
