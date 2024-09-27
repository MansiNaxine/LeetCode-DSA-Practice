class Solution {
    public boolean isPowerOfThree(int n) {

        int sqrt=(int)Math.sqrt(n);
        if(n==1){
            return true;
        }
        for(int i=0;i<=sqrt;i++){
            if(Math.pow(3,i)==n){
                return true;
            }
        }

        return false;
    }
}