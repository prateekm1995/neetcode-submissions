class Solution {
    public String minWindow(String s, String t) {
        String result = new String();
        int l=0,r=0;
        //target map
        Map<Character, Integer> target = new HashMap();
        Map<Character, Integer> tracker = new HashMap();

        for(char c: t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
            tracker.put(c, 0);
        }

        

        if(t.length() > s.length()) {
            return result;
        }

        while(r<s.length()) {
            if( l < r){
                if(isWindowComplete(target, tracker)){
                    if(result.isEmpty() || result.length() > (r-l)) {
                        result = s.substring(l, r);
                    }
                    tracker.put(s.charAt(l), tracker.get(s.charAt(l)) - 1);
                    l++;
                    while(l < r && !target.keySet().contains(s.charAt(l))) {
                        l++;
                    }
                } else {
                    if(tracker.keySet().contains(s.charAt(r))) {
                        tracker.put(s.charAt(r), tracker.get(s.charAt(r)) + 1);
                    }
                    r++;
                }
            } else {
                if(tracker.containsKey(s.charAt(l))) {
                    tracker.put(s.charAt(r), tracker.get(s.charAt(r)) + 1);
                    r++;
                } else {
                    l++;
                    r++;
                }
            }
        }
        while(isWindowComplete(target, tracker)){
            if(result.isEmpty() || result.length() > (r-l)) {
                result = s.substring(l, r);
            }
            tracker.put(s.charAt(l), tracker.get(s.charAt(l)) - 1);
            l++;
            while(l < r && !target.keySet().contains(s.charAt(l))) {
                l++;
            }
        }

        return result;
    }

    private boolean isWindowComplete(Map<Character, Integer> target, Map<Character, Integer> tracker) {
        for(Character key : target.keySet()) {
            if(tracker.get(key) < target.get(key)) {
                return false;
            }
        }
        return true;
    }
}
