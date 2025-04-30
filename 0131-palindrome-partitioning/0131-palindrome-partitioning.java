class Solution {
    List<List<String>> answer = new ArrayList<>();
    List<String> currSeq = new ArrayList<>();

    public List<List<String>> partition(String s) {
        
        recursion(s, 0);
        return answer;
    }

    public void recursion(String str, int index) {
        //base case
        if(index == str.length()) {

            answer.add(new ArrayList<>(currSeq));
            return;
        }

        //recursive case
        for(int i = index; i < str.length(); i++) {
            if(isPalindrome(str.substring(index, i + 1))) {
                currSeq.add(str.substring(index, i + 1));
                recursion(str, i + 1);
                currSeq.remove(currSeq.size() - 1);
            }

        }
    }

    public boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}