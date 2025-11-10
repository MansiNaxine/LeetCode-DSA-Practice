class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> currSeq = new ArrayList<>();
        helper(candidates, target, answer, currSeq, 0);
        return answer;
        
    }

    public void helper(int[] candidates, int target, List<List<Integer>> answer, List<Integer> currSeq, int index) {

        //base case
        if(index >= candidates.length) return;

        if(target == 0) {
            answer.add(new ArrayList<>(currSeq));
            return;
        }

        //recursive case
        for(int i = index; i < candidates.length; i++) {
            if(target >= candidates[i]) {
                currSeq.add(candidates[i]);
                helper(candidates, target - candidates[i], answer, currSeq, i);
                currSeq.removeLast();
            }
        }
    }
}