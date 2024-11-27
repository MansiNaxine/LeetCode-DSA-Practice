class Solution {

    List<String> answer = new ArrayList<>();
    List<Character> currSeq = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        recursion(0, 0, 2*n);
        return answer;
    }

    public void recursion(int index, int sum, int length){

        //base case
        if(index == length){

            if(sum == 0){

                StringBuilder sb= new StringBuilder();
                for(int i=0; i< currSeq.size(); i++){
                    sb.append(currSeq.get(i));
                }
                answer.add(sb.toString());
            }
                return;
            
            
        }
        //recursive case
        //first for open paranthesis
        if(sum < length/2){
            currSeq.add('(');
            recursion(index+1, sum+1, length);
            currSeq.remove(currSeq.size()-1);
        }

        //Second for close paranthesis
        if(sum > 0){
            currSeq.add(')');
            recursion(index+1, sum-1, length);
            currSeq.remove(currSeq.size()-1);
         }
        
    }
}