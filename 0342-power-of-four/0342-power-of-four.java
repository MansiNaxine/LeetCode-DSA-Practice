class Solution {
    public boolean isPowerOfFour(int n) {

        if((n > 0) && (n % 4 == 0)) {
            return isPowerOfFour(n/4);
        }

        return n == 1 ? true : false;
        
    }
}