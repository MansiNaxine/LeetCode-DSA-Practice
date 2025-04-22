class Solution {

    List<List<Integer>>  answer = new ArrayList<>();
    List<Integer> currentSeq = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        recursion(0, candidates, target);
        return answer;
        
    }

    public void recursion(int start, int[] candidates, int target) {

        //base case
        if(target == 0) {
            answer.add(new ArrayList<>(currentSeq));
            return;
        }

        //recursion steps
        for(int i = start; i < candidates.length; i++) {
            if(target >= candidates[i]) {
                currentSeq.add(candidates[i]);
                recursion(i, candidates, target - candidates[i]);
                //backtracking
                currentSeq.remove(currentSeq.size() - 1);
            }
        }
    }
}