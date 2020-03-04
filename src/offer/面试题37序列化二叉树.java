package offer;

import common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/29 19:21
 */
public class 面试题37序列化二叉树 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return codeTree(root, new StringBuffer()).toString();
    }

    public StringBuffer codeTree(TreeNode root, StringBuffer sb){
        // 前序遍历
        if (root == null){
            sb.append("null,");
            return sb;
        } else {
            // String.valueOf(root.val);
            sb.append(root.val);
            sb.append(",");
            codeTree(root.left, sb);
            codeTree(root.right, sb);
        }
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(nodes));
        return deCodeTree(list);

    }

    public TreeNode deCodeTree(List<String> list){
        TreeNode root;
        if (list.get(0).equals("null")){
            list.remove(0);
            return null;
        } else {
            // 新建一个结点
            root = new TreeNode(Integer.parseInt(list.get(0)));
            list.remove(0);
            root.left = deCodeTree(list);
            root.right = deCodeTree(list);
        }
        return root;
    }
}
