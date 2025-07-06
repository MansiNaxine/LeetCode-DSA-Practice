class Solution {
    public List<Integer> findLonely(int[] nums) {
        
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            if(!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        for(int num : nums) {
            if(!map.containsKey(num + 1) && !map.containsKey(num - 1) && map.get(num) == 1) {
                answer.add(num);
            } else {
                continue;
            }
        }

        return answer;

    }
}