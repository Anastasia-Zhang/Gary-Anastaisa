package interview;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/27 18:51
 */
public class zhaohang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = Integer.parseInt(sc.nextLine());
        while (caseNum-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            int[] arr = new int[n];
            String[] str = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++){
                arr[i] = Integer.valueOf(str[i]);
            }
            System.out.println(getNum(arr));
        }
    }

    public static int getNum(int[] arr){
        Arrays.sort(arr);
        int index = 0;
        while (index < arr.length && arr[index] == 0 ) {
            index++;
            // System.out.println(index);
        }
        if (arr[arr.length - 1] >= arr.length) return arr.length + 1 - index;
        else return -1;
    }
}
