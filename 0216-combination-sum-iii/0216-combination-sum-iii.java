class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> currSeq= new ArrayList<>();
        helper(k, n, answer, currSeq, 1);
        return answer;
    }

    public void helper(int k , int n, List<List<Integer>> answer, List<Integer> currSeq, int index ) {

        //base case
        if(n == 0) {
            if(currSeq.size() == k) {
                answer.add(new ArrayList<>(currSeq));
            }
            return;
        }

        if(index > 9) return;

        //recursive case
        for(int i = index; i <= 9; i++) {
            if(n >= i) {
                currSeq.add(i);
                helper(k, n-i, answer, currSeq, i + 1);
                currSeq.removeLast();
            }
        }

    }
}