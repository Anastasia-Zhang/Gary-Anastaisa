import javafx.util.Pair;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        ArrayList<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
//        System.out.println(ladderLength(beginWord,endWord,wordList));
//        ["hit","hot","dot","dog","cog"],
//        ["hit","hot","lot","log","cog"]
//        List<List<String>> result = findLadders(beginWord,endWord,wordList);
//        for (List<String> list : result){
//            for (String word : list){
//                System.out.print(word + " ");
//            }
//            System.out.println();
//        }
        //findLaddersToPath(beginWord, endWord, wordList, new HashMap<>());
    }

    /**
     * 对给定的 wordList 做预处理，找出所有的通用状态。将通用状态记录在字典中，键是通用状态，值是所有具有通用状态的单词。
     * 将包含 beginWord 和 1 的元组放入队列中，1 代表节点的层次。我们需要返回 endWord 的层次也就是从 beginWord 出发的最短距离。
     * 为了防止出现环，使用访问数组记录。
     * 当队列中有元素的时候，取出第一个元素，记为 current_word。
     * 找到 current_word 的所有通用状态，并检查这些通用状态是否存在其它单词的映射，这一步通过检查 all_combo_dict 来实现。
     * 从 all_combo_dict 获得的所有单词，都和 current_word 共有一个通用状态，所以都和 current_word 相连，因此将他们加入到队列中。
     * 对于新获得的所有单词，向队列中加入元素 (word, level + 1) 其中 level 是 current_word 的层次。
     * 最终当你到达期望的单词，对应的层次就是最短变换序列的长度
     **/
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // 获取单词的长度，因为单词只是存在一个字母的变换，因此所有的单词长度一样
        int L = beginWord.length();

        // word 字典：key：所有单词的通用状态，value：通用状态所对应的的单词列表
        HashMap<String, ArrayList<String>> allWordDict = new HashMap<>();

        // 对于wordList预处理，找到单词所有的通用状态,构造单词通用状态词典
        for (String word : wordList) {
            for (int i = 0; i < L; i++) {
                String wordPattern = word.substring(0,i) + "*" + word.substring(i + 1, L);
                ArrayList<String> mapWordList = allWordDict.getOrDefault(wordPattern, new ArrayList<>());// 得到wordPattern 的key值，若无则返回指定默认的key值,省去判空操作
                mapWordList.add(word);
                allWordDict.put(wordPattern,mapWordList);
            }
        }

        // 广度优先遍历，存储广度优先遍历所需要的结点（结点数和层次）
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord,1));
        // 设置访问数组，保证每个结点只访问一次
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord,true);

        // 遍历队列获取邻接结点
        while (!queue.isEmpty()){
            Pair<String, Integer> node = queue.remove();// 取队列第一个操作
            String word = node.getKey();
            int level = node.getValue();
            // 找到这个单词对应所有的通用模式
            for (int i = 0; i < L; i++) {
                String wordPattern = word.substring(0, i) + "*" + word.substring(i + 1, L);
                for (String patternTarget : allWordDict.getOrDefault(wordPattern, new ArrayList<>())){
                    // 判断结束的条件
                    if (patternTarget.equals(endWord)){
                        return level + 1;
                    }
                    if (!visited.getOrDefault(patternTarget,false)){
                        queue.add(new Pair<>(patternTarget, level + 1)); // 将位访问的单词放入队列
                        visited.put(patternTarget, true);
                    }
                }
            }
        }

        // 如果前面没有return 则代表无符合条件的
        return 0;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> res = new ArrayList<>();
        if (wordList.size() == 0) {
            return res;
        }

        // 第 1 步：使用广度优先遍历得到后继结点列表 successors
        // key：字符串，value：广度优先遍历过程中 key 的后继结点列表
        HashMap<String, Set<String>> successors = new HashMap<>();
        boolean found = findLaddersToPath(beginWord, endWord, wordList, successors);
        if (!found) {
            return res;
        }

        // 第 2 步：基于后继结点列表 successors ，使用回溯算法得到所有最短路径列表
        ArrayList<String> path = new ArrayList<>();
        path.add(beginWord);
        findLadders(beginWord, endWord, successors, path, res);
        return res;

    }

    public static boolean findLaddersToPath(String beginWord, String endWord,
                                                       List<String> wordList, HashMap<String, Set<String>> successors) {

        int L = beginWord.length();
        HashMap<String, ArrayList<String>> allWordDict = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < L; i++) {
                String wordPattern = word.substring(0, i) + "*" + word.substring(i + 1, L);
                ArrayList<String> mapWordList = allWordDict.getOrDefault(wordPattern, new ArrayList<>());
                mapWordList.add(word);
                allWordDict.put(wordPattern, mapWordList);
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // 访问当前层遍历过的节点，当前层全部遍历完成之后，再添加到总的 visited 集合里
        Set<String> nextLevelVisited = new HashSet<>();
        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size(); // 一定要赋值，在遍历的时候 queue.size 是动态变化的，要不然会造成死循环
            // 遍历当前层
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                // Set<String> neighbors = getNeighbors(currentWord,allWordDict);
                for (int j = 0; j < L; j++) {
                    String wordPattern = currentWord.substring(0, j) + "*" + currentWord.substring(j + 1, L);
                    // 遍历当前单词的所有可能的临接节点
                    for (String patternTarget : allWordDict.getOrDefault(wordPattern, new ArrayList<>())) {
                        // 如果他的临界节点没有遍历过
                        if (!visited.contains(patternTarget)) {
                            if (patternTarget.equals(endWord)) {
                                found = true;
                            }
                            nextLevelVisited.add(patternTarget);
                            queue.offer(patternTarget);
                            // 更新临接表
                            Set<String> set = successors.getOrDefault(currentWord, new HashSet<>());
                            set.add(patternTarget);
                            successors.put(currentWord, set);
                        }
                    }
                }
            }
            // 该层是否遍历了
            if (found) break;
            visited.addAll(nextLevelVisited);
            nextLevelVisited.clear();
        }
        return found;
    }

    public static void findLadders(String beginWord, String endWord,
                                      HashMap<String, Set<String>> successors,
                                      List<String> path, List<List<String>> res) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (!successors.containsKey(beginWord)) return;
        for (String word : successors.get(beginWord)) {
            path.add(word);
            findLadders(word, endWord, successors, path, res);
            path.remove(word);
        }

    }
}
