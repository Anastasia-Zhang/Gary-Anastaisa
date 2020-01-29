package dynamic;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/27 22:13
 */
public class DecodeWays {

    public int numDecodings(String s) {
        int len = s.length();
        if (s.length() == 0 || s == null) return 0;

        // 用于最后一位计数
        int[] dp = new int[len + 1];
        dp[len] = 1;

        // 若为0 则都为 0 或 1
        if (s.charAt(len - 1) == '0'){
            dp[len - 1] = 0;
        }else {
            dp[len - 1] = 1;
        }

        for (int i = len - 2; i >= 0; i--){
            if (s.charAt(i) == '0'){
                dp[i] = 0;
                continue;
            }
            // 若前两位小于 26 则有两种拆分情况，拆分前一位和拆分前2位
            if ((s.charAt(i)  - '0') * 10 + (s.charAt(i + 1) - '0') <= 26){
                dp[i] = dp[i + 1] + dp[i + 2];
            }else {
                dp[i] = dp[i + 1];
            }
        }

        return dp[0];
    }
}
