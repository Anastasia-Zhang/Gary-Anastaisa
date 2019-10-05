public class TrailingZeroes {


    // 大数阶乘越界
    public int trailingZeroes(int n) {
        int facRes = fac(n);
        int count = 0;
        while(facRes % 10 == 0){//阶乘结果能被10整除的次数
            count ++;
            facRes = facRes / 10;
        }
        return count;
    }

    public int fac(int n){
        if(n == 1){
            return 1;
        }
        return n * fac(n - 1);
    }
}
class TestMain{
    public static void main(String[] args) {
        TrailingZeroesSolution tz = new TrailingZeroesSolution();
        //System.out.println(tz.fac(20));// -2102132736
        System.out.println(tz.trailingZeroes(30));
    }
}
