class Solution {

    List<List<Integer>> answer = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {

        recursion(0,nums);
        return answer;
        
    }

    public void recursion(int index,  int[] nums){
        //base case
        if(index == nums.length){
            List<Integer> currAns = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                currAns.add(nums[i]) ;
            }
            answer.add(currAns);
            return;
        }

        //recursive case
        for(int i=index;i<nums.length;i++){
            swap(i, index,nums);
            recursion(index+1,nums);
            swap(i, index,nums);
        }
        
    }

    public void swap(int i, int index, int[] nums){
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}