import java.util.BitSet;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/13 22:38
 */
public class BloomFilter {
    /**
     * 位数组大小
     */
    private static final int DEFAULT_SIZE = 2 << 24;

    /**
     * 哈希函数种子
     */
    private static final int[] SEEDS = new int[]{3, 13, 46, 71, 91, 134};

    /**
     * 位数组
     */
    private BitSet bits = new BitSet(DEFAULT_SIZE);

    /**
     * 包含还有 hash 函数的类的数组
     */
    private SimpleHash[] func = new SimpleHash[SEEDS.length];

    /**
     * 静态内部类用于 hash 操作
     */
    class SimpleHash{
        private int cap; // 数组容量大小
        private int seed; // 随机函数种子

        public SimpleHash(int cap, int seed){
            this.cap = cap;
            this.seed = seed;
        }

        // 计算 hash 值 参考了hashMap
        public int hash(Object value){
            int h;
            return (value == null) ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
        }
    }

    public BloomFilter() {
        // 初试化不同的 hash 函数
        for (int i = 0; i < SEEDS.length; i++){
            func[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
        }
    }

    /**
     * 添加到元素到数组
     */
    public void  add(Object value){
        for (SimpleHash f : func){
            System.out.println(f.hash(value));
            System.out.println(f.hash(value) > DEFAULT_SIZE);
            bits.set(f.hash(value), true);
        }
    }

    /**
     * 判断指定元素是否存在位于数组里
     */
    public boolean contains(Object value){
        boolean res = true;
        for (SimpleHash f : func){
            // 在拿哈希函数去计算 hash 值，每个hash函数计算的值所在的位置上必须都得是 1 才能说明这个数存在
            res &= bits.get(f.hash(value));
        }
        return res;
    }

    public static void main(String[] args) {
        String value1 = "https://javaguide.cn/";
        String value2 = "https://github.com/Snailclimb";
        BloomFilter filter = new BloomFilter();
//        System.out.println(filter.contains(value1));
//        System.out.println(filter.contains(value2));
        // filter.add(value1); Exception in thread "main" java.lang.OutOfMemoryError: Java heap space at java.util.Arrays.copyOf(Arrays.java:3308)
        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
    }
}
