class Solution {

    public String minWindow(String s, String t) {
        String ans = new String();
        Map<Character, Integer> target = new HashMap();
        Map<Character, Integer> tracker = new HashMap();    
        int formed, required;

        for(char a: t.toCharArray()) {
            target.put(a,target.getOrDefault(a,0) + 1);
            tracker.put(a,0);
        }
        required = target.size();
        formed = 0;
        int l=0,r=0;

        while(r < s.length()) {
            if(l==r) {
                if(target.keySet().contains(s.charAt(r))) {
                   formed = increaseTracker(s.charAt(r), target, tracker, formed, required);
                } else {
                    l++;
                }
                r++;
            } else {
                if(formed == required) {
                    if(ans.isEmpty() || ans.length() > r-l) {
                        ans = s.substring(l,r);
                    }
                    formed = decreaseTracker(s.charAt(l), target, tracker, formed, required);
                    l++;
                    while(l<r && !target.keySet().contains(s.charAt(l))){
                        l++;
                    }
                } else {
                    if(target.keySet().contains(s.charAt(r))) {
                        formed = increaseTracker(s.charAt(r), target, tracker, formed, required);
                    } 
                    r++;
                }
            }

        }
        while(formed == required) {
            if(ans.isEmpty() || ans.length() > r-l) {
                ans = s.substring(l,r);
            }
            if(target.keySet().contains(s.charAt(l))){

            formed = decreaseTracker(s.charAt(l), target, tracker, formed, required);
            }
            l++;
        }
        return ans;
    }

    private int increaseTracker(char a, Map<Character, Integer> target,Map<Character, Integer> tracker, int formed, int required) {
        tracker.put(a, tracker.get(a) +1);
        if(tracker.get(a) == target.get(a)) {
            formed++;
        }
        return formed;
    }
    
    private int decreaseTracker(char a, Map<Character, Integer> target,Map<Character, Integer> tracker, int formed, int required) {
        tracker.put(a, tracker.get(a) -1);
        if(tracker.get(a) == target.get(a) - 1) {
            formed--;
        }
        return formed;
    }
    
}

