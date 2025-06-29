class Solution {
    public int orangesRotting(int[][] grid) {

        //first take a queue of ArrayList, where we will save indexes of rotten oranges
        Queue<ArrayList<Integer>> q = new LinkedList<>();

        //for time matrix, where we will save time required to rotten adjacent oranges 
        int n = grid.length;
        int m = grid[0].length;

        int[][] time = new int[n][m];

        //we will save each element in matrix with -1 
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(grid[i][j] == 2) {
                    time[i][j] = 0;
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(i);
                    arr.add(j);

                    q.add(arr);

                } else {
                    time[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()) {
            ArrayList<Integer> firstElement = q.remove();
            int i = firstElement.get(0);
            int j = firstElement.get(1);

            //for UP direction , we will check if any fresh orange is present
            if(i >= 1 && grid[i - 1][j] == 1) {
                time[i -  1][j] = time[i][j] + 1;
                grid[i - 1][j] = 2;
                ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(i - 1);
                    arr.add(j);

                    q.add(arr);
            }

            //for DOWN direction , we will check if any fresh orange is present
            if(i + 1 < n && grid[i + 1][j] == 1) {
                time[i + 1][j] = time[i][j] + 1;
                grid[i + 1][j] = 2;
                ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(i + 1);
                    arr.add(j);

                    q.add(arr);
            }

            //for LEFT direction , we will check if any fresh orange is present
            if(j >= 1 && grid[i][j -  1] == 1) {
                time[i][j -  1] = time[i][j] + 1;
                grid[i][j - 1] = 2;
                ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(i);
                    arr.add(j - 1);

                    q.add(arr);
            }

            //for UP direction , we will check if any fresh orange is present
            if(j + 1 < m && grid[i][j + 1] == 1) {
                time[i][j + 1] = time[i][j] + 1;
                grid[i][j + 1] = 2;
                ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(i);
                    arr.add(j + 1);

                    q.add(arr);
            }
        }


        //now calculate maximum time
        int answer = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                } else if (grid[i][j] == 2){
                    answer = Math.max(answer, time[i][j]);
                }
            }
        }

        return answer;
        
    }
}