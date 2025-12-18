class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> answer = new ArrayList<>();

        for(int row = 1; row <= numRows; row++) {
            List<Integer> currRow = gievCompleteRowElements(row);

            answer.add(new ArrayList<>(currRow));
        }

        return answer;
    }

    public int giveElement(int row, int column) {

        int res = 1;
        int len = (row - column);
        for(int i = 0; i < len; i++) {
            res = res * (row - i);
            res = res / (i + 1);
        }

        return res;
    }

    public List<Integer> gievCompleteRowElements(int nthRow) {

        List<Integer> currRow = new ArrayList<>();

        for(int col = 1; col <= nthRow; col++) {
            int element = giveElement(nthRow - 1, col - 1);
            currRow.add(element);
        }

        return currRow;
    }
}