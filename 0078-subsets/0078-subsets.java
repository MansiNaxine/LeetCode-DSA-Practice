class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> currSeq = new ArrayList<>();
        helper(nums, answer, currSeq, 0);
        return answer;
        
    }


    public void helper(int[] nums, List<List<Integer>> answer, List<Integer> currSeq, int index) {
        //base case
        if(index >= nums.length) {
            answer.add(new ArrayList<>(currSeq));
            return;
        }

        //recursive case
        
        currSeq.add(nums[index]);
        helper(nums, answer, currSeq, index + 1);
        currSeq.removeLast();
        helper(nums, answer, currSeq, index + 1);

    }
}