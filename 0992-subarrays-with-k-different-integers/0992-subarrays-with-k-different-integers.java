class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {

        int ans1 = calculateNumberOfSubArrays(nums, k);
        int ans2 = 0;
        if(k - 1 < 0) return ans1;
        else ans2 = calculateNumberOfSubArrays(nums, k - 1);

        return ans1 - ans2;
    }

    public int calculateNumberOfSubArrays(int[] nums, int k) {

        int n = nums.length;
        int cnt = 0;
        int i = 0;
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while(j < n) {

             map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            // if(!map.containsKey(nums[j])) {
            //     map.put(nums[j], 1);
            // }
            // else {
            //     map.put(nums[j], map.get(nums[j]) + 1);
            // }

            while(map.size() > k) {
                map.put(nums[i] , map.get(nums[i]) - 1);
                if(map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }

            if(map.size() <= k) {
                cnt += (j - i + 1);
            }
            j++;
        }

        return cnt;
    }
}