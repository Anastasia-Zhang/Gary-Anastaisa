package bits;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/13 19:46
 */
public class TwoSum {
    public int getSum(int a, int b) {
        // 两数相加相当于不仅为相当于 a ^ b, 进的位相当于 ( a ^ b)<<1
        // 二进制的两数相加就相当于不进位的两数和进位相加，直到进位为0为止
        return b == 0 ? a : getSum((a ^ b), (a & b) << 1);
    }
}
