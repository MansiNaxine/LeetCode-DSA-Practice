class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>>  answer = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);

        answer.add(new ArrayList<>(firstRow));

        int midElement = 0;

        for(int i = 1; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1); // first column of row

            //adding middle element logic
            for(int j = 1; j <= midElement; j++) {
                int midCalc = answer.get(i - 1).get(j - 1) + answer.get(i - 1).get(j);
                currentRow.add(midCalc) ;
            }

            midElement ++;
            currentRow.add(1);//last column of first row
            answer.add(new ArrayList<>(currentRow));
        }

        return answer;
        
    }
}