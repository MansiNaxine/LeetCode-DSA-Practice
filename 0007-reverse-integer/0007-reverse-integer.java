class Solution {
    public int reverse(int x) {
        
        int origNum = x;
        if(x < 0) {
            x = Math.abs(x);
        }

        long answer = 0;
        while(x > 0) {
            answer = (answer * 10) ;
            answer += (x%10);
            x = x/10;
        }

        if(answer < Integer.MIN_VALUE || answer > Integer.MAX_VALUE) return 0;

        if(origNum < 0) {
            return -(int)answer;
        }

        return (int)answer;
    }
}