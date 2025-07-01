class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int sum = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        map.put(0, 1);
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            answer += map.getOrDefault((sum - k), 0);

            if(map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);

            } else {
                map.put(sum, 1);
            }
        }

        return answer;
    }
}