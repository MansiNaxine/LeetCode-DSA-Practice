class Solution {
    public boolean isHappy(int n) {
         int fast=n;
         int slow=n;

         do{
            slow=findSquare(slow);
            fast=findSquare(findSquare(fast));//just to move the fast pointer two times ahead
         }while(fast!=slow);

         if(slow==1){
            return true;
         }

        return false;
    }

    public int findSquare(int num){
        int ans=0;

        while(num>0){
            int rem=num%10;
            ans +=rem*rem;
            num /=10;
        }

        return ans;
    }
}