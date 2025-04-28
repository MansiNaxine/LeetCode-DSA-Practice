class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> currSeq = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        
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
        currSeq.add(nums[index]);
        recursion(nums, index+1);
        currSeq.remove(currSeq.size() - 1);
        recursion(nums, index+1);
    }
}