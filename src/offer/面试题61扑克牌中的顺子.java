package offer;

import java.util.Arrays;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/11 10:06
 */
public class 面试题61扑克牌中的顺子 {
    public boolean isStraight(int[] nums) {
        // 排序,统计的0的个数，看0的个数是否能补完空隙
        // 要出现对子则不能视为顺子
        if (nums == null || nums.length != 5) return false;
        Arrays.sort(nums);
        // 统计0的个数
        int i = 0;
        int count = 0;;
        while (i < nums.length && nums[i] == 0){
            count++;
            i++;
        }
        int j = i + 1;
        while (j < nums.length){
            if (nums[j] == nums[i]) return false;
            else if (nums[j] - nums[i] > 1){
                // 用零来补充空缺大于1的扑克牌
                count-= nums[j] - nums[i] - 1;
            }
            i++;
            j++;
        }
        // 大小王可以多出来
        return count >= 0;
    }
}
