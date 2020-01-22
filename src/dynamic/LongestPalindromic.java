package dynamic;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/19 21:44
 * 题目描述：找出最长回文子串
 */
public class LongestPalindromic {

    public static void main(String[] args) {
        System.out.println(longestPalindromeII("cabbad"));
    }
    // 暴力法
    public String longestPalindromeI(String s) {
        int len = s.length();
        if (len < 2) return s;
        String res = s.substring(0,1);
        int maxLen = 0;

        // 暴力循环所有的子串并判断
        for (int i = 0; i < len - 1; i++){
            for (int j = i + 1; i < len; j++){
                // 判断如果当前子串长度大于最大长度且是回文串
                if (j - i + 1 > maxLen && isPalindrome(s, i, j)){
                    maxLen = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s, int start, int end){
        while (start < end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static String longestPalindromeII(String s) {
        int len = s.length();
        if (len < 2) return s;


        // dp[i][j] 表示i开始j结束的子串是否为回文串
        int[][] dp = new int[len][len];
        // 初始化：对角线一定是子串
        for (int i = 0; i < len; i++){
            dp[i][i] = 1;
        }
        int start = 0;
        int maxLen = 1;

        for (int j = 1; j < len; j++){
            for (int i = 0; i < j; i++){
                if (s.charAt(j) == s.charAt(i)){
                    if (j - i < 3) dp[i][j] = 1;
                    else dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] == 1){
                    maxLen = Math.max(maxLen, j - i + 1);
                    start = maxLen == j - i + 1 ? i : start;
                }
                //print(dp);
            }
        }

        return s.substring(start, start + maxLen);

    }

    public static void  print(int[][] dp){
        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("================end=================");
    }
}
