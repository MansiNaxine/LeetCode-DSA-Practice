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
            if(isPalindrome(s.substring(index, i + 1))) {
                currSeq.add(s.substring(index, i + 1));
                helper(s, answer, currSeq, i + 1);
                currSeq.removeLast();
            }
        }

    }

    public boolean isPalindrome(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }

        return true;
    }
}