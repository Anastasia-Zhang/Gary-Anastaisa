package bits;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/13 18:23
 * 求一个数的补码
 */
public class NumberComplement {
    public static void main(String[] args) {
        findComplement(5);
    }
    public static int findComplement(int num) {
        int result = 0;
        int temp = 1;
        while (num > 0){
            // 取最低位，如果最低位是0则置1
            if ((num & 1) == 0)  {
                result |= temp;  // 记录两个数都是1的位置
            }
            temp <<= 1; // 将temp往前移位
            num >>= 1; // num向后移位

        }
        return result;
    }
}
