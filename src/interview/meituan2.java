package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/12 19:49
 */
public class meituan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
//        String[] line1 = sc.nextLine().split(" ");
//        int n = Integer.parseInt(line1[0]);
//        int x = Integer.parseInt(line1[1]);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        //int[] nums2 = new int[]{3,1,3,2,5};
        System.out.println(operation(nums, x));
    }
    public static int operation(int[] nums, int x){
        Arrays.sort(nums);
        int count1 = 1;
        int maxCount1 = Integer.MIN_VALUE;
        int maxCountNum = nums[0];
        //System.out.println(Arrays.toString(nums));
        for (int i = 1; i < nums.length; i++){
            if (nums[i - 1] == nums[i]) {
                count1++;
            } else{
                count1 = 1;
            }
            maxCount1 = Math.max(maxCount1, count1);
            if (maxCount1 == count1) maxCountNum = nums[i];
        }

//        System.out.println(maxCountNum);
//        System.out.println(maxCount1);

        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            if (num != maxCountNum && (num | x) == maxCountNum) maxCount1++;
        }
        return maxCount1;
    }
}
