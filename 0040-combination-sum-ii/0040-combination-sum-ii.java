class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> currSeq = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        helper(candidates, target, 0);
        return answer;
    }

    public void helper(int[] candidates, int target, int index) {

        int n = candidates.length;
        //base case
            if(target == 0) {
                List<Integer> newCurr = new ArrayList<>();
                for(int i = 0; i < currSeq.size(); i++) {
                    newCurr.add(currSeq.get(i));
                }
                answer.add(new ArrayList<>(newCurr));
                return;
            }

        //recursive case
        for(int i = index; i < n; i++) {
            if(i > index && candidates[i] == candidates[i-1]) continue;
            if(target >= candidates[i]) {
                currSeq.add(candidates[i]);
                helper(candidates, target-candidates[i], i+1);
                currSeq.remove(currSeq.size() - 1);
            }
        }
            
    }
}