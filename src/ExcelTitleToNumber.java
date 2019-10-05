public class ExcelTitleToNumber {
    //'A'->1 'AB'->28
    public int titleToNumber(String s) {
        int res = 0;
        char[] titleCharArray = s.toCharArray();
        for(char c : titleCharArray){
            int num = c -'A' + 1; // 得出26个字母中当前字母对应的数值
            res = 26 * res + num; // 每26个数向前进1位
        }
        return res;
    }
}
