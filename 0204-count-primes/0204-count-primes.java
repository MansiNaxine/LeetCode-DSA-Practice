class Solution {

    int N = 5000000;
    boolean arr[] = new boolean[N];

    public int countPrimes(int n) {

        for(int i = 0; i < n; i++) {
            arr[i] = true;
        }

        arr[0] = false;
        arr[1] = false;

        for(int i = 4; i < n; i+=2) {
            arr[i] = false;
        }

        for(long i = 3; i < n; i+=2) {
            if(arr[(int)i]) {
                for(long j = i * i ; j < n; j+=i) {
                    arr[(int)j] = false;
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i]) {
                answer++;
            }
        }

        return answer;
    }
}