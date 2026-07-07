class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        List<String> input = new ArrayList<>(Arrays.asList(strs));

        while (!input.isEmpty()) { 
            List<String> temp = new ArrayList<>();

            temp.add(input.get(0));
            input.remove(0);

            for(int i=0 ; i< input.size(); i++) {
                if (checkAnagram(temp.get(0), input.get(i))) {
                    temp.add(input.get(i));
                    input.remove(i);
                    i--;
                }        
            }

            result.add(temp);
        }

        return result;

    }

    public static Boolean checkAnagram(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;

        HashMap<Character, Integer> map  = new HashMap<>();

        for(char c : s1.toCharArray()){
            map.compute(c, (k,v) -> v==null?1 : v+1);
        }

        for(char c : s2.toCharArray()){
            if(!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }

            map.compute(c, (k,v) -> v-1);
        }
        return true;
    }
}
