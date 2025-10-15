import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> answer = new ArrayList<>();
        List<String> currSeq = new ArrayList<>();

        helper(s, answer, currSeq, 0);
        return answer;
        
    }


    public void helper(String s, List<List<String>> answer, List<String> currSeq, int index) {

        //base case
        if(index == s.length()) {
            answer.add(new ArrayList<>(currSeq));
            return;
        }

        //recursive case
        for(int i = index; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s.substring(index, i + 1));
            String str = s.substring(index, i + 1);
            if(str.equals(sb.reverse().toString()))  {
                currSeq.add(str);
                helper(s, answer, currSeq, i + 1);
                currSeq.removeLast();
            }   
            
        }
    }

}