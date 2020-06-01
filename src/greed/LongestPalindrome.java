package greed;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/19 23:23
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        // 贪心算法尽可能的去凑左右对称的字符，左右对称的字符的个数一定是偶数
        // 统计各个字符串的数量
        int[] count = new int[58];
        for (char c : s.toCharArray()) {
            count[c - 'A'] += 1;
        }
        int res = 0;
        // 尽可能的加偶数次的字符，计数次的就 - 1再加
        for (int x : count) {
            // x & 1 奇数为1正好减一偶数为0正好计数
            res += x - (x & 1);
        }
        // 判断小于字符串的长度，如果小于那就说明出现了奇数字符，再从奇数个字符里随便挑选一个加上
        // 如果等于那就正好等于偶数的长度
        return res < s.length() ? res + 1 : res;
    }
}
