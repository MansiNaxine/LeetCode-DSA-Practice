class Solution {
    public int singleNumber(int[] nums) {

        //BruteForce Approach
        //Time Complexity :- O(N ^ 2)
        //Space Complexity :- O(1)
        int ans = 0;
        // for(int i = 0; i < nums.length; i++) {
        //     boolean checkNum = false;
        //     for(int j = 0; j < nums.length; j++) {
        //         if(i != j && nums[i] == nums[j]) {
        //             checkNum = true;
        //             break;
        //         }
        //     }

        //     if(!checkNum) {
        //         ans = nums[i];
        //     }
        // }

        //Better Approach
        //Time Complexity :- O(N)
        //Space Complexity :- O(N)

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) ans = entry.getKey();
        }

        //Optimal Solution
        //Time Complexity :- O(N)
        //Space Complexity :- O(1)
        // int ans = 0;
        // for(int num :  nums) {
        //     ans  = ans ^ num;
        // }

        //  return ans;

        return ans;
    }
}