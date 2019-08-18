import common.ListNode;
/**找到两个链表相交的起始节点*/
/**
 * 空间复杂度 O(1) 时间复杂度为 O(n)
 * 要设置两个指针，为了一次遍历两个链表，必须让两个链表从同距离末尾同等距离的位置开始遍历。这个位置只能是较短链表的头结点位置。
 * 为了找到该位置，我们必须消除两个链表的长度差
 *
 * (1) 指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
 * (2) 如果 pA 到了末尾，则 pA = headB 继续遍历
 * (3) 如果 pB 到了末尾，则 pB = headA 继续遍历
 * (4) 比较长的链表指针指向较短链表head时，长度差就消除了
 * 如此，只需要将最短链表遍历两次即可找到位置

 * */
public class IntersectionNodeSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
