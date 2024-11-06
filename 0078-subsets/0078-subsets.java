class Solution {

    List<List<Integer>> list=new ArrayList<>();
    List<Integer> currSeq=new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
       helper(nums,0);
       return list;
        
    }


    public void helper(int[] nums,int index){

        if(index==nums.length){
            list.add(new ArrayList<>(currSeq));
            return;
        }

        //first add the element
        currSeq.add(nums[index]);
        helper(nums,index+1);
        //while returning remove the element
        currSeq.remove(currSeq.size()-1);
        helper(nums,index+1);
    }
}