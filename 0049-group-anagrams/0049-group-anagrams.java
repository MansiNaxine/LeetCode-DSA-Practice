class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        int n = strs.length;
        List<List<String>> answer = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String str = strs[i];
            str = sortString(strs[i]);

            if(map.containsKey(str)) {
                map.get(str).add(strs[i]);
            } else {
                List<String> arr = new ArrayList<>();
                arr.add(strs[i]);
                map.put(str, new ArrayList<>(arr));
            }
        }

        for(String key: map.keySet()) {
            List<String> arr = map.get(key);
            answer.add(new ArrayList<>(arr));
        }

        return answer;
        
    }

    public String sortString(String str) {

        char[] ch = str.toCharArray();
        Arrays.sort(ch);

        String str1 = new String(ch);

        //there is also one way to use stringBuilder and append all characters

        return str1;
    }
}