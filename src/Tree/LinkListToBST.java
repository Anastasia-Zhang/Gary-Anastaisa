package Tree;

import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/19 16:07
 */
public class LinkListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        // 只有一个结点的情况
        // 转化为数列进行数列的查找
//        int[] nums = listToArray(head);
//        return generateBST(nums, 0, nums.length - 1);
        if (head.next == null) return new TreeNode(head.val);
        ListNode midPre = findMidNode(head);
        ListNode mid = midPre.next;
        midPre.next = null; // 断开链表
        // 中间结点形成根节点,中间结点以外的两个结点递归构造树
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    public ListNode findMidNode(ListNode head){
        // 快慢指针，当快指针走完全表时，慢指针走到中间
        ListNode pre = head;// 不饿为null 当有两个节点的时候可能返回head
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;// 返回中间结点的前一个结点
    }

    public TreeNode generateBST(int[] nums, int start, int end){
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = generateBST(nums, start, mid - 1);
        node.right = generateBST(nums, mid + 1, end);
        return node;
    }

    private int[] listToArray(ListNode head){
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode node = null;
        while (head != null){
            node = head;
            arrayList.add(node.val);
            head = head.next;
        }
        int[] nums = new int[arrayList.size()];
        for(int i = 0; i < arrayList.size();i++){
            nums[i] = arrayList.get(i);
        }
        return nums;
    }
}
