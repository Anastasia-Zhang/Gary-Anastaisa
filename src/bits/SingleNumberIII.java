package bits;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/13 11:13
 * 一个数组有两个数只出现一次其他数字出现两次，找出只出现一次的数字
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        // 遍历数组将数组的数字异或，去掉重复数字，则最终的值就是只出现过一次的两个数字相异或的值
        for (int i = 0;i < nums.length; i++){
            res ^= nums[i];
        }

        int diff = res & (-res); // 取两个异或的数的最低位的1（最右边的那个1），最右边的1一定是来自两个数的其中的一个数
        int[] twoSingles = new int[2];
        // 遍历数组，寻找最低位为1的那个数，
        for (int num : nums) {
            // 如果最低位为 1，则异或，因为相同的数异或一定就为0了，剩下的就是来自1的那个数
            if ((num & diff) != 0) twoSingles[0] ^= num;
        }
        // c = a ^ b
        // b = a ^ c
        // 再异或回去
        twoSingles[1] = twoSingles[0] ^ res;
        return twoSingles;
    }
}
