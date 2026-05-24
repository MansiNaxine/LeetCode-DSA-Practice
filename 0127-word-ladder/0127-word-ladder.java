class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set = new HashSet<>();

        int n = wordList.size();
        set.add(beginWord);
        for(String str : wordList) {
            set.add(str);
        }
        Queue<Pair> que = new LinkedList<>();
        Pair p = new Pair(beginWord, 1);
        set.remove(beginWord);
        que.add(p);

        while(!que.isEmpty()) {
            Pair top = que.remove();
            String currWord = top.word;
            int currStep = top.step; 
            int len = currWord.length();

            if(currWord.equals(endWord)) return currStep;
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
                        }
                    }
                }
            }
        }
        return 0;
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