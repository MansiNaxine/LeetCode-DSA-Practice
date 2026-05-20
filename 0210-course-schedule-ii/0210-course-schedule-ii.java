class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        //solve by using Kahn's Algroithm
        int[] inArr = new int[numCourses];
        int n = prerequisites.length;

        //inArr implementation
        for(int i = 0; i < n; i++) {
            inArr[prerequisites[i][0]]++;
        }

        //Adjancy List Implementation
        List<List<Integer>> adjancyList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adjancyList.add(new ArrayList<>());
        }

        //Create an adjancyList;
        for(int i = 0; i < n; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adjancyList.get(v).add(u);
        }

        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inArr[i] == 0) que.add(i);
        }

        List<Integer> topoArr = new ArrayList<>();
        while(!que.isEmpty()) {
            int top = que.remove();
            topoArr.add(top);

            for(int ele : adjancyList.get(top)) {
                inArr[ele]--;
                if(inArr[ele] == 0) que.add(ele);
            }
        }

        int[] ans = new int[topoArr.size()];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = topoArr.get(i);
        }


        return ans.length == numCourses ? ans : new int[]{};
    }
}