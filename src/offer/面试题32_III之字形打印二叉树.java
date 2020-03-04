package offer;

import common.TreeNode;

import java.util.*;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/29 0:04
 */
public class 面试题32_III之字形打印二叉树 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1; // 记录层次数
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            // 加入循，遍历队列每一层的层数
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            count++;
            if ((count & 1) == 0) list.add(level);
            else {
                Collections.reverse(level);
                list.add(level);
            }

        }
        return list;
    }
}
