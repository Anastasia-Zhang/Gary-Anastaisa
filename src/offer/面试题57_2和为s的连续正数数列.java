package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/10 22:31
 */
public class 面试题57_2和为s的连续正数数列 {
    public int[][] findContinuousSequence(int target) {
        if (target < 3) return new int[0][0];
        // 连续序列的最大值和最小值
        // 可以理解为连续正数的窗口，在这个窗口内的数字都是连续的
        // 记录这个窗口内的和等于目标和情况时的数组
        int low = 1;
        int high = 2;
        int curSum = 3;
        List<List<Integer>> ans = new ArrayList<>();
        while (low < (1 + target) / 2){
            // 和相等记录数组
            if (curSum == target) addToList(ans, low, high);
            // 如果和大于，窗口缩短右边去掉最小值
            while (curSum > target && low < (1 + target) / 2){
                curSum -= low;
                low++;
                if (curSum == target) addToList(ans, low, high);
            }
            // 如果和小于 则窗口扩增左边增加最大值
            high++;
            curSum += high;
        }

        int[][] res = new int[ans.size()][];
        for (int i = 0; i < ans.size(); i++){
            List<Integer> list = ans.get(i);
            int[] temp = new int[list.size()];
            for (int j = 0; j < temp.length; j++){
                temp[j] = list.get(j);
            }
            res[i] = temp;
        }
        return res;
    }

    public void addToList(List<List<Integer>> list, int low, int high){
        List<Integer> window = new ArrayList<>();
        for (int i = low; i <= high; i++){
            window.add(i);
        }
        list.add(window);
    }
}
