class Solution {
    public int[][] merge(int[][] intervals) {

        //Sort the intervals 2D array based on first element

        return bruteForceApproach(intervals);

    }

    public int[][] bruteForceApproach(int[][] intervals) {
        int n = intervals.length;
        int m = 2;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> answerList = new ArrayList<>();
        List<Integer> currList1 = new ArrayList<>();
        currList1.add(intervals[0][0]);
        currList1.add(intervals[0][1]);

        answerList.add(new ArrayList<>(currList1));

        for(int i = 1; i < n; i++) {
            if(!answerList.isEmpty()) {
                int secondNum = answerList.getLast().get(1);
                int firstCurrentINum = intervals[i][0];
                int secondCurrentINum = intervals[i][1];
                if( firstCurrentINum <= secondNum ) {
                    int actualNum = intervals[i][1];
                    answerList.getLast().set(1, Math.max(actualNum, secondNum));
                }
                else {
                    List<Integer> currList = new ArrayList<>();
                    currList.add(intervals[i][0]);
                    currList.add(intervals[i][1]);

                    answerList.add(new ArrayList<>(currList));
                }
            }
        }

        int[][] answer = new int[answerList.size()][2];

        for(int i = 0; i < answerList.size(); i++) {
            for(int j = 0; j < 2; j++) {
                answer[i][j] = answerList.get(i).get(j);
            }
        }

        return answer;
        
    }
}