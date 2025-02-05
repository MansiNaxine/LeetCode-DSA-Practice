class Solution {

    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> currentSeq = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        
      recursion(0, nums);
      return answer;
    }

    public void recursion(int index, int[] nums) {

        if(index == nums.length) {

            answer.add(new ArrayList<>(currentSeq));
            return ;
        }

        //2 operations are required
        //1st is to add the element
        currentSeq.add(nums[index]);
        recursion(index+1, nums);

        //2nd is to remove the element
        currentSeq.remove(currentSeq.size() - 1);
        recursion(index+1, nums);
    }
}