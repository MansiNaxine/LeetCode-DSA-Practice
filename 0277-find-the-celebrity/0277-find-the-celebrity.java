/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {

    //    return optimalApproach(n);

    return bruteForceApproach(n);
        
    }

    public int bruteForceApproach(int n) {
        //we have to take two arrays
        int[] iKnow = new int[n];
        int[] knowsMe = new int[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if((i != j) && knows(i, j)) {
                    iKnow[i]++;
                    knowsMe[j]++;
                }
            }
        }

        int ans = -1;

        for(int i = 0 ; i < n; i++) {
            if(iKnow[i] == 0 && knowsMe[i] == n - 1) {
                ans = i;
                break;
            }
        }

        return ans;
    }

    public int optimalApproach(int n) {
        int top = 0;
        int down = n - 1;

        while(top < down) {
            if(knows(top, down)) {
                top++;
            }
            else if (knows(down, top)) {
                down--;
            }
            else {
                top++;
                down--;
            }
        }

        int cnt = 0;
        for(int i = 0 ; i < n; i++) {
            if(top != i) {
                if(!knows(top, i) && knows(i, top)) cnt++;
            }
            
        }
        
        return cnt == n - 1 ? top : -1;

    }
}