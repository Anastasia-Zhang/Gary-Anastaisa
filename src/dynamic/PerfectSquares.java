package dynamic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/29 19:48
 */
public class PerfectSquares {
    private class Node{
        int val; // 值
        int step; // 深度
        public Node(int val, int step){
            this.val = val;
            this.step = step;
        }
    }

    //  广度优先遍历， 优先遍历到0 的就是最短路径，返回深度即可
    public int numSquares(int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Node> queue = new LinkedList<>();
        visited[n] = true;
        queue.add(new Node(n, 1));
        while (!queue.isEmpty()){
            int val = queue.peek().val;
            int step = queue.peek().step;
            queue.remove();
            // 开始每一层的遍历
            for (int i = 1;; i++){
                int nextVal = val - i * i; // 每个数都减去 i 的平方
                if (nextVal < 0) break;  // 若减少到零，则词层已经循环完
                if (nextVal == 0) return step; // 只要最优先到0 就代表一个最短路径
                if (!visited[nextVal]){ // 如果没有访问过，防止增加已经访问过的结点，已经访问过的不用加入
                    queue.add(new Node(nextVal, step + 1));
                    visited[nextVal] = true;
                }
            }
        }
        return -1;
    }
}
