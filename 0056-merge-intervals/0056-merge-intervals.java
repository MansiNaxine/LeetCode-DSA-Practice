class Solution {
    public int[][] merge(int[][] intervals) {
        //first we have to take arrayList then we can apply custom comparator
        int n = intervals.length;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            ArrayList<Integer> currSeq = new ArrayList<>();
            currSeq.add(intervals[i][0]);
            currSeq.add(intervals[i][1]);

            arr.add(new ArrayList<>(currSeq));
        }

        //apply custom comparator
        Collections.sort(arr, (x, y) -> Integer.compare(x.get(0), y.get(0)));

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>(arr.get(0)));

        int Left  = arr.get(0).get(0);
        int Right = arr.get(0).get(1);

        for(int i = 1; i < arr.size(); i++) {
                
                if(arr.get(i).get(0) >= Left && arr.get(i).get(0) <= Right) {

                    answer.get(answer.size()-1).set(1, Math.max(arr.get(i).get(1), Right));

                } else {
                    answer.add(new ArrayList<>(arr.get(i)));
                }

                Left  = answer.get(answer.size()-1).get(0);
                Right = answer.get(answer.size()-1).get(1);
        }

        int N = answer.size();
        int[][] answerFinal = new int[N][2];
        for(int i = 0; i < N; i++) {
            answerFinal[i][0] = answer.get(i).get(0);
            answerFinal[i][1] = answer.get(i).get(1);
        }

        return answerFinal;

    }
}