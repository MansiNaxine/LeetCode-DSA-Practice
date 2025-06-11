class Solution {
    public String removeDuplicates(String s, int k) {

        //first take stack of list, in which list will contains all the caharcaters and there frequency
        Stack<List<Integer>> st = new Stack<>();
        int n = s.length();

        for(int i = 0 ; i < n; i++) {
            
            if(st.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                list.add((int)s.charAt(i));
                list.add(1);

                st.push(list);
            } else {

                char ch = (char)(int)st.peek().get(0);
                int freq = st.peek().get(1);

                if(ch == s.charAt(i)) {
                    freq++;
                    List<Integer> sameChar = st.peek();
                    sameChar.set(1, freq);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add((int)s.charAt(i));
                    list.add(1);

                    st.push(list);
                }


                if(freq == k) {
                st.pop();
                }
            }
            
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()) {

            char ch = (char)(int)st.peek().get(0);
            int freq = st.peek().get(1);
         
                
                while(freq > 0) {
                    sb.append(ch);
                    freq--;
                 }
                 st.pop();
            
        }

        return sb.reverse().toString();

        
    }
}