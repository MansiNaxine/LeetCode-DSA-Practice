class Solution {
    public String convert(String s, int numRows) {

        if(numRows == 1) return s;

        List<List<Character>> answer = new ArrayList<>();


        //Creating empty rows inside answer List initially
        for(int i = 0; i < numRows; i++) {
            List<Character> currentRow = new ArrayList<>();
            answer.add(new ArrayList<>(currentRow));
        }

        //we will iterate through string
        int rowIndex = 0;
        int turn = 0;
        for(int i = 0; i < s.length(); i++) {

            answer.get(rowIndex).add(s.charAt(i));
            //add character from string

            //choose the character
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

        StringBuilder sb = new StringBuilder("");

        for(int i = 0; i < answer.size(); i++) {
            for(int j = 0; j < answer.get(i).size(); j++) {
                sb.append(answer.get(i).get(j));
            }
        }

        return sb.toString();
        
    }
}