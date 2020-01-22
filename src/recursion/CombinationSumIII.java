package recursion;

import java.util.*;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/11 12:21
 */
public class CombinationSumIII {
    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n,1);
        return ans;
    }

    /**
     * 深度优先遍历，遍历所有可能的路径，返回符合条件的结果，为提高效率，减去不符合条件的遍历路径
     * @param k k个数
     * @param n k个数要求的和n
     * @param start 代表 1-9 数，控制循环的开始
     * */
    public void dfs(int k, int n, int start){

        if (k < 0 || n < 0) return; // 剪枝

        if (k == 0 && n == 0){ // 如果正好是k个数组成和为n的数
            if (!path.isEmpty()){
                ans.add(new ArrayList<>(path)); // 将遍历过的路径加入到结果集当中
            }
            return;
        }

        // 循环调用递归，每一层的递归开始都是从上一次递归开始之后的后一个数
        // 如第一次 -1 那么第二次就从 2开始减，因为不能有重复的数
        for (int i = start; i < 10; i++){
            path.push(i); // 加入路径
            dfs(k - 1, n - i, ++start);  // 控制开始，k 不断减 n 不断减
            path.pop();  // 恢复状态
        }


    }
}
