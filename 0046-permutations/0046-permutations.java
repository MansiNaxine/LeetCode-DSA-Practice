class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> currSeq = new ArrayList<>();
        helper(answer, nums, 0, currSeq);
        return answer;
    }

    public void helper(List<List<Integer>> answer, int[] nums, int index, List<Integer> currSeq) {
        //base case
        if(index >= nums.length) {
            currSeq = new ArrayList<>();
            for(int num : nums) {
                currSeq.add(num);
            }
            answer.add(new ArrayList<>(currSeq));
            return;
        }

        //recursive case
        for(int i = index; i < nums.length; i++) {
            int temp1 = nums[i];
            nums[i] = nums[index];
            nums[index] = temp1;
            helper(answer, nums, index + 1, currSeq);
            int temp2 = nums[i];
            nums[i] = nums[index];
            nums[index] = temp2;
        }
    }
}