class Solution {
    public int removeDuplicates(int[] nums) {
        
        //BruteForce Approach
        //Time Complexity :-  O(N^2)
        //Space Complexity :- O(N)

        //Optimal Approach
        int n = nums.length;
        int i = 0;
        int j = 0;
        while(j < n) {
            if(nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }

        return i + 1;
    }
}