package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/10 18:40
 */
public class 面试题53_1在排序数组中查找数字 {
    public int search(int[] nums, int target) {
        if (nums == null | nums.length == 0) return 0;
        // int count = 0;
        // for (int i = 0; i < nums.length; i++){
        //     if (nums[i] == target) count++;
        // }
        // return count;
        int i = 0;
        int j = nums.length - 1;
        int mid = 0;
        // 注意和前一个数比较时注意 mid 边界情况 mid == 0
        while (i <= j){
            mid = (i + j) / 2;
            if (nums[mid] < target) i = mid +1;
            else if (nums[mid] > target) j = mid - 1;
                // 如果相等，要查找是不是第一个等于 target 的数，如果是则break，如果不是则继续往前查找
            else if (nums[mid] == target ){
                if(mid > 0 && nums[mid - 1] == target) {
                    j = mid - 1;
                } else{
                    // break 中包含了 mid == 0 的情况
                    // if (mid > 0 && nums[mid - 1] != target) || mid == 0)
                    break;
                }
            }
        }
        if (i > j) return 0;
        int firstIndex = mid;
        // int count = 1;
        // while (mid < nums.length - 1 && nums[mid] == nums[++mid]) {
        //     count++;
        // }
        // return count;
        // 查找最后一个等于 target 的数
        i = 0;
        j = nums.length - 1;
        mid = 0;
        // 注意和前后个数比较时注意 mid 边界情况 mid == mums.length - 1
        while (i <= j){
            mid = (i + j) / 2;
            if (nums[mid] < target) i = mid +1;
            else if (nums[mid] > target) j = mid - 1;
                // 如果相等，要查找是不是最后一个等于 target 的数，如果是则break，如果不是则继续往后查找
            else if (nums[mid] == target ){
                if(mid < nums.length - 1 && nums[mid + 1] == target) {
                    i = mid + 1;
                } else{
                    break;
                }
            }
        }
        int lastIndex = mid;
        return lastIndex - firstIndex + 1;
    }
}
