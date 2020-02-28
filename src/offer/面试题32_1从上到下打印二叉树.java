package offer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/28 23:32
 */
public class 面试题32_1从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue =  new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
