public class RotatedArray {
    public static void main(String[] args) {

    }

    // 另一种二分查找的方法
    public int findMinNotRepeat(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else if (nums[mid] < nums[right]) right = mid;
            // else right = right - 1;
        }
        return nums[left];
    }

    public int findMinRepeat(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else if (nums[mid] < nums[right]) right = mid;
            // 结合数学中的放缩法，缩小数组区间，既不会越界也不会丢失最小值
            // 若 nums[right]nums[right] 是唯一最小值：那就不可能满足判断条件 nums[mid] == nums[right]，因为 mid < right（left != right 且 mid = (left + right) // 2 向下取整）；
            // 若 nums[right]nums[right] 不是唯一最小值，由于 mid < right 而 nums[mid] == nums[right]，即还有最小值存在于 [left, right - 1][left,right−1] 区间，因此不会丢失最小值。

            else right = right - 1;

        }
        return nums[left];
    }
}
