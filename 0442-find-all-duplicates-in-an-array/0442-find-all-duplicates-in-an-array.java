class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        int n = nums.length;
        List<Integer> answer = new ArrayList<>();

        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
        }

        int freq[] = new int[max + 1];

        for(int i = 0; i < n; i++) {
            freq[nums[i]]++;
            if(freq[nums[i]] == 2) {
                answer.add(nums[i]);
            }
        }

        return answer;
        
    }
}