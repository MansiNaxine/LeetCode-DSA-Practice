class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder("");

        for(int i = 0; i < s.length(); i++) {

            if(!checkNumOrLetter(s.charAt(i))) continue;
            sb.append(s.charAt(i));
        }



        int i = 0; 
        int j = sb.length() - 1;

        while(i < j) {

            if(sb.charAt(i) != sb.charAt(j)) return false;

            i++;
            j--;
        }

        return true;
        
    }


    public boolean checkNumOrLetter(char num) {

        if(num >= 48 && num <= 57) return true;
        if(num >= 97 && num <= 122) return true;

        return false;
    }

}