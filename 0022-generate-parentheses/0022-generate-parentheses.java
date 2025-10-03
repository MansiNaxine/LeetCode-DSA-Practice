class Solution {
    List<String> answer = new ArrayList<>();
    StringBuilder str = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        int len = 2 * n;
        generateParenthesisHelper(len, 0, 0);
        return answer;
    }

    public void generateParenthesisHelper(int length, int index, int sum) {

        //base case
        if(index == length) {
            if(sum == 0) {
                answer.add(str.toString());
                return;
            }
            return;
        }
        
        //recursive case
        if(sum <= length/2) {
            str.append('(');
            generateParenthesisHelper(length, index + 1, sum + 1);
            str.deleteCharAt(str.length() - 1);
        }

        if(sum > 0) {
            str.append(')');
            generateParenthesisHelper(length, index + 1, sum - 1);
            str.deleteCharAt(str.length() - 1);
        }
    }
}