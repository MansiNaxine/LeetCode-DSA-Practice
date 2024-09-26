class Solution {
    public boolean isPowerOfTwo(int n) {

        int sqrt=(int)Math.sqrt(n);
        if(n==1){
            return true;
        }
        for(int i=1;i<=sqrt+1;i++){
            if(Math.pow(2,i)==n){
                return true;
            }

        }
        return false;
    }
}