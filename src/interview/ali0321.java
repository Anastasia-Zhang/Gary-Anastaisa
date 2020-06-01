package interview;

import java.nio.channels.AcceptPendingException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/21 17:15
 */
public class ali0321 {
    private static int least = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        getLeastPoker(arr, 0);
        System.out.println(least);
    }

    public static void getLeastPoker(int[] arr, int ans) {
        // 从第一张大于0的排面开始
        int i = 0;
        for (; i < arr.length; i++) {
            if (arr[i] > 0) break;
        }
        // 从 0 到 10 都出完了
        if (i == 10) {
            least = Math.min(ans, least);
            return;
        }

        // 5 个顺子 10 占5个牌面
        if (i <= 5 && arr[i + 1] > 0 && arr[i + 2] > 0 && arr[i + 3] > 0 && arr[i + 4] > 0) {
            int[] arrCopy = Arrays.copyOf(arr, arr.length);
            for (int k = i; k < 5 + i; k++){
                arrCopy[k]--;
            }
            getLeastPoker(arrCopy, ans + 1);
        }

        // 3连对 占3个牌面
        if (i <= 7 && arr[i + 1] > 1 && arr[i + 2] > 1) {
            int[] arrCopy = Arrays.copyOf(arr, arr.length);
            for (int k = i; k < i + 3; k++){
                arrCopy[k] -= 2;
            }
            getLeastPoker(arrCopy, ans + 1);
        }

        // 双数 只是一个牌面
        if (arr[i] > 1) {
            int[] arrCopy = Arrays.copyOf(arr, arr.length);
            arrCopy[i] -= 2;
            getLeastPoker(arrCopy, ans + 1);
        }
        // 出一张牌
        if (arr[i] > 0) {
            int[] arrCopy = Arrays.copyOf(arr, arr.length);
            arrCopy[i] -= 1;
            getLeastPoker(arrCopy, ans + 1);
        }
    }
}
