class Solution {
    List<List<String>> answer = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    String b ;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        //Optimize Approach
        //DFS traversal
        return ladderLength(beginWord, endWord, wordList);

        //Will Give TLE
        // return bruteForceApproach(beginWord, endWord, wordList);
    }

    public List<List<String>> ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set = new HashSet<>();
        b = beginWord;
        int n = wordList.size();
        set.add(beginWord);
        for(String str : wordList) {
            set.add(str);
        }
        Queue<Pair> que = new LinkedList<>();
        Pair p = new Pair(beginWord, 1);
        set.remove(beginWord);
        que.add(p);
        map.put(beginWord, 1);

        while(!que.isEmpty()) {
            Pair top = que.remove();
            String currWord = top.word;
            int currStep = top.step;
            int len = currWord.length();

            if(currWord.equals(endWord)) break;
            else {
                for(int i = 0; i < len; i++) {
                    String updateTop = currWord;
                    char ch = updateTop.charAt(i);
                    for(char j = 'a'; j <= 'z'; j++) {
                        String newWord = updateTop.substring(0, i) + j + updateTop.substring(i + 1);
                        if(set.contains(newWord)) {
                            set.remove(newWord);
                            Pair innerP = new Pair(newWord, currStep + 1);
                            que.add(innerP);
                            map.put(newWord, currStep + 1);
                        }
                    }
                }
            }
        }

        if(map.containsKey(endWord)) {
            List<String> currList = new ArrayList<>();
            currList.add(endWord);
            dfsTraversal(endWord, currList);
        }

        return answer;
    }

    public void dfsTraversal(String currWord, List<String> currList) {

        //base case
        if (currWord.equals(b)) {
            List<String> reverList = new ArrayList<>(currList);
            Collections.reverse(reverList);
            answer.add(new ArrayList<>(reverList));
            return;
        }
        //recursive case
        String innerNewWord = currWord;
        int step = map.get(innerNewWord);
        int len = innerNewWord.length();
        for (int i = 0; i < len; i++) {
            String updateTop = innerNewWord;
            char ch = updateTop.charAt(i);
            for (char j = 'a'; j <= 'z'; j++) {
                String newWord = updateTop.substring(0, i) + j + updateTop.substring(i + 1);
                if (map.containsKey(newWord) && map.get(newWord) == step - 1) {
                    currList.add(newWord);
                    dfsTraversal(newWord, currList);
                    currList.removeLast();
                }
            }
        }
    }

    public List<List<String>> bruteForceApproach(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> answer = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        curr.add(beginWord);
        Queue<List<String>> que = new LinkedList<>();
        que.add(curr);
        Set<String> set = new HashSet<>(wordList);
        List<String> deleteWords = new ArrayList<>();

        while(!que.isEmpty()) {
            int queSize = que.size();
            while(!deleteWords.isEmpty()) {
                String lastWord = deleteWords.getLast();
                set.remove(lastWord);
                deleteWords.removeLast();
            }

            for(int k = 0 ; k < queSize; k++) {
                List<String> topList = que.remove();
                String topWord = topList.get(topList.size() - 1);
                int len = topWord.length();


                if(topWord.equals(endWord)) answer.add(new ArrayList<>(topList));

                for(int i = 0 ; i < len; i++) {
                    String updateWord = topWord;
                    for(char j = 'a'; j <= 'z'; j++) {
                        String newWord = updateWord.substring(0, i) + j + updateWord.substring(i + 1);
                        if(set.contains(newWord)) {
                            deleteWords.add(newWord);
                            List<String> innerList = new ArrayList<>(topList);
                            innerList.add(newWord);
                            que.add(innerList);
                        }
                    }
                }
            }


        }
        return answer;
    }

}

class Pair {
    String word;
    int step;

    Pair(String word, int step) {
        this.word = word;
        this.step = step;
    }
}