package fastSlowPoint;

public class HappyNumberSolution {

/**
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 * 也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。示例: 
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1*/

//如果不是快乐数最后都会进入 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 的循环中
// 已知规律： [1 ~ 4] 中只有 1 是快乐数，[5 ~ ∞] 的数字要么回归到 1 要么回归到 4 或 3
// 思路一：使用集合存储每一步的循环结果，若有数字再次出现过的时候，就不是快乐数。
// 思路二: 使用“快慢指针”思想找出循环：“快指针”每次走两步，“慢指针”每次走一步，当二者相等时，
// 即为一个循环周期。此时，判断是不是因为1引起的循环，是的话就是快乐数，否则不是快乐数。
    public boolean isHappy(int n) {
       int slow = n;
       int fast = squareSum(n);
       while (slow != fast){
           slow = squareSum(slow);
           fast = squareSum(fast);
           fast = squareSum(fast);
       }
       return slow == 1;
    }
    // 取出给定数字的各个位，放在数组中
    private int squareSum(int n){
        int sum = 0;
        while (n > 0){
            int num = n % 10;
            sum += num * num;
            n /= 10;
        }
        return sum;
    }

}
