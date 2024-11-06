class Solution {
    public String frequencySort(String s) {

        //1. Form frequency array
        int freq[]=new int[256];
        int n=s.length();

        for(int i=0;i<n;i++){

            char currentChar=s.charAt(i);
            int val=currentChar;
            freq[val]++;
        }

        //2. Create ArrayList of ArrayList and copy all elements along with their frequencies into list

        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();

        for(int i=0;i<freq.length;i++){

            //if freq is not zero means element needs to add into arr
            if(freq[i]!=0){

                ArrayList<Integer> currSeq=new ArrayList<Integer>();
                currSeq.add(i);
                currSeq.add(freq[i]);

                arr.add(new ArrayList<>(currSeq));
            }

        }

        //3. Sort the list using Collections.sort
        Collections.sort(arr,(x,y)->Integer.compare(x.get(1),y.get(1)));
        Collections.reverse(arr);

        //4. Create StringBuilder and append the characters according to frequency

        StringBuilder sb=new StringBuilder("");

        for(int i=0;i<arr.size();i++){

            int fre=arr.get(i).get(1);
            char ch=(char)(int)arr.get(i).get(0);

            while(fre>0){
                sb.append(ch);
                fre--;
            }
        }

        return sb.toString();

    }
}