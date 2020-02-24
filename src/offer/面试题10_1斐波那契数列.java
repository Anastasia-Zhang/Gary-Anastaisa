package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/23 22:19
 */
public class 面试题10_1斐波那契数列 {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        // return fib(n - 1) + fib(n - 2);
        int fibOne = 0;
        int fibTwo = 1;
        int fibN = 0;
        for (int i = 2; i <= n; i++){
            fibN = (fibOne + fibTwo) % 1000000007;
            // 为下一次循环做准备
            fibOne = fibTwo;
            fibTwo = fibN;
        }
        return fibN;
    }
}
