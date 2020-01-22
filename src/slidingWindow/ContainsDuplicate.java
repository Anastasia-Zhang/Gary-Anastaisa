package slidingWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/11 13:06
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums,1));
    }

    /**
     * 维护一个大小为k的滑动窗口
     * 数据结构为set作为窗口 查找和删除都在线性时间内、去重
     * 搜索当前窗口，如果存在相同元素，则return true
     * 否则，插入当前元素，如果大小超过规定的k，则移除最旧的元素
     * */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
