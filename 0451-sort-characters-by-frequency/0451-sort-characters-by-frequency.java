class Solution {
    public String frequencySort(String s) {

        //we will create frequncy array
        int[] freq=new int[256];

        int n = s.length();
        for(int i = 0; i < n; i++) {
            freq[s.charAt(i)]++;
        }
        
        //First we will take the arrayList
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        for(int i = 0; i < 256; i++) {
            if(freq[i] != 0) {
                ArrayList<Integer> currSeq = new ArrayList<>();
                currSeq.add(i);
                currSeq.add(freq[i]);

                answer.add(new ArrayList<>(currSeq));
            }
        }

        //we have to sort the arrayList
        Collections.sort(answer,(x, y) -> Integer.compare(x.get(1), y.get(1)));
        Collections.reverse(answer);

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < answer.size(); i++) {
            int ch = answer.get(i).get(0);
            int fr = answer.get(i).get(1);

            while(fr > 0) {
                str.append((char)ch);
                fr--;
            }

        }

        return str.toString();

    }
}