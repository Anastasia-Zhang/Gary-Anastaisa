package fastSlowPoint;

import common.ListNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/13 20:54
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        // 利用快慢指针，第一次相遇后再走非环长度的步数就可再次相遇达到环入口
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
