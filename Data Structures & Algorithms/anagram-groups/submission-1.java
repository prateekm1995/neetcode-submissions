class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for( String s : strs) {
            String sign = new String(sign(s));

            if(!map.containsKey(sign)) {
                map.put(sign, new ArrayList<>());
            }
            map.compute(sign, (k,v) -> { v.add(s); return v;} );
        }

        List<List<String>> result = new ArrayList<>();

        for(String k : map.keySet()) {
            result.add(map.get(k));
        }

        return result;
    }

    private static char[] sign(String s) {
        char[] sign = new char[26];
        for(char c : s.toCharArray()) {
            sign[c - 'a']++;
        }
        return sign;
    }
}