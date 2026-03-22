class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        int n = candidates.length;
        List<List<Integer>> answer = new ArrayList<>();
        helper(candidates, n, target, 0, answer, new ArrayList<>());
        return answer;
    }

    public void helper(int[] candidates, int n, int target, int index, List<List<Integer>> answer, List<Integer> currSeq) {
        //Base case
        if(target == 0) {
            answer.add(new ArrayList<>(currSeq));
            return;
        }

        if(index >= n) return;

        //Recursive case
        if(target >= candidates[index]) {
            currSeq.add(candidates[index]);
            helper(candidates, n, target - candidates[index], index, answer, currSeq);
            currSeq.removeLast();
        }
        helper(candidates, n, target, index + 1, answer, currSeq);
    }
}