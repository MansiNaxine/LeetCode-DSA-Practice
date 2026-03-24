class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        helper(answer, 2*n, sb, 0, 0);
        return answer;
    }

    public void helper(List<String> answer, int n, StringBuilder sb, int index, int sum) {
        //base case
        if(index >= n) {
            if(sum == 0){
                answer.add(sb.toString());
            }
            return;
        }

        //recursive case
        if(sum < n/2) {
            sb.append('(');
            helper(answer, n, sb, index + 1, sum + 1);
            sb.deleteCharAt(sb.length()-1);
        }

        if(sum > 0) {
            sb.append(')');
            helper(answer, n, sb, index + 1, sum - 1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}