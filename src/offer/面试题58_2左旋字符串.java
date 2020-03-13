package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/10 23:18
 */
public class 面试题58_2左旋字符串 {
    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0) return s;
        if (n > s.length()) return "";
        StringBuffer sb = new StringBuffer();
        sb.append(s.substring(n, s.length()));
        sb.append(s.substring(0, n));
        return sb.toString();
    }
}
