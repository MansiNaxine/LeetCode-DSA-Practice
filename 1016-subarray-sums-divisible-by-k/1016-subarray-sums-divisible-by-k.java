class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        int n = nums.length;
        int sum = 0;
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        //we also have to handle 0th case, means in case 0 will come then only that particluar element also will be a part of subarray
        map.put(0, 1);

        for(int i = 0; i < n; i++) {
            sum += nums[i];
            sum %= k;
            if(sum < 0) {
                sum += k;
            }
            answer += map.getOrDefault((sum%k), 0);
            map.put((sum % k), map.getOrDefault((sum % k), 0) + 1);
        }

        return answer;

        
    }
}