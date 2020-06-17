import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Cousre {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return new int[0];

        // 创建邻接表 并初始化
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        // 遍历给定数据 向邻接表增加元素，向入度表添加元素
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        // 先把入度为0的节点加入
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 广度优先遍历
        int count = 0;
        int[] res = new int[numCourses];

        while (!queue.isEmpty()) {
            // 当前入度为0的节点
            Integer head = queue.poll();
            res[count] = head;
            count++;
            // 后继节点
            Set<Integer> successors = adj[head];
            // 遍历后继节点
            for (Integer node : successors) {
                // 后继节点入度 -1 （相当于删掉他的前驱节点）
                inDegree[node]--;
                if (inDegree[node] == 0) queue.offer(node);
            }
        }

        // 如果结果及当中的数量不等于节点的数量，则不能完成课程任务
        if (count == numCourses) return res;
        return new int[0];
    }
}
