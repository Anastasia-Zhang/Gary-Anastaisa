public class IntToRoma {

    public String intToRoman(int num) {
        String[] strList = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] intList = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        ;
        StringBuffer sb = new StringBuffer("");
        int index = 0;
        while (index < 13) {
            while (num >= intList[index]) {
                num -= intList[index];
                sb.append(strList[index]);
            }
            index++;
        }
        return sb.toString();
    }
}