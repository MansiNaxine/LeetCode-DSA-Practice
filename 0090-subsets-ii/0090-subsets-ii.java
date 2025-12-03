class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> currSeq = new ArrayList<>();
        Arrays.sort(nums);
        helper(answer, currSeq, 0,  nums);
        return answer;

    }

    public void helper(List<List<Integer>> answer, List<Integer> currSeq, int index, int[] nums) {
        //base case
        if(index >= nums.length) {
            answer.add(new ArrayList<>(currSeq));
            return;
        }
        

        //recursive case
            currSeq.add(nums[index]);
            helper(answer, currSeq, index + 1, nums);
            currSeq.removeLast();
            int newIndex = index + 1;
            while(newIndex > 0 && newIndex < nums.length && nums[newIndex] == nums[newIndex - 1]){
                newIndex++;
            }
            helper(answer, currSeq, newIndex, nums);
    }
}