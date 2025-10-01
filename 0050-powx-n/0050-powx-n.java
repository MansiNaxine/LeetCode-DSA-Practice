class Solution {

    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        int origN = n;
        double answer = helper(x,(long) n);

        if(origN < 0) {
            return 1/answer ; 
        } else {
            return answer;
        }
    }

    public double helper(double x, long n) {
            if(n == 0) return 1.0;
            //below solution won't work incase of large n values
            //double answer = x * negativeCaseHelper(x , Math.abs(n) -  1);
            double partialAns = helper(x, n/2);
            if(n%2 == 0) {
                return partialAns * partialAns;
            } else {
                return partialAns * partialAns * x;
            }
    }
}