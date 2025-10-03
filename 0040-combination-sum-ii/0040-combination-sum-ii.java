class Solution {

    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> currSeq = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length <= 1 && target > candidates[0]) return answer;
        Arrays.sort(candidates);
        
        helper(candidates, target, 0);
        return answer;
        
    }

    public void helper(int[] candidates, int target, int index) {

        //base cases

        if(target == 0) {

            answer.add(new ArrayList<>(currSeq)) ;

            return;
        }

        if(index >= candidates.length) return;

        //recursive case
        if(candidates[index] <= target) {
            currSeq.add(candidates[index]);
            helper(candidates, target - candidates[index], index + 1);
            currSeq.removeLast();

            //below logic is to remove duplicate elements
            int newIndex = index + 1;
            while(newIndex < candidates.length && candidates[newIndex] == candidates[newIndex - 1]) {
                newIndex++;
            }
            helper(candidates, target, newIndex);
        }


    }
}