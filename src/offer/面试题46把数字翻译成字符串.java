package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/3 23:30
 */
public class 面试题46把数字翻译成字符串 {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int len = str.length();
        if (len == 1) return 1;
        int[] dp = new int[len];
        dp[len - 1] = 1;
        // 0 也算 大于 10 是不能以0 开头
        if ((str.charAt(len - 2) - '0') * 10 + (str.charAt(len - 1) - '0') <= 25
                && (str.charAt(len - 2) - '0') * 10 + (str.charAt(len - 1) - '0') >= 10)
            dp[len - 2] = 2;

        else
            dp[len - 2] = 1;
        for (int i = len - 3; i >= 0; i--){
            if ((str.charAt(i) - '0') * 10 + (str.charAt(i + 1) - '0') <= 25
                    && (str.charAt(i) - '0') * 10 + (str.charAt(i + 1) - '0') >= 10 )
                // 从 i + 1 开始的个数，可以分离出 1 个来，从 i + 2 个开始的个数，可以分离出两个来
                dp[i] = dp[i + 1] + dp[i + 2];
            else
                dp[i] = dp[i + 1];
        }

        return dp[0];

    }



}
