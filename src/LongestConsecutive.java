import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutive {
    // 找出值连续的子数列
    public static void main(String[] args) {
        int[] arr = new int[]{100, 4, 200, 3, 5,201, 400, 202, 78, 203, 5, 201, 203};
        System.out.println(longestHashSet(arr));
    }

    public static int longestConsecutive(int[] nums) {
        // if 循环从1开始 注意特殊值
        if(nums.length == 0 || nums == null) return 0;
        if(nums.length == 1) return 1;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        //int max = Integer.MIN_VALUE;
        int max = 1;// 如果没有发生更新则直接返回max，注意max的初始值
        int maxLength = 1;
        for (int i = 1;i < nums.length;i++){
            //maxLength = nums[i] - nums[i - 1] == 1 ? ++ maxLength : 1;
            // 两个数相同 （[0,1,1,2] [0,1,2] 结果为3），则不更新直接下一步（去重）
            if (nums[i] - nums[i - 1] == 0) continue;
            maxLength = nums[i] - nums[i - 1] == 1 ? ++ maxLength : 1;
            max = Math.max(max, maxLength);
        }
        return max;
    }

    public static int longestHashSet(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        // 利用HashSet 1.去重 2.只对 当前数字 - 1 不在哈希表里的数字，作为连续序列的第一个数字去找对应的最长序列
        int currentNum = 0;
        int maxLength = 1;
        int max = 0;
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums){
            numSet.add(num);
        }
        for (int num : numSet){
            // 如果当前遍历的第一个数字不在哈希列表中,作为连续数列的列表第一个数字
            if (!numSet.contains(num - 1)){
                currentNum = num;
                maxLength = 1;
                while (numSet.contains(currentNum + 1)){
                    currentNum++;
                    maxLength++;
                }
            }
            max = Math.max(max, maxLength);
        }
        return max;
    }
}
