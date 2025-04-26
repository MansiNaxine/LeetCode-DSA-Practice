class Solution {
    public double myPow(double x, int n) {
        
        if(n < 0) {
            return 1/helper(x, -n);
        } 
        return helper(x, n);
    }

    public double helper(double x, int n) {
        if(n == 0) return 1.0;
        // double answer = 1.0;
        // if(n == 1) {
        //     return x;
        // }

        // answer = x * helper(x, n-1);
        // return answer;

        double partialAns = helper(x, n/2);
        if(n%2 == 0) {
            return partialAns * partialAns;
        } else {
            return partialAns * partialAns * x;
        }
    }
}