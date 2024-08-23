class Solution {
    public int numberOfSteps(int num) {
        
        return countSteps(num,0);
    }

    public int countSteps(int n, int c){
        if(n==0){
            return c;
        }

        if(n%2==0){
        return countSteps(n/2,c+1);
        }

        return countSteps((n-1),c+1);
    }
}