/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 */
public class ExcelColumnTitle {
    public String convertToTitle(int n) {
        // 递归做法
        //  return (n-- == 0) ? "" : (convertToTitle(n / 26) + (char)(n % 26 + 'A'));
        // 26进制的转化，将给定的字母除以26得到的余数就是26个字母的相对位置
        // 相似题目：判断位数
        if (n <= 0) {
            return "";
        }
        // Java中字符串的处理：StringBuilder
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n --;//1 对应 A
            sb.append((char) (n % 26 + 'A'));
            n = n / 26;
        }
        return sb.reverse().toString();
    }
}
