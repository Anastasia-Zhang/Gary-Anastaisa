package dynamic;

import java.util.Arrays;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/31 13:29
 */
public class LongestChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < pairs.length; i++){
            for (int j = 0; j < i; j++){
                if (pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int num : dp){
            max = Math.max(max, num);
        }
        return max;
    }
}
