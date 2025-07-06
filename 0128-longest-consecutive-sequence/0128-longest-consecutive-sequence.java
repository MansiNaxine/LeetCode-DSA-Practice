class Solution {
    public int longestConsecutive(int[] nums) {

        int n = nums.length;
        int answer = 0;
        int count = 1;
        Map<Integer, Integer> map = new TreeMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(int key : map.keySet()) {
            if(map.containsKey(key + 1)) {
                count += 1;
            } else {
                answer = Math.max(answer, count);
                count = 1;
            }
        }

        return answer;
        
    }
}