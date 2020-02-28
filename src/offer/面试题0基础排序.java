package offer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/28 22:50
 */
public class 面试题0基础排序 {

    public static void main(String[] args) {
        int[] arr = new int[]{0,5,6,4,3,8,1,9};
        quickSortWithStack(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] nums, int left, int right){
        if (left < right){
            int i = partition(nums, left, right);
            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }
    }

    public static void quickSortWithStack(int[] nums, int left, int right){
        LinkedList<Integer> stack = new LinkedList<>();
        // 先右后左这样能保证取出来是先左后右
        stack.push(right);
        stack.push(left);
        while (!stack.isEmpty()){
            int l = stack.pop();
            int r = stack.pop();
            int pivot = partition(nums, l, r);
            if (pivot - 1 > l){
                // quickSort(nums, left, i - 1);
                stack.push(pivot - 1);
                stack.push(l);
            }
            if (pivot + 1 < r){
                // quickSort(nums, i + 1, right);
                stack.push(r);
                stack.push(pivot + 1);
            }
        }
    }


    public static int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        while (left < right){
            while (left < right && nums[right] > pivot) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] < pivot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

}
