class Solution {
    public int numberOfMatches(int n) {

        int count=0;
        int matches=0;
        int i=n;

        while(i>1){
            
            matches = i/2; 
            count +=matches;
            i = i%2==0?matches:matches+1;
        }

        return count;
        
    }
}