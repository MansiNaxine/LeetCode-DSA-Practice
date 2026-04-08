class Solution {
    public int[][] merge(int[][] intervals) {

        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        int n = intervals.length;

        for(int i = 0 ; i < n; i++) {
            List<Integer> currSeq = new ArrayList<>();
            currSeq.add(intervals[i][0]);
            currSeq.add(intervals[i][1]);

            list.add(new ArrayList<>(currSeq));
        }

        Collections.sort(list, (a, b) -> a.get(0).compareTo(b.get(0)));

        int start = list.get(0).get(0);
        int end = list.get(0).get(1);
        List<Integer> currSeq = new ArrayList<>();
        currSeq.add(start);
        currSeq.add(end);
        answer.add(new ArrayList<>(currSeq));

        for(int i = 1; i < n; i++) {
            int newStart = list.get(i).get(0);
            int newEnd = list.get(i).get(1);

            if(newStart <= end) {
                int min = Math.min(start, newStart);
                int max = Math.max(end, newEnd);
                
                answer.get(answer.size()-1).set(0, min);
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