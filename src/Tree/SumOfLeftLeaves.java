package Tree;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/15 10:41
 */
public class SumOfLeftLeaves {
    public static void main(String[] args) {
        Object[] obj = new Object[]{1,2,3,4,5};
        TreeNode treeNode = TreeNode.create(obj);
        sumOfLeftLeaves(treeNode);
    }
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        // 如果当前结点的左孩子是左叶子结点
        if (root.left != null && root.left.right == null && root.left.left == null)
            return sumOfLeftLeaves(root.right) + root.left.val; // 返回当前结点的右子树的递归结点和 + 当前结点的左叶子结点的值
        return sumOfLeftLeaves(root.right) + sumOfLeftLeaves(root.left); // 递归的进行左右子树的调用，左右子树的左叶子之和

    }

    // 所有节点的和
    public int sumOfNodes(TreeNode root){
        if (root == null) return 0;
        return sumOfNodes(root.left) + sumOfNodes(root.right) + root.val;
    }

    // 所有的叶子结点之和
    public int sumOfLeaves(TreeNode root){
        if (root == null) return 0;
        // 如果是叶子结点
        int leave = 0;
        if (root.left == null && root.right == null) {
            leave = root.val;
        }

        return sumOfNodes(root.left) + sumOfNodes(root.right) + leave;
    }

    // 通过 flag 标记是否为左叶子结点
    // 先序遍历求所有左叶子节点值之和
    // sumOfLeftLeavesHelper(root, false);
    public int sumOfLeftLeavesHelper(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        int leave = 0;
        // 左叶子节点
        if (flag && root.left == null && root.right == null) {
            leave = root.val;
        }
        int left = sumOfLeftLeavesHelper(root.left, true); // 如果调用左叶子结点，则flag 为 true
        int right = sumOfLeftLeavesHelper(root.right, false);
        return left + right + leave;
    }


}
