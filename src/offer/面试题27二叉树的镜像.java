package offer;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/27 20:07
 */
public class 面试题27二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        // 暂存左节点
        TreeNode left = root.left;
        // 将树的右节点换到树的左节点上
        root.left = mirrorTree(root.right);
        // 将原来树的左节点放在数的右节点上
        root.right = mirrorTree(left);
        return root;
    }
}
