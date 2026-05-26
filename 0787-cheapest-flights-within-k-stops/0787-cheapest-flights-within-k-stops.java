class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //Create an adjancyList
        List<List<List<Integer>>> adjancyList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjancyList.add(new ArrayList<>());
        }

        for(int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int p = flights[i][2];

            List<Integer> currList = new ArrayList<>();
            currList.add(v);
            currList.add(p);

            adjancyList.get(u).add(new ArrayList<>(currList));
        }

        int[] priceArr = new int[n];
        Arrays.fill(priceArr, Integer.MAX_VALUE);

        Queue<FlightsInfo> que = new LinkedList<>();
        FlightsInfo fi = new FlightsInfo(0, src, 0);
        priceArr[src] = 0;
        que.add(fi);

        while(!que.isEmpty()) {
            FlightsInfo innerInfo = que.remove();
            int step = innerInfo.steps;
            int root = innerInfo.destination;
            int cost = innerInfo.price;
            
            for(List<Integer> list : adjancyList.get(root)) {

                int dest = list.get(0);
                int currPrice = list.get(1);
                int newSteps = step + 1;
                if (newSteps <= k + 1 && (currPrice + cost) < priceArr[dest]) {
                    priceArr[dest] = currPrice + cost;
                    FlightsInfo newFi = new FlightsInfo(newSteps, dest, currPrice + cost);
                    que.add(newFi);
                }
            }
        }

        return priceArr[dst] == Integer.MAX_VALUE ? -1 : priceArr[dst];
        
    }
}

class FlightsInfo {

    int steps;
    int destination;
    int price;

    FlightsInfo(int steps, int destination, int price) {
        this.steps = steps;
        this.destination = destination;
        this.price = price;
    }

}