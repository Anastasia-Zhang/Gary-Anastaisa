package dynamic;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/2 23:40
 */
public class OnesAndZeros {
    public static void main(String[] args) {
        String[] strs = new String[]{"111","1000","1000","1000"};
        System.out.println(findMaxForm(strs,9,3));
        //System.out.println(Arrays.toString(strs));
    }
    public static int findMaxForm1(String[] strs, int m, int n) {
        // 暴力按照字符串的长度排序，按照最小值取遍应该就能取得最长的字符串
        // 不一定是最优解 ["111","1000","1000","1000"] m = 9;n = 3 结果应该是 3
        int res = 0;
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        // 遍历字符串数组
        for (String str : strs){
            // 遍历字符串的每个字符，遇到0 m - 1，遇到 1 n - 1，直到二者用光
            for (int i = 0; i < str.length(); i++){
                if (str.charAt(i) == '0') m--;
                else n--;
                if (n < 0 || m < 0) return res;
            }
            res++;
        }

        return res;
    }

    // 动态规划做法：0/1 背包 0 和 1 的数量 分别是背包的容量。每个字符串是物品，体积是每个字符串 0 1的数量，价值为1
    // 多维背包问题 三维数组或者两个二维数组
    // 考虑状态压缩 直接映射称二维数组 从后往前
    public static int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;

        for (String str : strs){
            int[] count = countZeroOne(str);
            for (int i = m; i >= count[0]; i--){
                for (int j = n; j >= count[1]; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - count[0]][j - count[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private static int[] countZeroOne(String str){
        // 统计字符串中 0 和 1 的数量
        int[] count = new int[2];
        for (char ch : str.toCharArray()){
            count[ch - '0']++;
        }
        return count;
    }
}
