import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/13 14:23
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 */
public class MajorityElementII {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,3,2,7,7,7,7};
//        int[] nums = new int[]{1,2};
        List<Integer> res = majorityElement2(nums);
        for (int num : res){
            System.out.println(num);
        }

    }

    // 双指针
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        Arrays.sort(nums);
        while (i < nums.length){
            while (j < nums.length && nums[i] == nums[j]) j++;
            if (j - i > nums.length / 3)  res.add(nums[i]);
            i = j;
        }
        return res;
    }

    // 多数投票算法，以为 3/n 的数最多有两个， 因此设置两个候选人个数 和 两个计数器 对两个候选人和计数器分别进行投票操作
    // 1. 如果 投 A（当前元素等于A）则A的票数++
    // 2. 如果 投 B（当前元素等于B）则B的票数++
    // 3. 其他数（既不等于A也不等于B） 的分别判断 ： A B 的票数是否为0 ？ 更新候选人为该数，票数+1：A. B的票数-1

    // 最后再遍历一遍确定其票数是否大于 3/n
    public static List<Integer> majorityElement2(int[] nums){
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        int candidateA = 0;
        int candidateB = 0;
        int countA = 0;
        int countB = 0;

        for (int num : nums){
            if (num == candidateA) {
                countA++;//投A
                continue;
            }
            if (num == candidateB) {
                countB++;//投B
                continue;
            }

            //此时当前值和AB都不等，检查是否有票数减为0的情况，如果为0，则更新候选人
            if (countA == 0) {
                candidateA = num;
                countA++;
                continue;
            }
            if (countB == 0) {
                candidateB = num;
                countB++;
                continue;
            }
            //若此时两个候选人的票数都不为0，且当前元素不投AB，那么A,B对应的票数都要--;
            countA--;
            countB--;
        }

        System.out.println(candidateA);
        System.out.println(candidateB);

        countA = 0;
        countB = 0;
        for (int num : nums) {
            if (num == candidateA) countA++;
            else if (num == candidateB) countB++;
        }
        if (countA > nums.length / 3)
            res.add(candidateA);
        if (countB > nums.length / 3)
            res.add(candidateB);
        return res;
    }
}
