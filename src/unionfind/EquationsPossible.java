package unionfind;

public class EquationsPossible {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);
        for (String equation : equations) {
            char[] eq = equation.toCharArray();
            // 遍历等式的式子，如果是连通的，将其加入一个连通分量当中
            if (eq[1] == '=') {
                int x = eq[0] - 'a'; // 转换为数字
                int y = eq[3] - 'a'; // 转换为数字
                unionFind.union(x, y);
            }
        }

        // 遍历不等式 看否存在不等式还在连通分量当中，出现矛盾return false
        for (String equation : equations) {
            char[] eq = equation.toCharArray();
            // 遍历等式的式子，如果是连通的，将其加入一个连通分量当中
            if (eq[1] == '!') {
                int x = eq[0] - 'a'; // 转换为数字
                int y = eq[3] - 'a'; // 转换为数字
                if (unionFind.isConnected(x, y)) return false;
            }
        }
        return true;
    }

    private class UnionFind{
        private int[] parent;

        public UnionFind(int n){
            parent = new int[n];
            // 初始值为 -1
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        // 找到根节点
        public int findRoot(int x){
            while (x != parent[x]) {
                // 隔代压缩，树的形状无所谓，只关注其连通性
                // 将当前节点直接指向父节点
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        // 合并连通的两个节点
        public void union(int x, int y) {
            int rootX = findRoot(x);
            int rootY = findRoot(y);
            parent[rootX] = rootY;
        }

        // 检测两个节点是否连通 其父节点是否相等
        public boolean isConnected(int x, int y) {
            return findRoot(x) == findRoot(y);
        }
    }
}
