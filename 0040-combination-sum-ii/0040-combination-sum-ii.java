class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
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
        // if(target >= candidates[index]) {
        //     currSeq.add(candidates[index]);
        //     helper(candidates, n, target - candidates[index], index + 1, answer, currSeq);
        //     currSeq.removeLast();
        // }
        // int currIndex = index + 1;
        // while(currIndex > 0 && currIndex < n && candidates[currIndex] == candidates[currIndex - 1]) {
        //     currIndex++;
        // }
        // helper(candidates, n, target, currIndex, answer, currSeq);

        for(int i = index; i < n; i++) {
            while(i != index && i < n && candidates[i] == candidates[i - 1]) {
                i++;
            }
            if(i < n && target >= candidates[i]) {
                currSeq.add(candidates[i]);
                helper(candidates, n, target - candidates[i], i + 1, answer, currSeq);
                currSeq.removeLast();
            }
        }
    }
}