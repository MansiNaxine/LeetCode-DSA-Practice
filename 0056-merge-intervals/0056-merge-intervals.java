class Solution {
    public int[][] merge(int[][] intervals) {

        //Sort the intervals 2D array based on first element

        return bruteForceApproach(intervals);

        // return optimalApproach(intervals);

    }

    public int[][] optimalApproach(int[][] intervals) {

        int n = intervals.length;
        //Sort the array
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] answer = new int[n][2];
        answer[0][0] = intervals[0][0];
        answer[0][1] = intervals[0][1];
        int index = 1;

        for(int i = 1; i < n; i++) {
            if(answer.length != 0) {
                int secondNum = answer[answer.length - 1][1];
                int firstCurrentINum = answer[i][0];
                int secondCurrentINum = answer[i][1];
                if( firstCurrentINum <= secondNum && secondCurrentINum > secondNum) {
                    int actualNum = intervals[i][1];
                    answer[answer.length - 1][1] = actualNum;
                }
                else if (secondCurrentINum <= secondNum) {
                    continue;
                }
                else {
                    answer[index][0] = intervals[i][0];
                    answer[index][1] = intervals[i][1];

                    index++;
                }
            }
        }

        return answer;
    }

    public int[][] bruteForceApproach(int[][] intervals) {
        int n = intervals.length;
        int m = 2;

        List<List<Integer>> intervalsList = new ArrayList<>();

        //first copy all elements for intervals array to intervals to list
        for(int i = 0; i < n; i++) {
            List<Integer> currList = new ArrayList<>();
            for(int j = 0; j < m; j++) {
                    currList.add(intervals[i][j]);
            }
            intervalsList.add(new ArrayList<>(currList));
        }

        

        Collections.sort(intervalsList, (a, b) -> Integer.compare(a.get(0), b.get(0)));

        List<List<Integer>> answerList = new ArrayList<>();

        answerList.add(new ArrayList<>(intervalsList.get(0)));

        for(int i = 1; i < n; i++) {
            if(!answerList.isEmpty()) {
                int secondNum = answerList.getLast().get(1);
                int firstCurrentINum = intervalsList.get(i).get(0);
                int secondCurrentINum = intervalsList.get(i).get(1);
                if( firstCurrentINum <= secondNum ) {
                    int actualNum = intervalsList.get(i).get(1);
                    answerList.getLast().set(1, Math.max(actualNum, secondNum));
                }
                else {
                    List<Integer> currList = new ArrayList<>();
                    currList.add(intervalsList.get(i).get(0));
                    currList.add(intervalsList.get(i).get(1));

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