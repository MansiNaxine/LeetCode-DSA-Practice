class Solution {
    public int countPrimes(int n) {

         int[] primeNumArray = new int[n + 1];
        
        for(int i = 2; i < primeNumArray.length; i++) {
            primeNumArray[i] = 1;
        }

        //Using Seive of Eratosthenes
        for(int i = 2; i * i <= n; i++) {
            if(primeNumArray[i] == 1) {
                for(int j = i * i; j <= n; j += i) {
                    primeNumArray[j] = 0;
                }
            }
        }

        int count = 0;

        for(int i = 2; i < n; i++) {
            count += primeNumArray[i];
        }

        return count;
        
    }
}