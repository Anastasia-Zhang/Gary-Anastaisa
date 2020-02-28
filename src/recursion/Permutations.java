package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/25 20:12
 */
public class Permutations {
    List<List<Integer>> result = new ArrayList<>();
    boolean visited[] = null;
    public List<List<Integer>> permute(int[] nums) {

        visited = new boolean[nums.length];
        List<Integer> ans = new ArrayList<>();
        if (nums.length == 0) return result;


        dfs(nums, 0, ans);

        return result;
    }

    public void dfs(int[] nums, int index, List<Integer> ans){
        if (index == nums.length){
            // 值传递，传递的是地址，因此需要拷贝一份
            // 因为回溯的时候会把变量重置，重置成初试的变量
            // 其实如果每次在调用前都传入一个 new 的对象，保证每次在栈帧中的变量地址唯一（独立），就不会受到回溯的影响，自然也不用恢复现场
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (!visited[i]){
                // List<Integer> newPath = new ArrayList<>(path);
                // boolean[] newUsed = new boolean[len];
                // 传入的时候传入新的变量也就不用回溯
                visited[i] = true;
                ans.add(nums[i]);
                dfs(nums, index + 1, ans);
                visited[i] = false;
                ans.remove(index);
            }

        }
    }
}
