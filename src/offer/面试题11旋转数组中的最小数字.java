package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/24 13:29
 */
public class 面试题11旋转数组中的最小数字 {
    public int minArray(int[] numbers) {
        if (numbers.length == 0 || numbers == null) return 0;
        int i = 0;
        int j = numbers.length - 1;
        while (i < j){
            int mid = (i + j) >>> 1;
            // 如果中间的数大于左边元素指向的第一个数组，则最小数字一定是在右边的区间里
            if (numbers[mid] > numbers[j]) i = mid + 1;
            else if (numbers[mid] < numbers[j]) j = mid;
            else j--; // 缩小区间继续查找，因为这个数一定是在 i j 这个区间内
        }
        return numbers[i];
    }
}
