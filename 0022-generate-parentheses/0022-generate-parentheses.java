class Solution {
    public List<String> generateParenthesis(int n) {
        // we have to make 1 helper function

        List<String> answer = new ArrayList<>();
        List<Character> currSeq = new ArrayList<>();
        int len = 2 * n;
        helper(answer, len, 0, 0, currSeq);//answer, length, sum and index
        return answer;
    }

    public void helper(List<String> answer, int len, int sum, int index, List<Character> currSeq) {
        //base case
        if(index == len) {
            if(sum == 0) {
                StringBuilder sb = new StringBuilder();
                for(char ch : currSeq) {
                    sb.append(ch);
                }
                answer.add(sb.toString());
            }
            return;
        }

        //recursive case
        //first should be the opening bracket
        if(sum < len/2) {
            currSeq.add('(');
            helper(answer, len, sum + 1, index + 1, currSeq);
            currSeq.removeLast();
        }
        //condition for closing bracket
        if(sum > 0) {
            currSeq.add(')');
            helper(answer, len, sum - 1, index + 1, currSeq);
            currSeq.removeLast();
        } 

    }
}