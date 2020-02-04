package dynamic;

import java.util.Arrays;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/31 22:59
 */
public class Bag01 {

    public static int[] weight = new int[]{2, 3, 4, 5};
    public static int[] value = new int[]{3, 4, 5, 6};
    public static int capacity = 8;

    public static void main(String[] args) {
        int[] weight = new int[]{2, 3, 4, 5};
        int[] value = new int[]{3, 4, 5, 6};
        int capacity = 8;
        big(weight, value, capacity);
    }

    public static void big(int[] weight, int[] value, int capacity){
        // dp[i][j] 代表在当前容量 j 时，前 i 个物品装入包中具有的最大价值
        int[][] dp = new int[weight.length + 1][capacity + 1];
        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                if (j - weight[i - 1] >= 0){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                    if (dp[i][j] == dp[i - 1][j]){
                        System.out.println("当前选择不装 :  物品:  " + i + "容量: " + j);
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        int[] item = new int[weight.length];
        int i = weight.length;
        int j = capacity;
        while (i > 1 && j > 1){
            if (dp[i][j] == dp[i - 1][j]){
                item[i - 1] = 0;
                i = i - 1;
                System.out.println("没有被选中返回： " + i + ", " + j);
            } else if (dp[i][j] == (dp[i - 1][j - weight[i - 1]] + value[i - 1])){
                item[i - 1] = 1;
                j = j - weight[i - 1];
                i = i - 1;
                System.out.println("被选中返回： " + i + ", " + j);
            }
        }
        item = new int[weight.length];
        findItems(weight.length, capacity, item, dp);
        System.out.println(Arrays.toString(item));
    }

    public static void findItems(int i, int j, int[] item, int[][] dp){
        if (i >= 1){
            // 不选该商品
            if (dp[i][j] == dp[i - 1][j]){
                item[i - 1] = 0;
                findItems(i - 1, j, item, dp);
            } else if (dp[i][j] == dp[i - 1][j - weight[i - 1]] + value[i - 1]){
                item[i - 1] = 1;
                findItems(i - 1, j - weight[i - 1], item, dp);
            }
        }
    }
}
