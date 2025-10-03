class Solution {

    List<String> answer = new ArrayList<>();
    List<Character> currSeq = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        int sum = 0;
        int len = 2*n;
        recursion(sum, len, 0);
        return answer;
        
    }

    public void recursion(int sum, int len, int i) {

        //base case
        if(i == len) {
            if(sum == 0) {
                StringBuilder sb = new StringBuilder("");
                for(int k = 0; k < currSeq.size(); k++) {
                    sb.append(currSeq.get(k));
                }

                answer.add(sb.toString());
            }

            return;
        }

        //recursive case
        if(sum < len/2) {
            currSeq.add('(');
            recursion(sum+1, len, i+1);
            currSeq.remove(currSeq.size() - 1);
        }

        if(sum > 0) {
            currSeq.add(')');
            recursion(sum-1, len, i+1);
            currSeq.remove(currSeq.size() - 1);
        }


    }
}