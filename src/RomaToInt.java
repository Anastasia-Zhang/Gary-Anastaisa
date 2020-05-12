import java.util.HashMap;

public class RomaToInt {
    public int romanToInt(String s) {
        HashMap<Character, Integer> dict = new HashMap<>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);
        char[] charArray = s.toCharArray();
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (i + 1 <= charArray.length - 1) {
                if (charArray[i] == 'I' && charArray[i + 1] == 'V') {
                    count += 4;
                    i++;
                }
                else if (charArray[i] == 'I' && charArray[i + 1] == 'X') {
                    count += 9;
                    i++;
                }
                else if (charArray[i] == 'X' && charArray[i + 1] == 'L') {
                    count += 40;
                    i++;
                }
                else if (charArray[i] == 'X' && charArray[i + 1] == 'C') {
                    count += 90;
                    i++;
                }
                else if (charArray[i] == 'C' && charArray[i + 1] == 'D') {
                    count += 400;
                    i++;
                }
                else if (charArray[i] == 'C' && charArray[i + 1] == 'M') {
                    count += 900;
                    i++;
                }
                else {
                    count += dict.get(charArray[i]);
                }
            } else {
                count += dict.get(charArray[i]);
            }

        }
        return count;
    }
}
