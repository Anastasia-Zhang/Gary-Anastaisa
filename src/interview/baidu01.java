package interview;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/29 18:50
 */
public class baidu01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = new int[n];
        String[] str = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(str[i]);
        }
        int count = 0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        while (nums[n - 1] > n) {
            nums[n - 1] -= n;
            for (int i = 0; i < n - 1; i++) nums[i] += 1;
            Arrays.sort(nums);
            count++;
        }
        System.out.println(count);
    }
}
