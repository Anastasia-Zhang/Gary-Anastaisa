import javax.management.MBeanAttributeInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/11 14:14
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 * 示例 1:
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 */
public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,6,8,9,12,13};
        List<String> ans = summaryRanges(nums);
        for (String res : ans){
            System.out.println(res);
        }
    }



    public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        List<Integer> window = new ArrayList<>();
        window.add(nums[0]);
        for (int i = 1; i < nums.length;i ++){
            if (window.get(window.size() - 1) + 1 == nums[i]){
                window.add(nums[i]);
                System.out.println(window.toString());
            }else{
                if (window.size() == 1) ans.add(String.valueOf(window.get(0)));
                else {
                    ans.add(window.get(0) + "->" + window.get(window.size() - 1));
                }
                window.clear();
                window.add(nums[i]);
            }
        }


        if (window.size() == 1) ans.add(String.valueOf(window.get(0)));
        else {
            ans.add(window.get(0) + "->" + window.get(window.size() - 1));
        }

        return ans;
    }
}
