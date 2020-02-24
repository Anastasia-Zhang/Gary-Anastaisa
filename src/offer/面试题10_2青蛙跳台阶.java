package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/23 22:26
 */
public class 面试题10_2青蛙跳台阶 {
    public int numWays(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        // return fib(n - 1) + fib(n - 2);
        int fibOne = 1;
        int fibTwo = 2;
        int fibN = 0;
        for (int i = 3; i <= n; i++){
            fibN = (fibOne + fibTwo) % 1000000007;
            // 为下一次循环做准备
            fibOne = fibTwo;
            fibTwo = fibN;
        }
        return fibN;
    }
}
