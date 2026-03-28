
import java.math.BigInteger;

class Solution {
    public int myAtoi(String s) {

        StringBuilder sb = new StringBuilder("");
        boolean neg = false;
        boolean pos = false;
        s = s.trim();
        int i = 0;
        while(i < s.length()) {


            if (s.charAt(i) == '-' && i == 0) neg = true;
            else if (s.charAt(i) == '+' && i == 0) pos = true;
            else if (s.charAt(i) == 48 && sb.isEmpty()) {
                i++;
                continue;
            }
            else if(s.charAt(i) >= 48 && s.charAt(i) <= 57 ) {
                sb.append(s.charAt(i));
            }
            else {
                if(!sb.isEmpty()) {
                    String answer = sb.toString();
                    // return returnAnswer(answer, neg);
                    if((answer.length() > 10 && !neg) || (!neg && Long.parseLong(answer) > Integer.MAX_VALUE)) return Integer.MAX_VALUE;
                    else if((answer.length() > 10 && neg) || (neg && Long.parseLong(answer) > ((long)Integer.MAX_VALUE + 1))) return Integer.MIN_VALUE;
                    long val = Long.parseLong(answer);
                    int finalAnswer = (int)val;
                    return neg ? -finalAnswer: finalAnswer;
                }
                else return 0;
             }
            i++;
        }

        String answer = sb.toString();
        if(answer.length() == 0) return 0;
        

        if((answer.length() > 10 && !neg) || (!neg && Long.parseLong(answer) > Integer.MAX_VALUE)) return Integer.MAX_VALUE;
        else if((answer.length() > 10 && neg) || (neg && Long.parseLong(answer) > ((long)Integer.MAX_VALUE + 1))) return Integer.MIN_VALUE;
        long val = Long.parseLong(answer);
        int finalAnswer = (int)val;
        return neg ? -finalAnswer: finalAnswer;
    }

    
}