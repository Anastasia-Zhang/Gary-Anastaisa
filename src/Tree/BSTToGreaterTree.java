package Tree;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/17 11:10
 */
public class BSTToGreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        // 中序遍历，先遍历右节点累加结点的值 右 根 左
        // 根结点的数是：自身 + 右子树的值
        // 根的左子树是：自身 + 根结点的值
        if (root != null){
            // 遍历右子树
            convertBST(root.right);
            // 遍历顶点
            // 累加右节点的值
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;

    }
}
