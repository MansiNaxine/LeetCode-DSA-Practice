class Solution {
    public String convert(String s, int numRows) {

        if(numRows == 1) {
            return s;
        }

        //First form List<List<Integer>> and add empty list elements
        List<List<Character>> answerList = new ArrayList<>();

        for(int i=0; i<numRows; i++) {
            List<Character> currSeq = new ArrayList<>();
            answerList.add(new ArrayList<>(currSeq));
        }

        int rowIndex = 0 ;
        int turn = 0;

        for(int i=0; i<s.length(); i++) {
            answerList.get(rowIndex).add(s.charAt(i));

            if(turn == 0) {
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
        
        StringBuilder answer = new StringBuilder("");
        for(int i=0; i<answerList.size(); i++) {
            for(int j=0; j<answerList.get(i).size(); j++) {
                answer.append(answerList.get(i).get(j));
            }
        }

        return answer.toString();
    }
}