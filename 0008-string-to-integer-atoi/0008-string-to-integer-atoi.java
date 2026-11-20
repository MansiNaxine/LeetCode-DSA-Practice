class Solution {
    long answerNum = 0;
    public int myAtoi(String input) {
        // Your code goes here

        input = input.trim();
        if(input.length() == 0) return 0;
        int zerothChar = input.charAt(0);
        boolean negative = false;
        int index = 0;
        if(zerothChar == '-') {
            negative = true;
            index = 1;
        }
        else if (zerothChar == '+') index = 1;
        helper(index, input);

        return negative ? ((int) Math.max(-answerNum, Integer.MIN_VALUE)) : (int) Math.min(answerNum, Integer.MAX_VALUE);
    }


    public void helper(int index, String input) {
        //base case
        if(index >= input.length()) return;
        if(-answerNum < Integer.MIN_VALUE || answerNum > Integer.MAX_VALUE) return;

        char currCharacter = input.charAt(index);
        if(currCharacter >= '0' && currCharacter <= '9') {
            answerNum  = (answerNum * 10) + (int)(currCharacter - '0');
            helper(index + 1, input);
        }
    }
}