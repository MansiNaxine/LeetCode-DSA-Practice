class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length;
        int m = s.length;
        int cnt = 0;

        if(m <= 1) return m;
        else {
            int i = 0;
            int j = 0;
            while(i < n && j < m) {
                if(s[j] >= g[i]) {
                    cnt += 1;
                    i++;
                }
                j++;
            }
        }

        return cnt;
    }
}