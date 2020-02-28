package Tree;

import common.TreeNode;

import java.util.*;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/20 23:02
 */
public class BSTTwoSum {
    public boolean findTarget1(TreeNode root, int k) {
        Set < Integer > set = new HashSet();
        return find(root, k, set);
    }
    public boolean find(TreeNode root, int k, Set< Integer > set) {
        // 递归遍历二叉树，将当前结点加入到set中，判断是否存在 k - 当前结点的值
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }

    public boolean findTarget(TreeNode root, int k) {
        Set < Integer > set = new HashSet();
        Queue< TreeNode > queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                TreeNode node = queue.remove();
                if (set.contains(k - node.val))
                    return true;
                set.add(node.val);
                queue.add(node.right);
                queue.add(node.left);
            } else
                queue.remove();
        }
        return false;
    }

    ArrayList<Integer> ans = new ArrayList<>();
    public boolean findTarget2(TreeNode root, int k) {
        // 中序遍历得到有序列表 双指针遍历查找给定和
        inorderTraversal(root);
        int i = 0;
        int j = ans.size() - 1;
        while (i < j){
            int sum = ans.get(i) + ans.get(j);
            if (sum == k) return true;
            if (sum > k) j--;
            else i++;
        }
        return false;
    }

    public void inorderTraversal(TreeNode root){
        if (root == null) return;
        inorderTraversal(root.left);
        ans.add(root.val);
        inorderTraversal(root.right);
    }
}







