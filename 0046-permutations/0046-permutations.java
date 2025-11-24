class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();
        helper(answer, nums, 0);
        return answer;
    }

    public void helper(List<List<Integer>> answer, int[] nums, int index) {
        //base case
        if(index >= nums.length) {
            List<Integer> currSeq = new ArrayList<>();
            for(int num : nums) {
                currSeq.add(num);
            }
            answer.add(new ArrayList<>(currSeq));
            return;
        }

        //recursive case
        for(int i = index; i < nums.length; i++) {
            if(i != index) swap(nums, i, index);
            helper(answer, nums, index + 1);
            if(i != index) swap(nums, i, index);
        }
    }

    public static void swap(int[]nums,int i,int index){
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}