package lock;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/10 13:50
 */
public class test {
    public static void main(String[] args) {
        byte a = 127;
        byte b = 127;
        a += b;
        System.out.println(a);
        a = 127;
        a = (byte) (a + b);
        System.out.println(a);
        long l1 = 1;
        long l2 = 2;
        l1 += l2;
    }


}
