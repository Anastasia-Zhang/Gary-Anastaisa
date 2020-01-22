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
       // System.out.println(ladderLength(beginWord,endWord,wordList));
        //["hit","hot","dot","dog","cog"],
        //["hit","hot","lot","log","cog"]
        List<List<String>> result = findLadders(beginWord,endWord,wordList);
        for (List<String> list : result){
            for (String word : list){
                System.out.print(word + " ");
            }
            System.out.println();
        }
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


    // 死循环
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if(!wordList.contains(endWord)){
            return result;
        }
        int L = beginWord.length();
        HashMap<String, ArrayList<String>> allWordDict = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < L; i++) {
                String wordPattern = word.substring(0,i) + "*" + word.substring(i + 1, L);
                ArrayList<String> mapWordList = allWordDict.getOrDefault(wordPattern, new ArrayList<>());// 得到wordPattern 的key值，若无则返回指定默认的key值,省去判空操作
                mapWordList.add(word);
                allWordDict.put(wordPattern,mapWordList);
            }
        }
        // 广度优先遍历，存储广度优先遍历每一层遍历所需要最短的路径
        Queue<List<String>> queue = new LinkedList<>();
        List<String> beginPath = new ArrayList<>();
        beginPath.add(beginWord);
        queue.add(beginPath);
        // 用set保存历史上保存过的结点
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean isFound = false; // 判断新添加进队列的每一层路径是否为最短路径

        // 遍历队列
        while (!queue.isEmpty() && !isFound){
            // 要判断的是当前节点在之前层有没有出现过，当前层正在遍历的节点先加到 levelVisited 中。
            Set<String> levelVisited = new HashSet<>(); // 保存同一个层次下的访问的单词
            for (int j = 0;j < queue.size();j ++) {
                List<String> path = queue.remove(); // 取出队头元素
                //System.out.println(path.toString());
                String word = path.get(path.size() - 1); // 取出路径的最后一个单词
                Set<String> neighbors = getNeighbors(word,allWordDict);
                // 找到这个单词对应所有的通用模式
//                for (int i = 0; i < L; i++) {
//                    // 得到这几单词的邻接结点
//                    String wordPattern = word.substring(0, i) + "*" + word.substring(i + 1, L);
                    //for (String patternTarget : allWordDict.getOrDefault(wordPattern, new ArrayList<>())) {
                      for (String patternTarget : neighbors)
                        // 只考虑之前没有出现过的单词
                        if (!visited.contains(patternTarget)) {
                            // 如果到达结束状态

                            if (patternTarget.equals(endWord)){
                                path.add(patternTarget);
                                isFound = true;
                                result.add(new ArrayList<>(path));
                                path.remove(path.size() - 1);
                            }
                            // 加入当前单词
                            path.add(patternTarget);
                            queue.add(new ArrayList<>(path));
                            path.remove(path.size() - 1); //下次循环做准备
                            levelVisited.add(patternTarget);
                        }
                    //}
//                }
            }
            visited.addAll(levelVisited);
        }
        return result;
    }

    private static Set<String> getNeighbors(String word, HashMap<String, ArrayList<String>> allWordDict){
        Set<String> res = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            // 得到这几单词的邻接结点
            String wordPattern = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
            ArrayList<String> neighborList = allWordDict.getOrDefault(wordPattern, new ArrayList<>());
            res.addAll(neighborList);
        }
        res.remove(word);
        for (String path : res){
            System.out.print(path + " ");
        }
        return res;
    }
}
