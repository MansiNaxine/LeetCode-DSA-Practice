class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {

        int n = nums.length;
        int m = queries.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        //we will insert elements into map first
        for(int i = 0; i < n; i++) {
            if(map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], new ArrayList<>(list));
            }
        }


        // we will now iterate through queries

                 for(int i = 0; i < m; i++) {
                        if( map.get(x) == null ||  queries[i] > map.get(x).size()) {
                        queries[i] = -1;
                        } else {
                            queries[i] = map.get(x).get(queries[i] - 1);
                        }
            
                }
       

        return queries;
        
    }
}