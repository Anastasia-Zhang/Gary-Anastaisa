package common;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
//        int i = 0;
//        while (i < n) {

            String[] stringArray = sc.nextLine().split(" ");
            int[] arr = new int[stringArray.length - 1];
            for(int j = 1;j < stringArray.length;j ++){
                arr[j - 1] = Integer.parseInt(stringArray[j]);
            }
//            //int[] ins = insertSort(arr);
            // int[] ins = bubbleSort(arr);
            // int[] ins = countSort(arr);
            quickSort1(arr, 0 , arr.length - 1);
            for(int k = 0; k < arr.length - 1; k ++){
                System.out.print(arr[k] + " ");
            }
            System.out.print(arr[arr.length - 1]);
//            i ++;
//        }
    }
    private static int[] insertSort(int[] ins){
        for(int i = 1; i < ins.length; i++){
            int temp = ins[i];//保存每次需要插入的那个数
            int j;
            for(j = i;j > 0 && ins[j - 1] > temp; j--){
                ins[ j ] = ins[j - 1];//把大于需要插入的数往后移动。最后不大于temp的数就空出来j
            }
            ins[j] = temp;//将需要插入的数放入这个位置
        }
        return ins;
    }
    // 1 3 4 2 7 8 6 5
    // 1 3 4 2 7 8 6 5
    // 1 2 3 4 7 8 6 5
    // 1 2 3 4 6 7 8 5
    // 1 2 3 4 5 6 7 8

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            // 提前退出冒泡循环的标志位,即一次比较中没有交换任何元素，这个数组就已经是有序的了
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; ++j) {        //此处你可能会疑问的j<n-i-1，因为冒泡是把每轮循环中较大的数飘到后面，
                // 数组下标又是从0开始的，i下标后面已经排序的个数就得多减1，总结就是i增多少，j的循环位置减多少
                if (arr[j] > arr[j + 1]) {        //即这两个相邻的数是逆序的，交换
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;//没有数据交换，数组已经有序，退出排序
        }
        return arr;
    }

    private static int[] countSort(int[] arr){

        if (arr == null || arr.length == 0) return null;

         // arr:[4, 5, 5, 7, 8, 3]
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //找出数组元素中的最大最小值
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        int[] help = new int[max - min + 1];

        // 找出每个数字的出现次数,index和value的映射关系，help代表在最小值和最大值区间内的每个数出现的个数
        for(int i = 0;i < arr.length; i ++){
            int mapPos = arr[i] - min;
            help[mapPos] ++;
        }

        // [1, 1, 2, 0, 1, 1]

        int index = 0;
        for(int i = 0; i < help.length; i++){
            while (help[i]-- > 0){
                arr[index++] = i + min;
            }
        }

        return arr;
    }

    // 找一个基准值，使数组的左边都小于这个基准值，数组的左边都大于基准值，再分别对两边的数组排序，直到两两边均有序
    private static void quickSort1(int[] s, int left, int right){
        if(left < right){
//            int i = left, j = right;
//            int temp = s[right];
//            while (i < j){
//                // 寻找左边第一个大于基准值的下标
//                while (s[i] < temp && i < j) i ++;
//                if(i < j) s[j--] = s[i];
//                // 寻找右边第一个小于基准值的下标
//                while (s[j] >= temp && i < j) j--;
//                if(i < j) s[i++] = s[j];
//            }
//            s[i] = temp;
            int i = partition(s, left, right);
            quickSort1(s,left,i - 1); // 递归左边部分数组
            quickSort1(s,i + 1,right); // 递归右边数组
        }
    }

    // 通过栈的方式来不断记录下标，来实现对两边的数组进行排序
    private static void quickSort2(int[] arr, int left, int right){
        LinkedList<Integer> stack = new LinkedList<>();
        if(left < right){
            stack.push(right);
            stack.push(left);
            while (!stack.isEmpty()){
                int l = stack.pop();
                int r = stack.pop();
                int index = partition(arr, l, r);
                if (l < index - 1){
                    stack.push(index - 1);
                    stack.push(l);
                }
                if (r > index + 1){
                    stack.push(r);
                    stack.push(index + 1);
                }
            }
        }
    }

    private static int partition(int[] arr, int left, int right){
        int pivot = arr[left];
        while (left < right){
            // 寻找右边第一个小于基准值的下标
            while (left < right && arr[right] > pivot) right--;
            arr[left] = arr[right];
            // 寻找左边第一个大于这个基准值的下标
            while (left < right && arr[left] < pivot) left++;
            arr[right] = arr[left];
        }
        arr[left ] = pivot;
        return left;
    }

    // 归并排序：基于分冶归并排序基于分治（快排也是），利用归并来实现排序，其基本思想是：
    //　如果一个数组有n个数据，则可以把这个数组看作n个有序的子序列，每个子序列的长度为1，
    // 然后两两归并，就能得到[n/2]个长度为2（或者1，落单的)的字序列，再不断地两两归并，直到得到一个长度为n的有序数组。

    private static  void segment(int[] nums, int left, int right){
        if(left < right){
            int center = (left + right) / 2;
            segment(nums, left, center);
            segment(nums, center + 1, right);
            merge(nums, left, center, right);
        }
    }


    // 2路归并
    private static void merge(int[] nums, int left, int center, int right){
        int[] tmpArray = new int[right - left + 1];
        int leftIndex = left;   //左数组第一个元素的索引
        int rightIndex = center + 1;   //右数组第一个元素索引
        int tmpIndex = 0;    //临时数组索引

        // 先把较小的数移到新的数组中
        while (leftIndex <= center && rightIndex <= right){
            if(nums[leftIndex] <= nums[rightIndex]){
                tmpArray[tmpIndex++] = nums[leftIndex++];
            }else{
                tmpArray[tmpIndex++] = nums[rightIndex++];
            }
        }
        // 把左边剩余的数移入数组
        while (leftIndex <= center){
            tmpArray[tmpIndex++] = nums[leftIndex++];
        }
        // 把右边剩余的数移入数组
        while (rightIndex <= right){
            tmpArray[tmpIndex++] = nums[rightIndex++];
        }
        // 新数组覆盖原数组
        System.arraycopy(tmpArray, 0 ,nums, left, tmpArray.length);
    }

}
