package Tree;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/14 21:20
 */
public class MergeTree {
    // 前序遍历，遍历的过程中，递归的对树的结点进行合并
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null) return t2; // 如果当前树为空，则返回另一颗数作为结果
        if (t2 == null) return t1;
        t1.val += t2.val;
        t1.right = mergeTrees(t1.right, t2.right);
        t1.left = mergeTrees(t1.left, t2.left);
        return t1;
    }
}
