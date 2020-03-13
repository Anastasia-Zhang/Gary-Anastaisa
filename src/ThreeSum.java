import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/11 17:42
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    // 去重用 while 因为可能不止一个数有重复
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    // 再去寻找另一个可能的解
                    L++;
                    R--;
                }
                // 去重用 while 因为可能不止一个数有重复
                // if (nums == 0 && nums[L] == nums[L + 1]) L++;
                // if (nums == 0 && nums[R] == nums[R - 1]) R--;
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }
}
