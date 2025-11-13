class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> currSeq = new ArrayList<>();
        int num = 1;
        helper( answer, currSeq, num, k, n);
        return answer;
    }

    public void helper(List<List<Integer>> answer, List<Integer> currSeq, int num, int k, int target) {

        //base cases
        if(target == 0 && currSeq.size() == k) {
            answer.add(new ArrayList<>(currSeq));
            return;
        }

        if(num > 9) return;

        //recursive case
        for(int i = num; i <= 9; i++) {
            if(target >= i) {
                currSeq.add(i);
                helper(answer, currSeq, i + 1, k, target - i);
                currSeq.removeLast();
            }
        }
    }
}