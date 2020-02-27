package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/25 15:15
 */
public class 面试题15二进制中1的个数 {
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0){
            count++;
            // 会去掉最后的 1 位的1，看能去掉几次就可以
            n &= (n - 1);
        }
        return count;
    }
}
