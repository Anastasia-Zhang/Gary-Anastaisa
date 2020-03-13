package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/11 13:12
 */
public class 面试题64求1到n的和 {
    public int sumNums(int n) {
        int reslut = n;
        // && 的短路原则，当第一个条件为false的时候就不再执行第二个语句
        // 通过使用第一个条件为false （递归返回的条件取反） 来返回递归过程
        boolean b = (n > 0) && ((reslut += sumNums(n - 1)) > 0);
        return reslut;
    }
}
