class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //maintain Indegree Values
        int[] indegree = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }
        
        //First create an adjancyList
        List<List<Integer>> adjancyList = new ArrayList<>();
        for(int i = 0 ; i < numCourses; i++) {
            adjancyList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            
            adjancyList.get(v).add(u);
            
        }
        
        Queue<Integer> que = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) que.add(i);
        }
        
        int cnt = 0;
        
        while(!que.isEmpty()) {
            int top = que.remove();
            cnt++;
            
            for(int ele : adjancyList.get(top)) {
                indegree[ele]--;
                if(indegree[ele] == 0) que.add(ele);
            }
        }
        
        return cnt == numCourses;
    }
}