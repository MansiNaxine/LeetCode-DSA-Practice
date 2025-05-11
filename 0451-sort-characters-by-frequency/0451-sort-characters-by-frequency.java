class Solution {
    public String frequencySort(String s) {
        
        //first for the frequence array
        int n = s.length();
        int freq[] = new int[256];

        for(int i = 0; i < n; i++) {
            freq[s.charAt(i)]++;
        }

        //we will for the arrayList and we will include characters and their frequnecy to sort it later
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        for(int i = 0; i < 256; i++) {
            if(freq[i] != 0) {

                ArrayList<Integer> currSeq = new ArrayList<>();

                currSeq.add(i);
                currSeq.add(freq[i]);

                answer.add(new ArrayList<>(currSeq));
            }
        }
        
        //use Custom comparator to sort the list based on freq
        Collections.sort(answer, (x, y) -> Integer.compare(x.get(1), y.get(1)));
        Collections.reverse(answer);

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < answer.size(); i++) {
            char ch = (char)(int)answer.get(i).get(0);
            int fr = answer.get(i).get(1);

            while(fr > 0) {
                str.append(ch);
                fr--;
            }
        }

        return str.toString();

    }
}