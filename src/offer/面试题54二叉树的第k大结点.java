package offer;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/5 21:24
 */
public class 面试题54二叉树的第k大结点 {
    // 中序遍历，右 根 左 就是逆序的
    // 记录当前的答案和遍历的次数
    int ans = 0, count = 0;
    public int kthLargest(TreeNode root, int k) {
        traverse(root, k);
        return ans;
    }

    public void traverse(TreeNode root, int k){
        if (root.right != null) traverse(root.right, k);
        // 遍历到第 k 个结点
        if (++count == k) {
            ans = root.val;
            return;
        }
        if (root.left != null) traverse(root.left, k);
    }

}
