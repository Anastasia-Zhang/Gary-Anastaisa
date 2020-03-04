package Tree;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/1 22:42
 */
public class Trie {
    private class Node{
        Node[] childs = new Node[26];// 保存数字
        boolean isLeaf; // 是否为叶子结点
    }

    private Node root = new Node();

    public Trie() {

    }

    public void insert(String word){
        insert(word, root);
    }


    public void insert(String word, Node root){
        if (root == null) return;
        // 单词插入完毕
        if (word.length() == 0) {
            root.isLeaf = true;
            return;
        }
        // 取第一个字符的下标
        int index = indexForChar(word.charAt(0));
        // 如果节点为空，则新建结点
        if (root.childs[index] == null){
            root.childs[index] = new Node();
        }
        insert(word.substring(1), root.childs[index]);
    }

    public boolean search(String word){
        return search(word, root);
    }

    public boolean search(String word, Node root){
        // 结点都搜素完毕，必然是没有找到
        if (root == null) return false;
        // 如果word都搜索完毕，则看这个结点是否是根节点
        if (word.length() == 0) return root.isLeaf;
        int index =  indexForChar(word.charAt(0));
        return search(word.substring(1), root.childs[index]);
    }

    public boolean startWith(String prefix){
        return startWith(prefix, root);
    }

    public boolean startWith(String prefix, Node root){
        if (root == null) return false;
        // 前缀能完全找完，肯定是可以的
        if (prefix.length() == 0) return true;
        int index = indexForChar(prefix.charAt(0));
        return startWith(prefix.substring(1), root.childs[index]);
    }


    public int indexForChar(char ch){
        int res = ch - 'a';
        return res;
    }


}
