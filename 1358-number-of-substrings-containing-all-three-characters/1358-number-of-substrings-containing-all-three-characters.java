class Solution {
    public int numberOfSubstrings(String s) {

        int n = s.length();
        int sum = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int cnt = 0;

        while(i < n) {
            //inserting frequencies of characters
            map.put(s.charAt(i), i);

            if(map.size() == 3) {
                cnt = cnt + Math.min(map.get('a'), Math.min(map.get('b'), map.get('c'))) + 1;
            }
            i++;
        }

        return cnt;
        
    }
}