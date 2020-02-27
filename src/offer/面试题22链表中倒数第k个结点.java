package offer;

import common.ListNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/26 18:37
 */
public class 面试题22链表中倒数第k个结点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        // 先走 k - 1 步
        int count = 0;
        while (fast != null && count < k - 1){
            fast = fast.next;
            count++;
        }
        // 链表中的结点数量小于 k
        if (fast == null) return null;
        // 执行到尾结点的地方
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
