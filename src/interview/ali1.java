package interview;

import java.util.Scanner;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/23 19:05
 */
public class ali1 {
    public static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        getNumbers(n, 1);
        System.out.println(count);

    }

    public static void getNumbers(int n, int index){
        for (int i = index; i <= n; i++){
            count = (count + 1) % 1000000007;
            getNumbers(n, index + 1);
        }
    }

}
