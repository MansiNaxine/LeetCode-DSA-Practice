class Solution {
    public String convert(String s, int numRows) {
        
        //also u have to check for length 1
        if(numRows == 1) return s;

        //First take a answerList to store the list of characters
        List<List<Character>> answerList = new ArrayList<>();

        //will initiate lists of characatrers inside answerList with empty values
        for(int i = 0; i < numRows; i++) {
            List<Character> currSeq = new ArrayList<>();

            answerList.add(new ArrayList<>(currSeq)); //contains the empty character list each time
        }

        int rowIndex = 0;//to put the character at right index
        int turn = 0;

        for(int i = 0; i < s.length(); i++) {
            answerList.get(rowIndex).add(s.charAt(i));

            if (turn == 0) {
                rowIndex++;
                if(rowIndex == numRows) {
                    rowIndex -= 2;
                    turn = 1;
                }
            } else {
                rowIndex--;
                if(rowIndex == -1) {
                    rowIndex += 2;
                    turn = 0;
                }
            }
        }

        //now copying all characters from answerList to stringBuilder
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < answerList.size(); i++) {
            for(int j = 0; j < answerList.get(i).size(); j++) {
                sb.append(answerList.get(i).get(j));
            }
        }

        return sb.toString();
        
    }
}