class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {

        int answer = (int)1e9;
        int n = nums.size();

        int i = 0; 
        int j = 0;
        int sum = 0;

        while(j < n) {
            sum += nums[j];

            while(i <= j && sum >= target) {
                int len = j - i + 1;
                answer = min(answer, len);
                sum -= nums[i];
                i++;
            }

            j++;
        }

        return answer == (int)1e9 ? 0 : answer ;
        
    }
};