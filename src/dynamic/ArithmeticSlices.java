package dynamic;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/28 15:21
 */
// 等差数划分
public class ArithmeticSlices {

    // 方法一 ： 暴力法 ，首先计算前两个数的差，再依次向后遍历计数
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length - 2; i++){
            int d = A[i + 1] - A[i];
            for (int j = i + 2; j < A.length; j++){
                if (A[j] - A[j - 1] == d) count++;
                else break;
            }
        }
        return count;
    }

    public int numberOfArithmeticSlices2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int total = 0;
        for (int cnt : dp) {
            total += cnt;
        }
        return total;
    }

    // 优化的动态规划
    public int numberOfArithmeticSlices3(int[] A) {
        int sum = 0;
        int dp = 0;// 定义一个常量来记录到i区间为止等差数列的个数
        for (int i = 1; i < A.length - 1; i++){
            if (A[i + 1] - A[i] == A[i] - A[i - 1]){
                dp = dp + 1; // 如果是，则数量 + 1
                sum += dp; // 定义和把所有等差数列的区间全部加起来
            }else dp = 0; // 如果不是，重置为0
        }
        return sum;
    }
}
