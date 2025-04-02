class Solution {
    public int majorityElement(int[] nums) {

        int count = 0;
        int answer = 0;
        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                answer = nums[i];
                count++;
            } else {
                if(nums[i] == answer) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        return answer;
        
    }
}