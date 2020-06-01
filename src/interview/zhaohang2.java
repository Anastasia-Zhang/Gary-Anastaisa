package interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/27 19:49
 */
public class zhaohang2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = Integer.parseInt(sc.nextLine());
        while (caseNum-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            int[] arr1 = new int[n];
            String[] str1 = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++){
                arr1[i] = Integer.parseInt(str1[i]);
            }
            int[] arr2 = new int[n];
            String[] str2 = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++){
                arr2[i] = Integer.parseInt(str2[i]);
            }
            int[][] paris1 = new int[n][2];
            for (int i = 0; i < n; i++) {
                paris1[i][0] = arr1[i];
                paris1[i][1] = arr2[i];
            }
            Arrays.sort(paris1, (o1, o2) ->{
                if (o1[0] != o2[0]) return o1[0] - o2[0];
                else return o1[1] - o2[1];
            });
            int[][] paris2 = new int[n][2];
            for (int i = 0; i < n; i++) {
                paris2[i][0] = arr2[i];
                paris2[i][1] = arr1[i];
            }
            Arrays.sort(paris2, (o1, o2) ->{
                if (o1[0] != o2[0]) return o1[0] - o2[0];
                else return o1[1] - o2[1];
            });
//            for (int i = 0; i < n; i++){
//                for (int j = 0; j < 2; j++){
//                    System.out.print(paris[i][j] + " ");
//                }
//                System.out.println();
//            }
            System.out.println(getNum(paris1, paris2));
        }
    }

    public static int getNum(int[][] paris1, int[][] paris2) {
//        int[] dp = new int[paris.length];
//        Arrays.fill(dp, 1);
//        int count = dp[0];
//        for (int i = 0; i < paris.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (paris[j][1] < paris[i][0]) {
//                    dp[i] = Math.max(dp[j] + 1, dp[i]);
//                }
//                count = Math.max(dp[i], count);
//            }
//        }
//        return count;
        int count1 = 0, count2 = 0;
        for (int i = 1; i < paris1.length; i++) {
            if (paris1[i - 1][1] > paris1[i][1]) count1++;
        }for (int i = 1; i < paris2.length; i++) {
            if (paris2[i - 1][1] > paris2[i][1]) count2++;
        }
        return Math.min(count1, count2);
    }
}
