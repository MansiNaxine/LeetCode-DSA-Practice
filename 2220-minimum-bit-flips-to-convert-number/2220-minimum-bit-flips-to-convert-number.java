class Solution {
    public int minBitFlips(int start, int goal) {

        int xorOfNums = start ^ goal;
        int countOfSetBits = 0;
        while(xorOfNums > 0) {
            countOfSetBits += (xorOfNums%2);
            xorOfNums = xorOfNums >> 1;
        }

        return countOfSetBits;
        
    }
}