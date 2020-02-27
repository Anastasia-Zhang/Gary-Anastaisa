package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/25 18:49
 */
public class 面试题17打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        int[] result = new int[(int) Math.pow(10, n) - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
