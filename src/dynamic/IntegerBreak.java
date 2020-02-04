package dynamic;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/29 16:55
 */
public class IntegerBreak {

    public static void main(String[] args) {
        System.out.println(integerBreak(5));
    }
    public static int integerBreak(int n){
        // 将遍历过的值存储到数组中
        int[] memory = new int[n + 1];
        return integerBreakHelper(n, memory);
    }

    // 自顶向下递归优化，记忆搜索
    public static int integerBreakHelper(int n, int[] memory) {
        if (n == 2) {
            return 1;
        }
        if (memory[n] != 0) return memory[n];
        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            int res2 = integerBreakHelper(n - i, memory);
            int resOld = res;
            res = Math.max(resOld, Math.max(i * (n - i), res2));
            System.out.println("---");
            if (res == i * (n - i)) {
                System.out.println("i : " + i + " , n : " + n);
                System.out.println("递归结果： " + res2);
                System.out.println("现在不分割结果： " + resOld);
                System.out.println("最佳结果为分割两项的结果：" + res);
            }
        }
        memory[n] = res;
        return res;
    }

    // 自底向上 递归

}
