class Solution {
    public int divide(int dividend, int divisor) {
        long n = Math.abs((long) dividend);
        long m = Math.abs((long) divisor);
        long origiAns = 0;


        while(n >= m) {
            long pow = 1;
            long ans = 0;
            while((m * pow) <= n) {
                ans = pow;
                pow *= 2;
            }
            n -= (m * ans);
            origiAns += ans;

        }

        if((origiAns > Integer.MAX_VALUE) && (dividend < 0 && divisor < 0))return Integer.MAX_VALUE;
        else if ((origiAns > Integer.MAX_VALUE) && (dividend < 0 || divisor < 0)) return Integer.MIN_VALUE;

        return (dividend < 0 && divisor < 0) ? (int)origiAns : (dividend < 0 || divisor < 0) ? -(int)origiAns : (int)origiAns;
        
    }
}