import java.util.Scanner;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/21 22:40
 */
public class ali0221 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] numStr = sc.nextLine().split(" ");
        int[] nums = new int[numStr.length];
        for (int i = 0; i <  nums.length; i ++){
            nums[i] = Integer.parseInt(numStr[i]);
        }
        int n = sc.nextInt();
        System.out.println(findIndex2(nums, n));
    }

    public static int findIndex(int[] nums, int n){
        int i = 0;
        for(i = 0; i < nums.length; i++){
            if (nums[i] == n || nums[i] > n) return i;
        }
        if (i == 0) return 0;
        else return  nums.length;
    }

    public static int findIndex2(int[] nums, int n){
        // 二分查找
        int low = 0;
        int high = nums.length;
        int mid = 0;
        while (low < high){
            mid = (low + high) / 2;
            if (nums[mid] > n) high = mid - 1;
            else if (nums[mid] < n) low = mid + 1;
            else return mid;
        }
        return mid;
    }
}
