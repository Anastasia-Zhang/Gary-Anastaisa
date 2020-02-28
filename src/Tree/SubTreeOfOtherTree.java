package Tree;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/14 22:20
 */
// 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
// s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树
    // 包含一个结点和他所有的子孙

public class SubTreeOfOtherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        // 这一层递归主要数遍历目标树s，从左子树和右子树遍历得到每一个可能开始的结点
        // 从每一个结点调用 isSubTreeWithRoot 来判断当前结点开始的子树是否和给定的树t结构一样
        // 只要左右子树有一个满足就可以
        return isSubTreeWithRoot(s, t) || isSubtree(s.right,t) || isSubtree(s.left, t);

    }

    public boolean isSubTreeWithRoot(TreeNode s, TreeNode t){
        // 这一层判断某个开始的左右子树是否是一样的数
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        // 其左右子树必须完全相同
        // 同时遍历两棵树的左右子树
        return isSubTreeWithRoot(s.left, t.left) && isSubTreeWithRoot(t.right, s.right);
    }
}
