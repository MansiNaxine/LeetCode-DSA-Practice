class Solution {
    public int singleNumber(int[] nums) {

        int n = nums.length;
        int answer = 0;

        for(int num : nums) {
            answer ^= num;
        }

        return answer;
        
    }
}