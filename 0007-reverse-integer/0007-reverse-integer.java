class Solution {
    public int reverse(int x) {
        
        long ans = 0;
        //find the last digit

        //multiply last digit by 10
        //the do the addition with next digit
        
        while(x != 0) {
            ans  = ans + (x % 10);
            ans = ans * 10;
            x = x / 10;
        }

        ans = ans/10;

        if(ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) return 0;

        if( x < 0) ans = -ans;


        return (int)ans;

    }
}