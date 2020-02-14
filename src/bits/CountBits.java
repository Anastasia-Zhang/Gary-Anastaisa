package bits;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/14 19:56
 */
public class CountBits {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            // ans[i] = popcount(i);
            // 动态规划 i & (i - 1) 相当于把最后一位1变为0，则这个数ans[i] 和 ans[i & (i - 1)] 就此相差了最后一位的1
            ans[i] = ans[i & (i - 1)] + 1;
        return ans;
    }

    // 在二进制表示中，数字 n 中最低位的 1 总是对应 n - 1 中的 0 。
    // 因此，将 n 和 n - 1 与运算总是能把 n 中最低位的 1 变成 0 ，并保持其他位不变。
    private int popcount(int x) {
        int count;
        for (count = 0; x != 0; ++count)
            x &= x - 1; //zeroing out the least significant nonzero bit
        return count;
    }

}
