package offer;

import java.math.BigInteger;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/24 18:08
 */
public class 面试题14_2剪绳子II {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        // 二分取余
        for (int a = n / 3 - 1; a > 0; a /= 2){
            if (a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if (b == 0) return (int)(rem * 3 % p);
        if (b == 1) return (int)(rem * 4 % p);
        return (int)(rem * 6 % p);
    }

    // 对应的原来的方法，找规律，发现 尽量的多剪长度为3的绳子
    class Solution {
        public int cuttingRope(int n) {
            if(n <= 3) return n - 1;
            // a 为能够剪少个长度为3的绳子，b为剪了正数倍的长度为3的绳子还剩多长
            int a = n / 3, b = n % 3;
            // b < 3 b 的取值有以下几种情况：
            // 整好3的整数倍 返回长度
            if(b == 0) return (int)Math.pow(3, a);
            // 剩余的绳子为1，因此从前面的三的正数倍里面取一个，剩余长度为4
            // 4 剪裁 1 * 3 < 2 * 2 = 4 转化为4
            if(b == 1) return (int)Math.pow(3, a - 1) * 4;
            // 还剩 2
            return (int)Math.pow(3, a) * 2;
        }
    }

    public int cuttingRope2(int n) {
        if (n <= 3) return n - 1;
        // dp[i] 表示长度为 i 的绳子剪完后各段的最大值
        // 可以看成 长度为 i 和 长度为 i - k 的最大值
        // 使用大整型计算
        BigInteger[] dp = new BigInteger[n + 1];
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("2");
        dp[3] = new BigInteger("3");
        for (int i = 4; i <= n; i++){
            // 初始化 dp[i]
            dp[i] = new BigInteger("0");
            // 1 3、3 1 是重复的
            // //长度为i的绳子有i-1个剪切位置; 不论i是奇数还是偶数, 只考虑前i/2个剪切位置即可, 后面的剪切位置是重复的
            for (int j = 1; j <= i / 2; j++){
                dp[i] = dp[i].max(dp[j].multiply(dp[i - j]));
            }
        }
        return dp[n].mod(new BigInteger("1000000007")).intValue();
    }

}
