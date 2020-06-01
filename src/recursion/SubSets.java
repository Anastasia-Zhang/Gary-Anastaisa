package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/22 13:43
 */
public class SubSets {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return ans;
        dfs(nums, 0, new ArrayList<>());
        ans.add(new ArrayList<>());
        return ans;
    }

    public void dfs(int[] nums, int index, List<Integer> list){
        for (int i = index; i < nums.length; i++){
            list.add(nums[i]);
            ans.add(new ArrayList<>(list));
            dfs(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
