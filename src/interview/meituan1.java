package interview;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/12 19:07
 */
public class meituan1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String line1 = sc.nextLine();
        //System.out.println(line1);
        String line2 = sc.nextLine();
        //System.out.println(line2);
        char[][] road = new char[2][n];
        road[0] = line1.toCharArray();
        road[1] = line2.toCharArray();
        System.out.println(findPath(road));
    }

    public static int findPath(char[][] roads){
        if (roads[0][0] == 'X') return -1;

        int m = roads.length;
        int n = roads[0].length;
        if (roads[m - 1][n - 1] == 'X') return -1;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        dp[1][0] = 0;

        for (int j = 1; j < n; j++){
            for (int i = 0; i < m; i++){
                if (roads[i][j] == 'X') continue;
                // 第一行遍历
                if (i == 0){
                    if (roads[i][j - 1] == 'X') dp[i][j] = dp[i + 1][j - 1];
                    else if (roads[i + 1][j - 1] == 'X') dp[i][j] = dp[i][j - 1];
                    else dp[i][j] = dp[i + 1][j - 1] + dp[i][j - 1];
                } else {
                    if (roads[i - 1][j - 1] == 'X') dp[i][j] = dp[i][j - 1];
                    else if (roads[i][j - 1] == 'X') dp[i][j] = dp[i - 1][j - 1];
                    else dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
