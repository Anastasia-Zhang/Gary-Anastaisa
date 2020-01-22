package dynamic;

import java.util.Arrays;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/19 19:55
 */
public class HouseRobberII {

    /**
     * 环形房子，可以把其看成两个单排列问题,有两种情况：
     * 1）抢了第一个房子，不抢最后一个
     * 2）不抢第二个房子，可以抢最后一个
     * 二者取最大值
     * */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robHouse(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                        robHouse(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    /**
     * 抢最后一个房子的情况：
     * 抢最后一个房子：f(n - 1) + nums[i]
     * 不抢最后一个房子：f(n - 2)
     */
    public int robHouse(int[] nums){
        int curMax = 0;  // 记录 f(n - 1) 的值
        int preMax = 0;  // 记录 f(n - 2) 的值
        for (int x : nums){
            int temp = curMax;
            curMax = Math.max(preMax + x, curMax);
            preMax = temp;
        }
        return curMax;
    }
}
