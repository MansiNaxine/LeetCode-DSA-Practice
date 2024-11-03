class Solution {

    public double myPowHelper(double x,int n){
        if(n==0){
            return 1.0;
        }

        double partialAns = myPowHelper(x,n/2);

        if(n%2==0){
            return partialAns * partialAns;
        }else{
            return partialAns * partialAns * x;
        }
    }

    public double myPow(double x, int n) {
         if(n<0){
            return 1/myPowHelper(x,Math.abs(n));
        }else{
            return myPowHelper(x,n);
        }
        
        
    }
}