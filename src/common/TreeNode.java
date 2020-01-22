package common;

import java.util.ArrayList;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/17 15:04
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode(){

    }

    public static TreeNode create(Object[] nums){
        ArrayList<TreeNode> treeArray = new ArrayList<TreeNode>();
        //将一个数组的值依次转换为Node节点
        for (Object num : nums) {
            if (num != null){
                treeArray.add(new TreeNode((int)num));
            }else {
                treeArray.add(null);
            }

        }
        TreeNode treeNode = treeArray.get(0);
        for (int i = 0; i < nums.length / 2; i++) {
            if (treeArray.get(i * 2 + 1) != null) {
                treeArray.get(i).left = treeArray.get(i * 2 + 1);
            }else {
                treeArray.get(i).left = null;
            }
            if (i * 2 + 2 < treeArray.size()) {//避免偶数的时候 下标越界
                if (treeArray.get(i * 2 + 2) != null) {
                    treeArray.get(i).right = treeArray.get(i * 2 + 2);
                }else{
                    treeArray.get(i).right = null;
                }
            }
        }
        return treeNode;
    }

    public static void preorder(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void main(String[] args) {
        Object[] obj = new Object[]{1,2,null,3};
        TreeNode treeNode = create(obj);
        preorder(treeNode);
    }

}
