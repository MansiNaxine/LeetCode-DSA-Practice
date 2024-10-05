class Solution {
    public int numOfStrings(String[] patterns, String word) {

        
       int count=0;
	        for(String patternWord: patterns){
	            for(int i=0;i<=word.length()-patternWord.length();i++) {
	            	if(patternWord.equals(word.substring(i, i+patternWord.length()))) {
	            		System.out.println(patternWord);
	            		count++;
	            		break;
	            	}
	            	
	            } 
	            
	            
	        }
	        
	        return count;
    }
}