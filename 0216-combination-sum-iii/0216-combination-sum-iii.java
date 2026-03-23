class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> answer =  new ArrayList<>();
        helper(answer, k, n, new ArrayList<>(), 1, n);
        return answer;
    }

    public void helper(List<List<Integer>> answer, int k, int n, List<Integer> currSeq, int index, int sum) {
        //base case
        if(index > n) {
            if(sum == 0 && currSeq.size() == k) {
                answer.add(new ArrayList<>(currSeq));
            }
            return;
        }
        //recursive case
        if(sum >= index && index <= 9) {
            currSeq.add(index);
            helper(answer, k, n, currSeq, index + 1, sum - index);
            currSeq.removeLast();
        }
        helper(answer, k, n, currSeq, index + 1, sum);
    }
}