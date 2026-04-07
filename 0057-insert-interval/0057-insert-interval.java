class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        //First we have to copy in List<List<>();
        List<List<Integer>> list  = new ArrayList<>();
        List<List<Integer>> answer  = new ArrayList<>();
        int n = intervals.length;
        int m = 2;

        if(n == 0) {
            List<Integer> currSeq = new ArrayList<>();
            currSeq.add(newInterval[0]);
            currSeq.add(newInterval[1]);

            answer.add(new ArrayList<>(currSeq));
            return returnAnswer(answer);
        }

        for(int i = 0; i < n; i++) {
            List<Integer> currSeq = new ArrayList<>();
            currSeq.add(intervals[i][0]);
            currSeq.add(intervals[i][1]);

            list.add(new ArrayList<>(currSeq));
                
        }

        int smallerStart = Integer.MAX_VALUE;
        int greaterEnd = -1;
        int greaterIndex = n;
        int startIndex = -1;

        for(int i = 0; i < list.size(); i++) {

            //Find Smaller Start
            if(list.get(i).get(0) <=  newInterval[0]) {
                smallerStart = list.get(i).get(0);
                startIndex = i;
            }

            //Find Greater End
            if(list.get(i).get(1) >=  newInterval[1]) {
                greaterEnd = list.get(i).get(1);
                greaterIndex = i;
                break;
            }
        }

        //if smallerStart == max_value and greaterEnd == -1, first interval we got
        if(startIndex == -1 && greaterIndex == n) {
            
                List<Integer> currSeq = new ArrayList<>();
                currSeq.add(newInterval[0]);
                currSeq.add(newInterval[1]);
                answer.add(new ArrayList<>(currSeq));
                return returnAnswer(answer);
        }
        else if(startIndex == -1) { //if smallerStart == max_value , first interval we have to compare
            List<Integer> currSeq = new ArrayList<>();
            currSeq.add(newInterval[0]);
            int end = newInterval[1];
            int firstStartOfList = list.get(greaterIndex).get(0);
            int firstEndOfList = list.get(greaterIndex).get(1);
            if(end < firstStartOfList) {
                currSeq.add(newInterval[1]);
                greaterIndex = greaterIndex;
            }
            else {
                int max = Math.max(newInterval[1], firstEndOfList);
                currSeq.add(max);
                greaterIndex = greaterIndex + 1;
            }
            answer.add(new ArrayList<>(currSeq));
            for(int i = greaterIndex; i < list.size(); i++) {
                    List<Integer> currSeq1 = new ArrayList<>();
                    currSeq1.add(list.get(i).get(0));
                    currSeq1.add(list.get(i).get(1));

                    answer.add(new ArrayList<>(currSeq1));
                }

            return returnAnswer(answer);
        }
        else if(greaterIndex == n) { //if greaterEnd == -1 , last interval we have to compare
            
            if(!list.isEmpty()) {
                for(int i = 0; i <= startIndex; i++) {
                    List<Integer> currSeq1 = new ArrayList<>();
                    currSeq1.add(list.get(i).get(0));
                    currSeq1.add(list.get(i).get(1));

                    answer.add(new ArrayList<>(currSeq1));
                }
            }

            int endOfStartIndexPos = list.get(startIndex).get(1);
            int start = newInterval[0];

            if(start > endOfStartIndexPos) {
                List<Integer> currSeq1 = new ArrayList<>();
                currSeq1.add(start);
                currSeq1.add(newInterval[1]);

                answer.add(new ArrayList<>(currSeq1));
            }
            else {
                int min = Math.min(start, answer.get(startIndex).get(0));
                answer.get(startIndex).set(0, min);
                answer.get(startIndex).set(1, newInterval[1]);
            }

            return returnAnswer(answer);
        }
        else {


            if(!list.isEmpty()) {
                for(int i = 0; i <= startIndex; i++) {
                    List<Integer> currSeq1 = new ArrayList<>();
                    currSeq1.add(list.get(i).get(0));
                    currSeq1.add(list.get(i).get(1));

                    answer.add(new ArrayList<>(currSeq1));
                }
            }

            int start = newInterval[0];
            int end = newInterval[1];
            int stEleStIndex = list.get(startIndex).get(0);
            int EndEleStIndex = list.get(startIndex).get(1);
            int stEleEndIndex = list.get(greaterIndex).get(0);
            int endEleEndIndex = list.get(greaterIndex).get(1);

            if(start > EndEleStIndex && end < stEleEndIndex) {
                List<Integer> currSeq = new ArrayList<>();
                currSeq.add(start);
                currSeq.add(end);
                answer.add(new ArrayList<>(currSeq));

                greaterIndex = greaterIndex;
            }
            else if (start <= EndEleStIndex && end >= stEleEndIndex) {
                int min = Math.min(start, stEleStIndex);
                int max = Math.max(end, endEleEndIndex);

                answer.get(startIndex).set(0, min);
                answer.get(startIndex).set(1, max);
                greaterIndex = greaterIndex + 1;
            }
            else if (start > EndEleStIndex && end >= stEleEndIndex) {
                List<Integer> currSeq = new ArrayList<>();
                currSeq.add(start);
                int max = Math.max(end, endEleEndIndex);
                currSeq.add(max);
                answer.add(new ArrayList<>(currSeq));
                greaterIndex = greaterIndex + 1;
            }
            else {
                int min = Math.min(start, stEleStIndex);
                answer.get(startIndex).set(0, min);
                answer.get(startIndex).set(1, end);
                greaterIndex = greaterIndex;
            }

            for(int i = greaterIndex; i < list.size(); i++) {
                List<Integer> currSeq = new ArrayList<>();
                currSeq.add(list.get(i).get(0));
                currSeq.add(list.get(i).get(1));

                answer.add(new ArrayList<>(currSeq));
            }

            return returnAnswer(answer);
            
        }

    }


    public int[][] returnAnswer(List<List<Integer>> list) {

        int n = list.size();
        int[][] answer = new int[n][2];

        for(int i = 0; i < n; i++) {
            answer[i][0] = list.get(i).get(0);
            answer[i][1] = list.get(i).get(1);
        }

        return answer;
    }

}