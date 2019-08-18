import common.ListNode;

import java.util.HashSet;
import java.util.Set;
/**找到两个链表相交的起始节点*/

public class IntersectionNode {
    // 思路参考环形链表，将一个链表放入到哈希表中，再遍历另一个链表查看该链表的结点的引用是否存在已知哈希表中
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return  null;
        ListNode pA = headA;
        ListNode pB = headB;
        Set<ListNode> nodes = new HashSet<>();
        // 非pB.next != null 防止b链表只有一个元素时无法加到哈希表当中
        while (pB != null){
            nodes.add(pB);
            pB = pB.next;
        }
        while (!nodes.contains(pA)){
            if(pA.next == null) return null;
            pA = pA.next;
        }
        return pA;
    }
}
