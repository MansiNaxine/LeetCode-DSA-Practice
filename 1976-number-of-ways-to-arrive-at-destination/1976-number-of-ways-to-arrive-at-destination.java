class Solution {
    public int countPaths(int n, int[][] roads) {
        
        //Creat an adjancyList;
        List<List<List<Integer>>> adjancyList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjancyList.add(new ArrayList<>());
        }

        for(int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int d = roads[i][2];

            List<Integer> currList1 = new ArrayList<>();
            currList1.add(v);
            currList1.add(d);

            List<Integer> currList2 = new ArrayList<>();
            currList2.add(u);
            currList2.add(d);

            adjancyList.get(u).add(new ArrayList<>(currList1));
            adjancyList.get(v).add(new ArrayList<>(currList2));
        }

        //take Path arrays
        //also take distance array
        long[] distance = new long[n]; //Distance can be long
        int[] path = new int[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[0] = 0;
        path[0] = 1;
        int modVal = (int)1000000007;

        PriorityQueue<Pair> que = new PriorityQueue<>((x, y) -> Long.compare(x.dist , y.dist));
        Pair p = new Pair(0, 0);
        que.add(p);

        while(!que.isEmpty()) {
            Pair inner = que.remove();
            long currDist = inner.dist;
            int currNode = inner.node;

            for(List<Integer> list : adjancyList.get(currNode)) {
                long innerDist = list.get(1);
                int innerNode = list.get(0);
                if((currDist + innerDist) < distance[innerNode]) {
                    path[innerNode] = path[currNode];
                    distance[innerNode] = currDist + innerDist;
                    Pair innerP = new Pair((currDist + innerDist), innerNode);
                    que.add(innerP);
                }
                else if ((currDist + innerDist) == distance[innerNode]) {
                    path[innerNode] = (path[innerNode] + path[currNode])%modVal;
                }
            }
        }

        
        return path[n - 1]%modVal;

    }
}

class Pair {
    long dist;
    int node; 
    Pair(long dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}