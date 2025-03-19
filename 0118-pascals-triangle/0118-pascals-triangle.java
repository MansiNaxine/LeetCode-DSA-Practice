class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);

        //firstRow we have added
        answer.add(new ArrayList<>(firstRow));

        //taking integer for calculating middle Element
        //for the first 0th row it won't have middle element
        int midElement = 0;

        //now we wil iterate from the first row
        for(int i = 1; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);

            //adding middle elements
            for(int j = 1; j <= midElement; j++) {
                int element = answer.get(i - 1).get(j - 1) + answer.get(i - 1).get(j);
                currentRow.add(element);
            } 

            midElement++;
            //last element should also be equals to 1
            currentRow.add(1);
            answer.add(new ArrayList<>(currentRow));
        }

        return answer;
    }
}