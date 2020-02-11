package dynamic;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/8 15:29
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++){
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++){
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min3(
                            dp[i - 1][j] + 1, // 删除
                            dp[i - 1][j - 1] + 1, // 替换
                            dp[i][j - 1] + 1 // 添加
                    );
                }
            }
        }

        return dp[m][n];
    }

    public int min3(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}
