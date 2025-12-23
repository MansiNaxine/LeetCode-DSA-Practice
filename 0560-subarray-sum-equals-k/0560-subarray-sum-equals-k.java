class Solution {
    public int subarraySum(int[] nums, int k) {

        int n = nums.length;
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int num : nums) {
            sum += num;

            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            
            if (!map.containsKey(sum)) {
                map.put(sum, 1);
            }
            else {
                map.put(sum, map.get(sum) + 1);
            }

        }

        return count;
        
    }
}