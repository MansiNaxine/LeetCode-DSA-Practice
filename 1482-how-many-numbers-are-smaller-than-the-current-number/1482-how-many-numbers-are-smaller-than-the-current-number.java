class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int n = nums.length;
        int answer[] = new int[n];

        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if (nums[j] >= nums[i]) {
                    continue;
                } else {
                    count++;
                    answer[i] = count;
                    
                }
            }
        }

        return answer;
        
    }
}