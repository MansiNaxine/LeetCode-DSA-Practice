class Solution {

    List<String> answer = new ArrayList<>();
    List<Character> currentSeq = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        int length = 2*n;

        recursion(0,0,length);

        return answer;
    }

    public void recursion(int start, int sum, int L) {

        //base case
        if(start == L) {
            if(sum == 0) {
                StringBuilder str = new StringBuilder("");
                for(int i=0; i<currentSeq.size(); i++) {
                    str.append(currentSeq.get(i));
                }
                answer.add(str.toString());
            }
           return; 
        }
        
        //recursive case
        //1st for open bracket
        if(sum < L/2) {
            currentSeq.add('(');
            recursion(start+1, sum+1, L);
            currentSeq.remove(currentSeq.size() - 1);
        }

        //2nd for closing bracket
        if(sum > 0) {
            currentSeq.add(')');
            recursion(start+1, sum-1, L);
            currentSeq.remove(currentSeq.size() - 1);
        }

    }
}