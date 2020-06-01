package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/22 12:32
 */
public class CombinationSum {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return ans;
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>());
        return ans;
    }

    public void dfs(int[] nums, int target, int index, List<Integer> list) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        // index为上一节点减到nums[i] 当中 i 的下标，这样可以去重
        for (int i = index; i < nums.length; i++){
            if (nums[i] <= target){
                list.add(nums[i]);
                // index 从当前数字开始算
                dfs(nums, target - nums[i], i, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
