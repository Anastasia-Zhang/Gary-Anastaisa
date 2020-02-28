package bits;

public class NumberOf1Bits {
    public static int hammingWeight(int n) {//
        int count = 0;
        for(int i = 0; i < 32; i ++){
            int temp = n >> i;
            System.out.println("右移位"+ i +" 位: " + Integer.toBinaryString(temp));
            temp &= 1;
            System.out.println("取最低位 : " + Integer.toBinaryString(temp));
            if(temp == 1) count ++;
            System.out.println(count);
        }
        return count;
    }

    public static void main(String[] args) {
       // System.out.println(hammingWeight(11));
        NumberOf1Bits(11);
    }

    // 在二进制表示中，数字 n 中最低位的 1 总是对应 n - 1 中的 0 。因此，将 n 和 n - 1 与运算总是能把 n 中最低位的 1 变成 0 ，并保持其他位不变。
    public static int NumberOf1Bits(int n){
        int sum = 0;
        while (n != 0){
            sum ++;
            n &= (n - 1);
        }
        return sum;
    }

}