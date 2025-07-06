class Solution {
    public int numPairsDivisibleBy60(int[] time) {

        int n = time.length;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            int num = time[i];
            num = num % 60;
            
            if(num < 0) num += 60;
            
            answer += (num != 0) ? (map.getOrDefault((60 - num), 0)) : map.containsKey(0) ? (map.get(0)) : 0;

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return answer;
        
    }
}