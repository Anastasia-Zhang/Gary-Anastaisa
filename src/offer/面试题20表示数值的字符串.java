package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/26 22:04
 */
public class 面试题20表示数值的字符串 {
    // 字符串的模式有两种
    // A[.[B]][e|EC]
    // .B[e|EC]
    // A 和 C 都是有 + - 开头的的 0 到 9 的数字
    // B 只能是数字前面不能有正负号

    int i = 0; // 全局索引 时刻砍断索引不越界
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0){
            return false;
        }

        // 去掉首尾的空字符
        s = s.trim();
        boolean A = scanInteger(s);// 扫描整数,看是否存在整数
        boolean B = false;
        boolean C = false;


        // 判断 B 是否合法
        if (i < s.length() && s.charAt(i) == '.') {
            i++; // 略过 .
            // 扫描 B
            B = scanUnsignedInteger(s);

        }

        if (i < s.length() && (s.charAt(i) == 'e' || s.charAt(i) == 'E')){
            i++;
            C = scanInteger(s);
            // 如果 C 不合法
            if (C == false) return false;
        }

        // here, 说明C是合格的, 只需判断A和B的情况
        // i必须扫描完整个字符串 && (A合格则B合不合格都可以, A不合格则B必须合格)
        return i == s.length() && (A || B);



    }

    public boolean scanInteger(String s){
        // 找到 A 或者 C 的那个部分
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            i++;
        }
        return scanUnsignedInteger(s);
    }

    public boolean scanUnsignedInteger(String s){
        int start = i; // 起始索引
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            i++;
        }
        //i > start说明扫描到了数字;
        //i <= start说明没有扫描到数字, 此种情况说明要么start越界, 要么s.charAt(start)不是数字
        return i > start;

    }
}
