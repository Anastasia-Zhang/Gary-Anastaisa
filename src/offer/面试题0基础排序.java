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
        int[] arr = new int[]{0,5,6,4};
        // System.out.println(segmentCount(arr, 0, arr.length - 1));
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
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
        // 非递归是将下标加入到栈中来循环调用 partition 方法
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

    // 归并排序
    public static void segment(int[] nums, int left, int right){
        if (left < right){
            int center = left + (right - left) / 2;
            segment(nums, left, center);
            segment(nums, center + 1, right);
            merge(nums, left, center, right);
        }
    }

    public static void merge(int[] nums, int left, int center, int right){
        // 分成左右两个半部分
        int[] tempNum = new int[right - left + 1];
        int leftIndex = left;
        int rightIndex = center + 1;
        int tempIndex = 0;
        while (leftIndex <= center && rightIndex <= right){
            // 双指针，查看两组元素的大小，先把较小的归并到临时数组中
            if (nums[leftIndex] <= nums[rightIndex]) tempNum[tempIndex++] = nums[leftIndex++];
            else tempNum[tempIndex++] = nums[rightIndex++];
        }

        // 合并剩下的
        while (leftIndex <= center){
            tempNum[tempIndex++] = nums[leftIndex++];
        }

        while (rightIndex <= right){
            tempNum[tempIndex++] = nums[rightIndex++];
        }
        tempIndex = 0;
        for (int i = left; i <= right; i++){
            nums[i] = tempNum[tempIndex++];
        }
    }

    static int count = 0;

    // 逆序的对数
    public static int segmentCount(int[] nums, int left, int right){
        if (left >= right) return 0;
        else {
            int center = left + (right - left) / 2;
            int leftNum = segmentCount(nums, left, center);
            int rightNum = segmentCount(nums, center + 1, right);
            int reverseNum = leftNum + rightNum;
            if (nums[center] < nums[center + 1]){
                return reverseNum;
            }
            return mergeCount(nums, left, center, right) + reverseNum;

        }
    }

    public static int mergeCount(int[] nums, int left, int center, int right){
        //int reverseNum = 0;
        // 分成左右两个半部分
        int reverseNum = 0;
        int[] tempNum = new int[right - left + 1];
        int leftIndex = left;
        int rightIndex = center + 1;
        int tempIndex = 0;
        while (leftIndex <= center && rightIndex <= right){
            // 双指针，查看两组元素的大小，先把较小的归并到临时数组中
            if (nums[leftIndex] <= nums[rightIndex]) {
                tempNum[tempIndex++] = nums[leftIndex++];

            }
            else {
                reverseNum += center - left + 1;
                // 右边的数字小，与整个左数组构成了逆序
                tempNum[tempIndex++] = nums[rightIndex++];

            }
        }
        // 合并剩下的
        while (leftIndex <= center){
            tempNum[tempIndex++] = nums[leftIndex++];
        }

        while (rightIndex <= right){
            tempNum[tempIndex++] = nums[rightIndex++];
        }
        tempIndex = 0;
        for (int i = left; i <= right; i++){
            nums[i] = tempNum[tempIndex++];
        }
        return reverseNum;
    }

    public static int countReverse(int[] nums){
        int num = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] < nums[i]) num++;
            }
        }
        return num;
    }

    // 堆排序实现，大顶堆
    public static void heapSort(int[] nums){
        int n = nums.length - 1;
        // 堆内有序,从最后一个根节点开始扫描
        for (int i =  n / 2 - 1; i >= 0; i--){
            heapify(nums, i, n);
           // System.out.println(Arrays.toString(nums));
        }
        // 堆排序，把最大元素放在后面
        while (n > 0){
            swap(nums, 0, n);
            n --;
            heapify(nums, 0, n);
        }
    }

    public static void heapify(int[] nums, int k, int n){
        while (2 * k + 1 <= n){
            int child = 2 * k + 1;
            if (child < n && nums[child] < nums[child + 1]) child++;
            if (nums[k] >= nums[child]) break;
            swap(nums, k, child);
            k = child;
        }
    }


    private static void swap(int[] nums, int i, int j){

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }


}
