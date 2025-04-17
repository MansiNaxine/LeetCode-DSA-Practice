class Solution {
    public String reverseWords(String s) {
        String answer = "";
        String[] words = s.split(" ");

        for(String word : words) {
            String reveWord = reverse(word);
           answer += reveWord + " ";
        }

        return answer.trim();
        
    }

    public String reverse(String word) {
        int len = word.length();
        String answer = "";
        for(int i = len - 1; i >= 0; i--) {
            answer += word.charAt(i);
        }

        return answer;

    }
}