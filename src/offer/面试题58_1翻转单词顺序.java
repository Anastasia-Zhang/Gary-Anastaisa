package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/10 23:09
 */
public class 面试题58_1翻转单词顺序 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        // 去掉头尾两端的空格
        String[] strs = s.trim().split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = strs.length - 1; i >= 0; i--){
            if (strs[i].equals("")) continue;
            if (i == 0) sb.append(strs[i].trim()); // 不加后面的空格
            else {
                // 去掉多余空格
                sb.append(strs[i].trim()).append(" ");
            }
        }
        return sb.toString();
    }
}
