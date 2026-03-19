/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {

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