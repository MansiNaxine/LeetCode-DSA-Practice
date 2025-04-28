class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> currSeq = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        recursion(n, 0, arr, k);
        return answer;
    }

    public void recursion(int n, int index, int[] arr, int k) {

        //base case;
        if(n == 0) {
            if(currSeq.size() == k) {
                answer.add(new ArrayList<>(currSeq));
            }
            return;
        }

        //recursive case
        for(int i = index; i < arr.length; i++) {
            if(n >= arr[i]) {
                currSeq.add(arr[i]);
                recursion(n - arr[i], i+1, arr, k);
                currSeq.remove(currSeq.size() - 1);
            }
        }
    }
}