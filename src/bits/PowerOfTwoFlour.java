package bits;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/13 12:53
 */
public class PowerOfTwoFlour {
    public boolean isPowerOfTwo1(int n) {
        // 不断循环除以2看最后结果是否为1，超时
        if (n % 2 != 0 && n != 1) return false;
        while (n % 2 == 0){
            n /= 2;
        }

        return n == 1;
    }

    public boolean isPowerOfTwo2(int n){
        // (n & (n - 1)) 是去掉最低的那位1，如果是2的幂次方他的二进制表示中只能有一个1，且这个1在最高位，去掉最高位之后就变成0
        return n > 0 && (n & (n - 1)) == 0;
    }

    // 循环超时
    public boolean isPowerOfFour1(int num) {
        if (num == 0) return false;
        while (num % 4 == 0){
            num /= 4;
        }
        return num == 1;
    }

    // 预运算 我们知道输入的整数是 32 位整数 x <= 2 ^ 31 - 1,最大的四次幂是 log4(2^31 - 1) = 15
    // 提前计算所有的可能性, 存在列表里
    int n = 15;
    List<Integer> fourPowerList = new ArrayList<>();
    public void powerFour(){
        int num = 1;
        for (int i = 0; i < n + 1; i++){
            num *= 4;
            fourPowerList.add(num);
        }
    }
    public boolean isPowerOfFour2(int num) {
        return fourPowerList.contains(num);
    }

    // 是四的幂那么一定是2的偶次幂，log2（num）一定为偶数
    public boolean isPowerOfFour3(int num) {
        return (num > 0) && (Math.log(num) / Math.log(2) % 2 == 0);
    }

    // 是4的幂次一定是2的幂，且是2的偶次幂，1出现的位置都是在奇数的位置上
    // 如 16 = 10000 第5位 因此和32进制数10101...(所有1都出现在偶次位）想与的话肯定为0
    public boolean isPowerOfFour4(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & (0xaaaaaaaa)) == 0);
    }

}
