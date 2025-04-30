class Solution {

    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> currSeq = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        
        recursion(nums, 0);
        return answer;
    }

    public void recursion(int[] nums, int index) {

        //base case
        if(index == nums.length) {
            answer.add(new ArrayList<>(currSeq));
            return;
        }

        //recursive case
        for(int i = index; i < nums.length; i++) {
            currSeq.add(nums[i]);
            //swap elements
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
            recursion(nums, index + 1);
            currSeq.remove(currSeq.size() - 1);
            temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }
    }
}