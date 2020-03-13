package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/5 21:41
 */
public class 面试题57_1和为s的数字 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) return new int[0];
        int[] res = new int[2];
        int i = 0;
        int j = nums.length - 1;
        // 因为要求两个数的和，i = j 咋求两个数的和
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target){
                res[0] = nums[i];
                res[1] = nums[j];
                break;
            }
            else if (sum > target) j--;
            else i++;
        }
        return res;
    }
}
