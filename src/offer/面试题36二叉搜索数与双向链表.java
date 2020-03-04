package offer;

import common.Node;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/29 13:49
 */
public class 面试题36二叉搜索数与双向链表 {
    Node linkListHead;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        linkListHead = null;

        // 处理首尾两个结点,先找到首尾结点
        Node head = root;
        Node tail = root;
        // 找到最左边的结点,起始结点
        while (head.left != null){
            head = head.left;
        }
        // 找到最右边的结点，终点
        while (tail.right != null){
            tail = tail.right;
        }
        // 调整中间结点
        ConvertNode(root);
        // 中间的调整完之后把头尾两个结点连上
        head.left = tail;
        tail.right = head;
        return head;

    }

    public void ConvertNode(Node root){
        // 中序遍历有序
        if (root == null) return;


        // 遍历左节点
        ConvertNode(root.left);

        // 处理根节点
        // 前驱结点的右指针指向后结点，后继结点的左指针指向前驱
        if (linkListHead != null) {
            linkListHead.right = root;
            root.left = linkListHead;
        }
        linkListHead = root;

        ConvertNode(root.right);
    }
}
