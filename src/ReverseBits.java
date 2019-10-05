public class ReverseBits {
    // 不断取最低位放在最前面
    public static int reverseBites(int n){
        int result = 0;
        for(int i = 0;i <= 32; i ++){
            // 1. 将给定的二进制数,由低到高位逐个取出
            int tmp = n >> i;
            System.out.println("右移位"+ i +" 位: " + Integer.toBinaryString(tmp));
            tmp = tmp & 1;
            System.out.println("取最低位 : " + Integer.toBinaryString(tmp));
            // 2. 然后通过位运算将其放置到反转后的位置.补全相应后面的0（位数)
            tmp = tmp << (31 - i);
            System.out.println("左移" + (32 - i) + "位 : " + Integer.toBinaryString(tmp));
            result |= tmp;
            System.out.println("结果： " + Integer.toBinaryString(result));
        }
        return result;
    }

    public static void main(String[] args) {
        reverseBites(43261596);// 10100101000001111010011100

    }

}
