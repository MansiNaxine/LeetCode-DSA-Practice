
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
                    return returnAnswer(answer, neg);
                }
                else return 0;
             }
            i++;
        }

        String answer = sb.toString();
        return returnAnswer(answer, neg);
    }

    public int returnAnswer(String answer, boolean neg) {

        if(answer.length() == 0) return 0;
        BigInteger answerInt = new BigInteger(answer);
        // handle negative
        if (neg) {
            answerInt = answerInt.negate();
        }

                    // bounds check
        BigInteger min = BigInteger.valueOf(Integer.MIN_VALUE);
        BigInteger max = BigInteger.valueOf(Integer.MAX_VALUE);

        if (answerInt.compareTo(min) < 0) {
            return Integer.MIN_VALUE;
        }
        if (answerInt.compareTo(max) > 0) {
            return Integer.MAX_VALUE;
        }

        return answerInt.intValue();
    }
}