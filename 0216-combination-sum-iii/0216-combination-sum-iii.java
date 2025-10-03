class Solution {

    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> currSeq = new ArrayList<>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        helper(k, n, 1);
        return answer;
    }

    public void helper(int k, int n, int index) {

        //base cases
        //1.
        if(n == 0 && currSeq.size() == k) {
            answer.add(new ArrayList<>(currSeq));
            return;
        }

        //2.
        if(index > 9) return;

        if(index <= n) {
            currSeq.add(index);
            helper(k, n - index, index + 1);
            currSeq.removeLast();
            helper(k, n , index + 1);
        }
    }
}