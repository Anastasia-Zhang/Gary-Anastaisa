import common.ListNode;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Scanner reader = new Scanner(System.in);
        int[] linkDataA = new int[]{4,1,8,4,5};
        int[] linkDataB = new int[]{5,0,1,8,4,5};
        ListNode headA = initListNode(linkDataA);
        ListNode headB = initListNode(linkDataB);
        IntersectionNode intersectionNode = new IntersectionNode();
        ListNode result = intersectionNode.getIntersectionNode(headA,headB);
        if (result != null)
            System.out.println("Reference of the node with value = "+result.val);
        System.out.println("Hello World!");
    }

     private static ListNode initListNode(int[] listData){
        ListNode head = new ListNode(listData[0]);
        ListNode p = head;
        for(int i = 1; i < listData.length; i ++){
            p.next = new ListNode(listData[i]);
            p = p.next;
        }
        return head;
    }
}
