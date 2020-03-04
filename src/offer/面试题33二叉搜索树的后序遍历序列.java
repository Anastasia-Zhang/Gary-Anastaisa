package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/29 10:39
 */
// 此题和面试题 7 一个思路，都是根据遍历
// 此方法的思路是：先找到根节点，基于根节点把整个数组拆分成左子树和右子树对应的序列，接下来递归的处理这连个序列
public class 面试题33二叉搜索树的后序遍历序列 {


    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) return true;
        return verifyPostorder(postorder, postorder.length);
    }


    public boolean verifyPostorder(int[] postorder, int length){
        if (length <= 0) return true;
        // 遍历序列找到左子树的范围
        int i = 0;
        // System.out.println(length);
        int rootVal = postorder[length - 1];
        while (i < length - 1){
            if (postorder[i] > rootVal) break;
            i++;
        }
        // 遍历序列找到右子树的范围,其实剩下的就是右子树的范围，这里还要再遍历序列看右子树的序列是否合法
        int j = i;
        while (j < length - 1){
            if (postorder[j] < rootVal) return false;
            j++;
        }

        return verifyPostorder(postorder, i) && verifyPostorder(postorder, length - 1 - i);
    }
}
