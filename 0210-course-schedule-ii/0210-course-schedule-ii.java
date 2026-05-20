class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        //solve by using Kahn's Algroithm
        int[] inArr = new int[numCourses];
        int n = prerequisites.length;

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
            inArr[u]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inArr[i] == 0) que.add(i);
        }

        int[] ans = new int[numCourses];
        int index = 0;
        while(!que.isEmpty()) {
            int top = que.remove();
            ans[index] = top;
            index++;

            for(int ele : adjancyList.get(top)) {
                inArr[ele]--;
                if(inArr[ele] == 0) que.add(ele);
            }
        }

        return index == numCourses ? ans : new int[]{};
    }
}