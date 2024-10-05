class Solution {
    public int numOfStrings(String[] patterns, String word) {

        
       int count=0;
	        for(String patternWord: patterns){
	            for(int i=0;i<=word.length()-patternWord.length();i++) {
                    //we are using substring here that's why last word will get exclude 
	            	if(patternWord.equals(word.substring(i, i+patternWord.length()))) {
	            		count++;
	            		break;
	            	}
	            	
	            }   
	        }
	        
	        return count;
    }
}