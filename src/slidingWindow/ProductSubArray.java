package slidingWindow;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/22 23:05
 * 乘积小于k的子数组
 * 滑动窗口维持一个乘积小于k的子数组
 */
public class ProductSubArray {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int i = 0; // 数组的起始位置
        int product = 1; // 乘积
        int result = 0; // 排列组合数
        for (int j = i; j < nums.length; j++){
            product *= nums[j];
            while (product >= k) product /= nums[i++];  // 如果当前乘积大于k则从窗口右边开始去掉数字
            result += j - i + 1; //每次窗口右边新加入一个数字，就把以右边为首的子数列加进来
        }
        return result;
    }
}
