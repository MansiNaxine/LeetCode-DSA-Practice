class Solution {

    
    public boolean checkIfPangram(String sentence) {
        
        boolean present[]=new boolean[26];

        for(int i=0;i<sentence.length();i++){
            char ch=sentence.charAt(i);

            if(ch>='a' && ch<='z'){
                present[ch-'a']=true;
            }
        }

        for(boolean ch:present){
            if(!ch){
                return false;
            }
        }

        return true;
    }
}