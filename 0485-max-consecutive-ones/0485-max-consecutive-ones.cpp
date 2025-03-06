class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int count = 0;
        int answer = 0;
        for(int i=0; i<nums.size(); i++) {
            if(nums[i] == 0) {
                count = 0;
            } else {
                count++;
            }
            
            answer = max(answer, count);

        }

        return max(answer, count);
        
    }
};