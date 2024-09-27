class Solution {
    public boolean isPowerOfFour(int n) {

        int sqrt=(int)Math.sqrt(n);
        if(n==1){
            return true;
        }
        for(int i=1;i<=sqrt;i++){
            if(Math.pow(4,i)==n){
                return true;
            }
        }

        return false;
        
    }
}