class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        //first of all sort the array
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> currSeq = new ArrayList<>();
        int index = 0;
        helper(candidates, target, answer, currSeq, index);
        return answer;
    }

    public void helper(int[] candidates, int target, List<List<Integer>> answer, List<Integer> currSeq, int index) {
        //base case
            if(target == 0) {
            answer.add(new ArrayList<>(currSeq));
            return;
            }

            if(index >= candidates.length) return;

        //recursive case
        for(int i = index; i < candidates.length; i++) {
            if(i != index && candidates[i] == candidates[i - 1]) continue;
            if(target >= candidates[i]) {
                currSeq.add(candidates[i]);
                helper(candidates, target - candidates[i], answer, currSeq, i + 1);
                currSeq.removeLast();
            }
        }
    }
}