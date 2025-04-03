class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int answer[] = new int[2];
        for(int i = 0; i < nums.length - 1; i++) {
            int secondNum = target - nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[j] == secondNum) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        return answer;
    }
}