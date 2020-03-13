package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/5 19:20
 */
public class 面试题51逆序对的个数 {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return reverseCount(nums, 0, nums.length - 1);
    }

    public int reverseCount(int[] nums, int left, int right){
        if (left >= right) return 0;

        int center = (left + right) / 2;
        int leftCount = reverseCount(nums, left, center);
        int rightCount = reverseCount(nums, center + 1, right);
        int acrossCount = mergeCount(nums, left, center, right);
        return leftCount + rightCount + acrossCount;
    }

    public int mergeCount(int[] nums, int left, int center, int right){
        int[] tempArray = new int[right - left + 1];
        int leftIndex = left;
        int rightIndex = center + 1;
        int tempIndex = 0;
        int reverseNum = 0;
        while (leftIndex <= center && rightIndex <= right) {
            if (nums[leftIndex] <= nums[rightIndex])
                tempArray[tempIndex++] = nums[leftIndex++];
            else {
                // 此时会和指针指到的范围内的左子数组构成一个逆序对
                // 因为左边 leftIndex - center 的所有的数字都会大于 nums[rightIndex]
                // 因此 逆序对的个数就是左边子数组的长度
                reverseNum += center - leftIndex + 1;
                tempArray[tempIndex++] = nums[rightIndex++];
            }
        }

        while (leftIndex <= center){
            tempArray[tempIndex++] = nums[leftIndex++];
        }

        while (rightIndex <= right) {
            tempArray[tempIndex++] = nums[rightIndex++];
        }

        tempIndex = 0;
        for (int i = left; i <= right; i++){
            nums[i] = tempArray[tempIndex++];
        }
        return reverseNum;
    }
}
