class Solution {

    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> currSeq = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0);
        return answer;
    }

    public void helper(int[] candidates, int target, int index) {

        //base case
        if(index >= candidates.length) return;

        if(target == 0) {
            answer.add(new ArrayList<>(currSeq));
            return;
        }

        //recursive case
        
            if(candidates[index] <= target) {

                    currSeq.add(candidates[index]);
                    helper(candidates, target - candidates[index], index);
                    currSeq.removeLast();
                    helper(candidates, target, index + 1);

            } 
        
        
    }
}