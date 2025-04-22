class Solution {

    List<String> answer = new ArrayList<>();
    List<Character> currentSeq = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        
        recursion(2*n, 0, 0);
        return answer;
    }

    public void recursion(int length, int sum, int index) {
        //base case
        if(index == length) {
            if(sum == 0) {
                StringBuilder sb = new StringBuilder("");
                for(int i = 0; i < currentSeq.size(); i++) {
                    sb.append(currentSeq.get(i));
                }
                answer.add(sb.toString());
            }

            return;
        }

        //recursive case
        //for adding '(' paranthesis
        if(sum <= length/2) {
            currentSeq.add('(');
            recursion(length, sum+1, index+1);
            currentSeq.remove(currentSeq.size() - 1);
        }

        //for adding ')' paranthesis
        if(sum > 0) {
            currentSeq.add(')');
            recursion(length, sum-1, index+1);
            currentSeq.remove(currentSeq.size() - 1);
        }
    }
}