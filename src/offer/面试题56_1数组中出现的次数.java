package offer;

import java.util.Arrays;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/10 20:42
 */
public class 面试题56_1数组中出现的次数 {
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length < 2) return new int[0];
        // 双指针
        Arrays.sort(nums);
        int[] res = new int[2];
        int i = 0;
        int j = 1;
        int index = 0;
        while (i < nums.length && j < nums.length) {
            if (nums[i] != nums[j]) {
                res[index++] = nums[i];
                i++;
                j++;
            } else {
                // i = j++ 是错误的
                i = j + 1;
                j = i + 1;
            }
            // System.out.println(i + "," + j);
            if (i == nums.length - 1 && nums[i] != nums[i - 1]){
                // 如果出现一次的数字在最后
                res[index++] = nums[i];
                break;
            }
        }
        return res;
    }

    public int[] singleNumbers2(int[] nums) {
        if (nums == null || nums.length < 2) return new int[0];
        int[] res = new int[2];
        int twoNum = 0;
        for (int num : nums) {
            twoNum ^= num;
        }
        // twoNum 为两个数的异或值
        // 取最低位的1，一定是来自其中的某一个数
        int diff = twoNum & (-twoNum);
        // 去数组中再去寻找那个唯一的，该位为1的数字
        for (int num : nums) {
            // 如果改位有为1,diff 只有一位为1其余位全为0，和diff与的数结果不为0，则这个数该位一定为1
            if ((num & diff) != 0) res[0] ^= num; // 遍历到的 num 再异或是为了去重
        }

        res[1] = res[0] ^ twoNum;
        return res;
    }


}
