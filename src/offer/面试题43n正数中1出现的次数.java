package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/8 21:44
 */
public class 面试题43n正数中1出现的次数 {
    public int countDigitOne(int n) {
        // record n 代表从 0 到 n 位有多少个1
        int[] record = new int[10];
        for (int i = 0; i < record.length; i++){
            record[i] = (int)(i * Math.pow(10, i - 1));
        }
        int lowBit = 0;// 记录比该数低一位的位数
        int res = 0;
        int countBitOne = 1; // 该数最高位为 1 的个数
        int temp = n;
        while (temp != 0){
            int num = temp % 10; // 取最低位
            temp /= 10;
            res += record[lowBit] * num; // 先计算最低位和他下一位1的组合数
            // 计算最高位的组合数，如果最高位为1 1XX 则结果加上 XX, 0不算
            if (num > 1) {
                res += countBitOne; // 最高位可以有多少个1 比如 261 他的最高位的1的个数就是 100-199 这100个1
            } else if (num == 1){
                // 比如 161 最高位的 1 只能是 100-161这61个数对应的1
                res += n % countBitOne + 1;
            }
            lowBit++;
            countBitOne *= 10;
        }
        return res;
    }
}
