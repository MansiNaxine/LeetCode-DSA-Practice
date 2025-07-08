class Solution {
    public int findDuplicate(int[] nums) {
        

        int n = nums.length;
        int[] freq = new int[nums.length];

       for(int i = 0; i < n; i++) {
        freq[nums[i]]++;
        if(freq[nums[i]] > 1) return nums[i];
       }
        return 0;
    }
}