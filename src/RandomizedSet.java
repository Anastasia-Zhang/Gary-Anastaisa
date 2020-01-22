import java.util.*;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/14 16:00
 */
public class RandomizedSet {
    List<Integer> list;
    HashMap<Integer, Integer> map;
    Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(list.size(),val);
        int index = list.size() - 1;
        map.put(val,index);
        return true;

    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        // 直接remove不能保持map和list的一致性
        // list.remove(val);
        // map.remove(val);
        // 将最后元素和要移除的元素交换位置
        int lastElement = list.get(list.size() - 1);
        int index = map.get(val);
        list.set(index, lastElement);
        map.put(lastElement,index);
        // 直接删除最后一个元素
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }

        int index = 0;
        for (int num : set){
            if (set.size() < 3 && index == set.size() - 1) return num;
            if (set.size() >= 3 && index == set.size() - 3) return num;
        }

        return 0;
    }
}
