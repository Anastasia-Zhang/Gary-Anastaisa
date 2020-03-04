package common;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/29 13:50
 */
public class Node {

    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}


