class Solution {

    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> currentSeq = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        
        recursion(0, nums);
        return answer;
    }

    public void recursion(int index, int[] nums) {

        //base case
        if(index == nums.length) {
            answer.add(new ArrayList<>(currentSeq));
            return;
        }

        //recursion steps
        currentSeq.add(nums[index]);
        recursion(index + 1, nums);

        //backtracking
        currentSeq.remove(currentSeq.size() - 1);
        recursion(index + 1, nums);

    }
}