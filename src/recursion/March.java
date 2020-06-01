package recursion;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/22 16:20
 */
public class March {

    public boolean isMatch(String s, String p) {
        int ls = s.length(), lp = p.length();
        boolean[][] dp = new boolean[ls + 1][lp + 1];
        // 空字符串设定是匹配的
        dp[0][0] = true;
        // 初试化第一行
        for (int j = 2; j <= lp; j++){
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        }

        for (int i = 1; i <= ls; i++){
            for (int j = 1; j <= lp; j++){
                if (p.charAt(j - 1) == '*'){
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)){
                        // s 的字符可以和 p 匹配， 因此看 s 前面的字符
                        // 可以取 0 个字符，代表他们之前已经匹配了
                        // s 可以匹配多个字符，则再从s向前回溯
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    }
                    else {
                        // 不能匹配，相当于 * 之前的字符出现了零次
                        dp[i][j] = dp[i][j - 2];
                    }
                }
                else if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[ls][lp];
    }
}
