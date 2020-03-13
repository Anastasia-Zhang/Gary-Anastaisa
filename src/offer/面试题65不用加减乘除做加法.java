package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/11 13:39
 */
public class 面试题65不用加减乘除做加法 {
    public int add(int a, int b) {
        // // 两数相加：1.相加不进位，2.相加进位 3. 1。2 的两个数相加.... 循环相加直到不产生进位为止
        // // 两数相加相当于不仅为相当于 a ^ b, 进的位相当于 ( a ^ b)<<1
        // // 二进制的两数相加就相当于不进位的两数和进位相加，直到进位为0为止
        return b == 0 ? a : add(a ^ b, (a & b) << 1);
    }
}
