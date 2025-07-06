class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        //will make 1 frequency character array
        int[] freqa = new int[256];
        int[] freqb = new int[256];

        Map<Character, Character> map = new HashMap<>();

        int n = s.length();

        for(int i = 0 ; i< n; i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            freqa[(int)a]++;
            freqb[(int)b]++;

            if(!map.containsKey(a) && freqa[a] == freqb[b]) {
                map.put(a, b);
            } else {
                if(map.containsKey(a) && map.get(a) != b) return false;
                if(freqa[a] != freqb[b]) return false;
            }
        }

        return true;
    }
}