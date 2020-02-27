package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/25 16:21
 */
public class 面试题16数值的正数次方 {
    public double myPow(double x, int n) {
        // 考虑最小的数
        long N = n;
        if (n < 0) {
            return 1 / myPow(x, -N);
        }
        return myPow(x, N);
    }

    public double myPow(double x, long n) {
        if (n == 0 || x == 1) return 1;

        // 分冶算法
        // 如果 n 是偶数的话，可以分别计算 x 的  n / 2 的幂再相乘
        if ((n & 1) == 0) {
            // 分
            double square = myPow(x, n >>> 1);
            // 合
            return square * square;
        } else {
            double square = myPow(x, (n - 1) >>> 1);
            return square * square * x;
        }
    }



    public static double myPow2(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N *= -1;
        }
        // 在底数不断自身乘以自身的过程中，将最终结果需要的部分保存下来
        double res = 1;
        while (N > 0) {
            // System.out.println("N :" + Long.toBinaryString(N));
            // 最后 1 位是奇数， 把底数乘上
            if ((N & 1) == 1) {
                res *= x;
            }
            // System.out.println("res : " + res);
            // x 继续增大，相当于是几位
            x *= x;
            // System.out.println("x: " + x);
            // 无符号右移，取位数
            N >>>= 1;

        }
        return res;
    }

    public static void main(String[] args) {
        myPow2(3,4);
    }

}

