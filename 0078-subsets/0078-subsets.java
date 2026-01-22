class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        //Will Solve Using Bit Manipulation
        int n = nums.length;
        int k  = (1 << n); //Total numbers of list of subsets we will have in k
        List<List<Integer>> answerlist = new ArrayList<>();

        for(int i = 0 ; i < k; i++) {
            List<Integer> subsetList = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                int pos = 1 << j;
                if((i & ( 1 << j)) == pos) {
                    subsetList.add(nums[j]);
                }
            }
            answerlist.add(new ArrayList<>(subsetList));
        }

        return answerlist;
        
    }
}