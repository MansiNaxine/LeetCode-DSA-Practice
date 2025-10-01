class Solution {
    public boolean isPowerOfFour(int n) {
        if(n == 0) return false;
        if(n == 1) return true;
        if((n % 4 )== 1) return false;
        
        return (n % 4) == 0 ? isPowerOfFour(n/4) : false;
    }
}