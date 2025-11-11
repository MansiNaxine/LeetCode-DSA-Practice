class Solution {
    public List<String> generateParenthesis(int n) {
        // we have to make 1 helper function

        List<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int len = 2 * n;
        helper(answer, len, 0, 0, sb);//answer, length, sum and index
        return answer;
    }

    public void helper(List<String> answer, int len, int sum, int index, StringBuilder result) {
        //base case
        if(index == len) {
            if(sum == 0) {
                answer.add(result.toString());
            }
            return;
        }

        //recursive case
        //first should be the opening bracket
        if(sum < len/2) {
            result.append('(');
            helper(answer, len, sum + 1, index + 1, result);
            result.deleteCharAt(result.length() -  1);
        }
        //condition for closing bracket
        if(sum > 0) {
            result.append(')');
            helper(answer, len, sum - 1, index + 1, result);
            result.deleteCharAt(result.length() -  1);
        } 

    }
}