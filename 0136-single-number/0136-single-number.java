class Solution {
    public int singleNumber(int[] nums) {

        //BruteForce Approach
        //Time Complexity :- O(N ^ 2)
        //Space Complexity :- O(1)
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            boolean checkNum = false;
            for(int j = 0; j < nums.length; j++) {
                if(i != j && nums[i] == nums[j]) {
                    checkNum = true;
                    break;
                }
            }

            if(!checkNum) {
                ans = nums[i];
            }
        }

        //Optimal Solution
        //Time Complexity :- O(N)
        //Space Complexity :- O(1)
        // int ans = 0;
        // for(int num :  nums) {
        //     ans  = ans ^ num;
        // }

         return ans;
    }
}