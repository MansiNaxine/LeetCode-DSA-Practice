class Solution {
    public String minWindow(String s1, String s2) {
        
        int n = s1.length();
        int m = s2.length();
        int i = 0;
        int j = 0;
        int minLen = Integer.MAX_VALUE;
        int sIndex = -1;
        int endIndex = -1;

        while(j < n) {
            int tIndex = 0;
            //forst we will get the right most character of s2 string
            while(j < n) {
                if(s1.charAt(j) == s2.charAt(tIndex)) tIndex++;
                if(tIndex >= m) break;
                j++;
            }

             if(tIndex == m) {
                tIndex = tIndex - 1;
                i = j;
                while(i > 0) {
                    if(s1.charAt(i) == s2.charAt(tIndex)) tIndex--;
                    if(tIndex < 0) break;
                    i--;
                }
            }
            else {
                break;
            }

            int len = j - i + 1;
            if(len < minLen) {
                minLen = len;
                sIndex = i;
                endIndex = j + 1;
            }

            j = i + 1;
        }

        return sIndex == -1 ? "" : s1.substring(sIndex, endIndex);

    }
}