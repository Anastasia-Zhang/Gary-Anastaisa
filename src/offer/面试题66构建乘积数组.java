package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/11 15:22
 */
public class 面试题66构建乘积数组 {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) return new int[0];
        int[] result = new int[a.length];
        int k = 1;
        // 计算左边结果
        for (int i = 0; i < a.length; i++){
            result[i] = k; // 把之前 i - 1 个数的乘积赋值给 result 如果 i = 0； 则为1
            k *= a[i]; // k 再乘上当前数
        }
        // 计算右边结果
        k = 1;
        for (int i = a.length - 1; i >= 0; i--){
            result[i] *= k;  // 累乘上i + 1 结果，从右边开始计算 如果是最后一个元素则为1
            k *= a[i];
        }
        return result;
    }
}
