class Solution {
    public String removeDuplicates(String s, int k) {

        //first form the stack and store arrayList inside that which will contain ASCII value of character + frequency of that same character

        Stack<ArrayList<Integer>> stack = new Stack<>();

        //iterate through string
        for(int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()) {
                ArrayList<Integer> curr = new ArrayList<>();
                curr.add((int)s.charAt(i));
                curr.add(1);

                stack.push(curr);
            } else {
                ArrayList<Integer> topElement = stack.peek();
                int topCharacter = topElement.get(0);
                int topCharFreq = topElement.get(1);
                if(topCharacter == (int)s.charAt(i)) {
                    topElement.set(1, topCharFreq+1);
                } else {
                    ArrayList<Integer> curr = new ArrayList<>();
                    curr.add((int)s.charAt(i));
                    curr.add(1);

                    stack.push(curr);
                }

                
            }

            if(stack.peek().get(1) == k) stack.pop();
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            ArrayList<Integer> topElement = stack.peek();
            int freq = topElement.get(1);
            while(freq > 0) {
                sb.append((char)(int)topElement.get(0));
                freq--;
            }
            stack.pop();
            
        }

        return sb.reverse().toString();
        
    }
}