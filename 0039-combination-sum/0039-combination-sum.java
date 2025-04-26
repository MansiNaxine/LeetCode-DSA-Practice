class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> currSeq = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        recursion(0, candidates, target);
       
        return answer;
        
    }

    public void recursion(int start, int[] candidates, int target) {

        //base case
        if(target == 0) {
            List<Integer> ans = new ArrayList<>();
            for(int i = 0; i < currSeq.size(); i++) {
                ans.add(currSeq.get(i));
            }
            answer.add(new ArrayList<>(ans));
            return;
        }

         //recursive case
        for(int i = start; i < candidates.length; i++) {
            if (target >= candidates[i]) {
                currSeq.add(candidates[i]);
                recursion(i, candidates, target-candidates[i]);
                currSeq.remove(currSeq.size() - 1);
            }
        }
    }
}