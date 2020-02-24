package offer;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/22 17:32
 */
public class 面试题7重建二叉树 {
    public static void main(String[] args) {
        int[] preorder = new int[]{1,2,4,7,3,5,6,8};
        int[] inorder = new int[]{4,7,2,1,5,3,8,6};
        buildTree(preorder,inorder);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0){
            return null;
        }
        return constractTree(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
    }

    public static TreeNode constractTree(int preorderStart, int preorderEnd,
                                  int inorderStart, int inorderEnd,
                                  int[] preorder, int[] inorder){
        // 前序遍历的第一个数是根节点的值
        TreeNode root = new TreeNode(preorder[preorderStart]);
        root.left = null;
        root.right = null;
        if (preorderStart == preorderEnd){
            return root;
        }
        // 去中序遍历数组中寻找根节点的值所在的索引
        int rootIndex = inorderStart;
        while (rootIndex < inorderEnd && inorder[rootIndex] != preorder[preorderStart]){
            rootIndex++;
        }
        // 计算该节点的前序和中序的序列索引
        int leftLength = rootIndex - inorderStart;
        int rootLeftEnd = preorderStart + leftLength;
        // 如果该根节点的左子树结点个数大于0
        if (leftLength > 0)
            root.left = constractTree(preorderStart + 1, rootLeftEnd, inorderStart, rootIndex - 1,preorder, inorder);
        int rightLength = inorderEnd - rootIndex;
        if (rightLength > 0)
            root.right = constractTree(rootLeftEnd + 1, preorderEnd, rootIndex + 1, inorderEnd, preorder, inorder);
        return root;

    }
}
