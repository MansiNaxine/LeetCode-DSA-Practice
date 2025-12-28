class Solution {
    public double myPow(double x, int n) {

        int origN = n;
        
        if(n < 0) {
            if(n == Integer.MIN_VALUE) n = Integer.MAX_VALUE;
            if(origN%2 == 0) return Math.abs(1.0/calculatPower(x, Math.abs(n)));
            else return 1.0/calculatPower(x, Math.abs(n));
        }
        else {
            if(origN%2 == 0) return Math.abs(calculatPower(x, n));
            else return calculatPower(x, n);
        }
    }

    public double calculatPower(double x, long n) {
        double ans = 1.0;

        if(n == 0) {
            return ans;
        }

        while (n > 0) {
            if (n%2 == 1) {
                ans = ans * x;
                n = n - 1;
            }
            else {
                x = x * x;
                n = n/2;
            }
        }

        return ans;
    }
}