import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * * Definition for singly-linked list.
 *  * class ListNode {
 *  *     int val;
 *  *     ListNode next;
 *  *     ListNode(int x) {
 *  *         val = x;
 *  *         next = null;
 *  *     }
 *  *
 *  https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode/
 */


public class LinkedListCycle {

    /*检查一个结点此前是否被访问过，可以用哈希表记录。若所有节点都被引用过则为链表*/
     public boolean hasCycleByHashTable(ListNode head){
         Set<ListNode> nodesSeen = new HashSet<>();
         while (head != null) {
             if (nodesSeen.contains(head)) {
                 return true;
             } else {
                 nodesSeen.add(head);
             }
             head = head.next;
         }
         return false;
     }

    /*通过使用具有 不同速度 的快、慢两个指针遍历链表，空间复杂度可以被降低至 O(1)。慢指针每次移动一步，而快指针每次移动两步。
    如果列表中不存在环，最终快指针将会最先到达尾部，此时我们可以返回 false
    */
     public boolean hasCycleByPointer(ListNode head){
         if (head == null || head.next == null) {
             return false;
         }
         ListNode slow = head;
         ListNode fast = head.next;
         while (slow != fast) {
             if (fast == null || fast.next == null) {
                 return false;
             }
             slow = slow.next;
             fast = fast.next.next;
         }
         return true;
     }
}
