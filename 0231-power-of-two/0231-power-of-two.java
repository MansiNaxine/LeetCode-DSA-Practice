class Solution {
    public boolean isPowerOfTwo(int n) {
        int cnt = 0;
        if(n <= 0) return false;
        while(n > 0) {
            cnt += (n % 2);
            n = (n >> 1);
        }

        if(cnt > 1) return false;
        else return true;
    }
}