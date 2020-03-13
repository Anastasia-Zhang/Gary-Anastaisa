package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/11 11:42
 */
public class 面试题62圆圈中最后剩下的数字 {
    static class LinkedList{
        int val;
        LinkedList next;
        public LinkedList(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        //System.out.println(lastRemaining(70866,116922));
    }
    // 环形链表 非常非常的慢
 //   public static int lastRemaining(int n, int m) {
//        LinkedList head = new LinkedList(0);
//        LinkedList cur = head;
//        // 建立环形链表
//        for (int i = 1; i < n; i++){
//            LinkedList node = new LinkedList(i);
//            cur.next = node;
//            cur = node;
//        }
//        cur.next = head;
//        LinkedList pre = cur;
//        cur = head;
//        // LinkedList pre = head;
//        int index = 1;
//        while (pre.next != null){
//            // pre = cur;
//            // cur = cur.next;
//            // index++;
//            if (index == m){
//                // System.out.println(cur.val);
//                if (cur.next != pre){
//                    pre.next = cur.next;
//                    cur = pre.next;
//                    //pre = cur;
//                    index = 1;
//                    continue;
//                } else {
//                    // cur.next = null;
//                    pre.next = null;
//                    break;
//                }
//            }
//            pre = cur;
//            cur = cur.next;
//            index++;
//        }
//        return pre.val;

//    }

    public int lastRemaining1(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < n; i++){
            list.add(i);
        }
        int c = (m - 1) % n;
        while (list.size() != 1){
            list.remove(c);
            c = (c + m - 1) % list.size();
        }
        return list.get(0);
    }

    public int lastRemaining2(int n, int m) {
        int last = 0;
        for (int i = 2; i <= n; i++){
            last = (last + m) % i;
        }
        return last;
    }
}
