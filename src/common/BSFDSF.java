package common;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;



public class BSFDSF {

    String[] nodeList;
    int[][] edegs;
    int nodeNum;

    public BSFDSF(String[] nodeList, int[][] edegs, int nodeNum) {
        this.nodeList = nodeList;
        this.edegs = edegs;
        this.nodeNum = nodeNum;
    }

    private void print(){
        for(int i = 0; i < nodeNum;i ++){
            for(int j = 0; j < nodeNum; j ++){
                System.out.print(edegs[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void depthFirstSearch(int startNode){
        int maxDepth = 0;
        boolean[] visited = new boolean[nodeNum];
        Stack<Integer> stack = new Stack<>();
        visited[startNode] = true;
        stack.push(startNode);
        int n;
        int i;
        while(!stack.isEmpty()){
            n = stack.peek();	//取栈顶元素
            for(i = 0;i < nodeNum ; i++){ //遍历栈顶元素所在的边,将栈顶的邻接结点入栈
                if(edegs[n][i] == 1 &&  !visited[i]){
                    visited[i] = true;
                    stack.push(i);	//入栈
                    break;
                }
            }
            if(i == nodeNum){
                stack.pop();
            }
            maxDepth = Math.max(maxDepth, stack.size());
        }
        System.out.println(maxDepth);
    }


    private void broadFirstSearch(int startNode){
        boolean[] visited = new boolean[nodeNum];
        int u;
        Queue<Integer> queue = new LinkedList<>();
        visited[startNode] = true;
        queue.add(startNode);
        while ( !queue.isEmpty()){
            u = queue.remove();
            for(int i = 0; i < nodeNum;i ++){
                if( !visited[i] && edegs[u][i] == 1){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    //私有函数，深度优先遍历
    private void depthFirstSearch(boolean[] isVisited, int i) {

        //置该结点为已访问
        isVisited[i] = true;

        for(i = 0;i < nodeNum ; i++){
            if (!isVisited[i]) {
                depthFirstSearch(isVisited, i);
            }
        }

    }

    //对外公开函数，深度优先遍历，与其同名私有函数属于方法重载
    public void depthFirstSearch() {
        boolean[] visited = new boolean[nodeNum];
        for (int i = 0; i < nodeNum; i++) {
            //因为对于非连通图来说，并不是通过一个结点就一定可以遍历所有结点的。
            if (!visited[i]) {
                depthFirstSearch(visited, i);
            }
        }
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = Integer.parseInt(sc.nextLine());
        while (caseNum-- > 0){
            String[] firstLine = sc.nextLine().split(" ");
            int nodeNum = Integer.parseInt(firstLine[0]);
            String startNode = firstLine[1];
            String[] nodeList = sc.nextLine().split(" ");
            int[][] edegs = new int[nodeNum][nodeNum];
            for (int i = 0; i < nodeNum; i ++){
                String[] inputLine = sc.nextLine().split(" ");
                for(int j = 0; j < nodeNum;j ++){
                    edegs[i][j] = Integer.parseInt(inputLine[j + 1]);
                }
            }
            BSFDSF bsfdsf = new BSFDSF(nodeList, edegs, nodeNum);
            int startIndex = 0;
            for(int i = 0; i < nodeList.length; i ++){
                if(nodeList[i].equals(startNode)){
                    startIndex = i;
                    break;
                }
            }
            // bsfdsf.print();
            bsfdsf.depthFirstSearch(startIndex);

        }
    }
}
