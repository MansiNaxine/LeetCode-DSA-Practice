class Solution {
    public boolean isPalindrome(int x) {

        if(x < 0) return false;
        int origNum = x;
        int checkNum = 0;

        while(x > 0) {
            checkNum = (checkNum * 10) + (x%10);
            x = x/10;
        }

        return (checkNum == origNum);
        
    }
}