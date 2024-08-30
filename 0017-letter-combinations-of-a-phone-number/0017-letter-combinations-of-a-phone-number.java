class Solution {
    public List<String> letterCombinations(String digits) {
        String[] lettersInNumbers={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(!digits.isEmpty()){
            List<String> ans=printOutput(lettersInNumbers,digits,"");
            return ans;
        }else{
            return new ArrayList<>();
        }
        
        
       }

        public static List<String> printOutput(String[] lettersInNumbers,String digits,String p){

            if(digits.isEmpty()){
                ArrayList<String> list=new ArrayList<>();
                list.add(p);
	            return list;
            }

            int digit=(int) digits.charAt(0)-'0';
            ArrayList<String> list=new ArrayList<>();
            
            for(int i=0;i<lettersInNumbers[digit].length();i++){

                list.addAll(printOutput(lettersInNumbers,digits.substring(1),p+lettersInNumbers[digit].charAt(i)));
            }

            return list;
        }

    
}