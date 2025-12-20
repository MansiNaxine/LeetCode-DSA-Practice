class Solution {
    public int[][] merge(int[][] intervals) {

        //Sort the intervals 2D array based on first element

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
                if( firstCurrentINum <= secondNum && secondCurrentINum > secondNum) {
                    int actualNum = intervalsList.get(i).get(1);
                    answerList.getLast().set(1, actualNum);
                }
                else if (secondCurrentINum <= secondNum) {
                    continue;
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