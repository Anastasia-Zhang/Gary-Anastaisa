package dynamic;

import java.util.Arrays;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/31 13:30
 */
public class LongestWiggleLength {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int[] up = new int[nums.length];
        Arrays.fill(up, 1);
        int[] down = new int[nums.length];
        Arrays.fill(down, 1);
        for (int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // 如果是上身子序列，则其前一个序列应该是下降的，再加上这个数（+1）
                    // 去down[j] 寻找移该数为下降序列的结尾的最大子序列值
                    up[i] = Math.max(up[i],down[j] + 1);
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i],up[j] + 1);
                }
            }
        }
        return Math.max(down[nums.length - 1], up[nums.length - 1]);
    }
}
