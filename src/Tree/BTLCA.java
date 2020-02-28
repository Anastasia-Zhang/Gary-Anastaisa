package Tree;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/18 23:21
 * 二叉树最近公共结点
 */
public class BTLCA {
    public static void main(String[] args) {
        Object[] obj1 = new Object[]{2,4,5,8,9,10,11};
        TreeNode root = TreeNode.create(obj1);
        Object[] obj2 = new Object[]{4};
        TreeNode p = TreeNode.create(obj2);
        Object[] obj3 = new Object[]{11};
        TreeNode  q = TreeNode.create(obj3);
        lowestCommonAncestor(root, p, q);
    }

    // 首先在二叉树中搜索给定的节点 p 和 q，然后找到它们的最近共同祖先。我们可以使用普通的树遍历来搜索这两个节点。
    // 一旦我们达到所需的节点 p 和 q，我们就可以回溯并找到最近的共同祖先。
    // 那么，有以下几个结论：
    //0、若当前节点为null、p、q之一，直接返回当前节点
    //1、若左子树上存在公共节点（返回值非p、q），则函数返回值为左子树返回值，不需再遍历右子树
    //2、若左子树返回null，则函数返回值为右子树返回值
    //3、若左子树、右子树返回值均为非null，则肯定为一个p，一个q，则公共节点为当前节点
    //4、最后一种情况，即左子树返回非null，右子树返回null，则函数返回值为左子树返回值


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 回溯，达到他们的所需结点就回溯寻找他们的最近公共祖先
        if (root == null || root == p || root == q) return root;
        // 递归遍历二叉树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        else if (right == null) return left;
        return root;

    }

}
