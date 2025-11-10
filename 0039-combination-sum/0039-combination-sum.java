class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> currSeq = new ArrayList<>();
        Arrays.sort(candidates);
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
            if(target >= candidates[index]) {
                currSeq.add(candidates[index]);
                helper(candidates, target - candidates[index], answer, currSeq, index);
                currSeq.removeLast();
                helper(candidates, target, answer, currSeq, index + 1);
            }
    }
}