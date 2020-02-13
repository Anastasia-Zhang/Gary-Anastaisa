package bits;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/13 11:57
 */
public class ReverseBits {
    public static int reverseBites(int n){
        int result = 0;
        for (int i = 0; i <= 32; i++){
            // int temp = n >> i; // 向右移1位
            // temp &= 1; // 取最低位
            // temp <<= (31 - i); // 将最低位放到翻转后的位置，后面的补0
            // result |= temp; // 保留结果为1的位数
            result |= ((n >> i) & 1) << (31 - i);
        }
        return result;
    }

}
