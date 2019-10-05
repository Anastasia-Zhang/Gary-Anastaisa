public class TrailingZeroesSolution {
    /**给定一个整数 n，返回 n! 结果尾数中零的数量。
    示例 1:
    输入: 3
    输出: 0
    解释: 3! = 6, 尾数中没有零
     */
    // 分解，要产生0，必然是5*2，就看阶乘1-n中有几个5的倍数，有几个5的倍数遍有几个0
    // 比如 15! 中数字 5、10、15 这 3 个数都都可以分解成 n * 5 ，也就是说对于每一个数都能找到一个 2 与之相乘，并且乘积结果为 n * 5 * 2

    public int trailingZeroes(int n) {
        int count = 0;
        while (n != 0){
            count += n/5;//25 分解出的5向下取整
            n = n / 5;
        }
        return count;
    }
}
