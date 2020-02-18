package Tree;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/16 13:28
 */
public class FindSecondMin {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) return -1;
        // 一定时 0 或者 两个节点
        int rightVal = root.right.val;
        int leftVal = root.left.val;
        // 如果左节点和根节点相等，则去左子树寻找最小值
        if (rightVal == root.val) rightVal = findSecondMinimumValue(root.right);
        if (leftVal == root.val) leftVal = findSecondMinimumValue(root.left);
        // 如果都存在第二小的结点，则返回最小的那个结点
        if (rightVal != -1 && leftVal != -1) return Math.min(rightVal, leftVal);
        if (leftVal != -1) return leftVal;
        return rightVal;

    }
}
