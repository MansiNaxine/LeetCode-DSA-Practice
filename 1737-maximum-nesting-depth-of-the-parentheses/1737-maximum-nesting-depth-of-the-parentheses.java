class Solution {
    public int maxDepth(String s) {

        int count = 0; 
        int n = s.length();
        int max = 0;
        int res = 0;

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '(') {
                count++;
                max = Math.max(count,max);
            }else if(s.charAt(i) == ')') {
                count--;
            }
            
        }

        return max;
        
    }
}