package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/8 22:30
 */
public class 面试题44数字序列中某一位的数字 {
    public static void main(String[] args) {
        // System.out.println(findNthDigit2(13));
    }
    // 找规律：
    /**
     * 序列的第1001位是什么
     * 1）先从 0-9这10个数字找，这些数字只有1位数字，显然 1001 在这10个数字之后，我们从后面的序列中紧接着找第991（1001-10）位数字
     * 2）接着是 10-99 两位数，一共有90个两位数，每个数字占两位，一公180位 991>80,条过这90个数字，去后面的数字找881位（991-180）
     * 3）接着是 100-999 这900个数，一个三位，一共占2700位，811<2700 则 811一定是100以后的某一位数字
     * 811/3 = 270 起始值是100 所以对应的数字是 100 + 270 = 370 索引对应的数字的偏移位置  从0开始
     * 前270位往后多1位 前270位就是 0-269
     *
     */
    public static int findNthDigit(int n) {
        // n < 10 直接返回n
        if (n < 10) return n;
        int digits = 1;
        while (true) {
            // 从第一位开始算，看一下这个位数开始有几个 digits 位的数字
            int numbers = countOfIntegers(digits);
            // 这几个数占了多少位，如果超过这n 则代表n是从这几位数中取
            if (n < (numbers * digits)) {
                // return digitsAtIndex(n, digits);
                break;
            }
            // 再从后面紧跟着的序列开始找，位数增加
            n -= (digits * numbers);
            digits++;
        }
        // 计算这个索引对应的数字
        // ath.pow(10,power-1) -- 起始数字 n/power -- 剩余补充数字
        int resNum = (int)(Math.pow(10, digits - 1) + n / digits);
        System.out.println(resNum);
        // 计算返回的索引对应的数字
        return String.valueOf(resNum).charAt(n % digits) - '0';
    }


    // 计算该位数有多少个数字
    private static int countOfIntegers(int n){
        if (n == 1) return 10;
        return (int) (Math.pow(10, n - 1) * 9);
    }
}
