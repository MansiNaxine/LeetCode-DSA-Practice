class Solution {
    int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        //First create an adjancyList
        List<List<Integer>> adjancyList = new ArrayList<>();
        int connLen = connections.size();

        for(int i = 0 ; i < n; i++) {
            adjancyList.add(new ArrayList<>());
        }

        for(int i = 0; i < connLen; i++) {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);

            adjancyList.get(u).add(v);
            adjancyList.get(v).add(u);
        }

        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        List<List<Integer>> bridges = new ArrayList<>();
        dfsTraversal(bridges, 0, -1, vis, tin, low, adjancyList);

        return bridges;
    }

    public void dfsTraversal(List<List<Integer>> bridges, int root, int parent, int[] vis, int[] tin, int[] low, List<List<Integer>> adjancyList) {
        vis[root] = 1;
        tin[root] = timer;
        low[root] = timer;
        timer++;

        for(int ele : adjancyList.get(root)) {
            if(ele == parent) continue;
            if(vis[ele] == 0) {
                dfsTraversal(bridges, ele, root, vis, tin, low, adjancyList);
                if(low[ele] > tin[root]) {
                    List<Integer> currList = new ArrayList<>();
                    currList.add(root);
                    currList.add(ele);
                    bridges.add(new ArrayList<>(currList));
                }
                low[root] = Math.min(low[ele], low[root]);
            }
            else {
                low[root] = Math.min(low[ele], low[root]);
            }
        }
    }
}