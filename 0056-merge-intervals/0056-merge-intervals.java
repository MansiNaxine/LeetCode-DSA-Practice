class Solution {
    public int[][] merge(int[][] intervals) {

        List<List<Integer>> answer = new ArrayList<>();
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        List<Integer> currSeq = new ArrayList<>();
        currSeq.add(start);
        currSeq.add(end);
        answer.add(new ArrayList<>(currSeq));

        for(int i = 1; i < n; i++) {
            int newStart = intervals[i][0];
            int newEnd = intervals[i][1];

            if(newStart <= end) {
                int max = Math.max(end, newEnd);
                
                answer.get(answer.size()-1).set(0, start);
                answer.get(answer.size()-1).set(1, max);
                
            }
            else {
                List<Integer> curr = new ArrayList<>();
                curr.add(newStart);
                curr.add(newEnd);
                answer.add(new ArrayList<>(curr));
            }
            start = answer.get(answer.size()-1).get(0);
            end = answer.get(answer.size()-1).get(1);
        }

        int[][] answerArr = new int[answer.size()][2];

        for(int i = 0; i < answer.size(); i++) {
            answerArr[i][0] = answer.get(i).get(0);
            answerArr[i][1] = answer.get(i).get(1);
        }

        return answerArr;
        
    }
}