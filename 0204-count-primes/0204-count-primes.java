class Solution {
    public int countPrimes(int n) {

        //Seive of Eranthosises
        boolean isPrime[]=new boolean[n+1];
        for(int i=1;i<isPrime.length;i++){
            isPrime[i]=true;
        }

        for(int i=2;i<isPrime.length;i++){
            if(isPrime[i]==true){
                for(int j=2*i;j<isPrime.length;j +=i){
                    isPrime[j]=false;
                }
            }
        }

        int count=0;

        for(int i=2;i<isPrime.length;i++){
            if(isPrime[i]==true && i<n){
                count++;
            }
        }

        return count;
        
    }
}