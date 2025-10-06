class Solution {

    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> currSeq;

    public List<List<Integer>> permute(int[] nums) {

        helper(nums, 0);
        return answer;
        
    }

    public void helper(int[] nums, int index) {

        //base case
        if(index == nums.length) {
            currSeq = new ArrayList<>();
            for(int i = 0; i < nums.length; i++) {
                currSeq.add(nums[i]);
            }
            answer.add(new ArrayList<>(currSeq));
            return;
        }

        //recursive case
        for(int i = index; i < nums.length; i++) {
            int temp1 = nums[i];
            nums[i] = nums[index];
            nums[index] = temp1;
            helper(nums, index + 1);
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }
    }
}