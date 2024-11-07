class Solution {
    public int[][] merge(int[][] intervals) {

        //1.Copy elements from 2D array into ArrayList

        ArrayList<ArrayList<Integer>> list=new ArrayList<>();

        int n= intervals.length;

        for(int i=0;i<n;i++){

            ArrayList<Integer> currList=new ArrayList<>();
            currList.add(intervals[i][0]);
            currList.add(intervals[i][1]);

            list.add(new ArrayList<>(currList));
        }

        //2.Sort ArrayList based on first element

        Collections.sort(list,(x,y)->Integer.compare(x.get(0),y.get(0)));

        

        //Now take left and right and merge it

        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();


        ans.add(new ArrayList<>(list.get(0)));

        int L=ans.get(0).get(0);
        int R=ans.get(0).get(1);

        for(int i=1;i<list.size();i++){

            int x=list.get(i).get(0);
            int y=list.get(i).get(1);

            if(x >= L && x <= R){

                ans.get(ans.size()-1).set(1,Math.max(R,y));

            }else{

                ans.add(new ArrayList<>(list.get(i)));
            }

            L=ans.get(ans.size()-1).get(0);
            R=ans.get(ans.size()-1).get(1);

        }

        int[][] answer=new int[ans.size()][2];

        //3.copy elements from list into 2D array
        for(int i=0;i<ans.size();i++){

            answer[i][0]=ans.get(i).get(0);
            answer[i][1]=ans.get(i).get(1);
        }

        return answer;
        
    }
}