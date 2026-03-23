class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        helper(answer, nums, 0, new ArrayList<>());
        return answer;
    }

    public void helper(List<List<Integer>> answer, int[] nums, int index, List<Integer> currSeq) {
        //base case
        if(index >= nums.length) {
            answer.add(new ArrayList<>(currSeq));
            return;
        }

        //recursive case
        currSeq.add(nums[index]);
        helper(answer, nums, index + 1, currSeq);
        currSeq.removeLast();
        // int currIndex = index + 1;
        // while(currIndex < nums.length && nums[currIndex] == nums[currIndex - 1]) {
        //     currIndex++;
        // }
        helper(answer, nums, index + 1, currSeq);
    }
}