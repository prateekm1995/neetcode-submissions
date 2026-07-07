class TimeMap {
    HashMap<String, ArrayList<Pair>> map;

    public TimeMap() {
        map = new HashMap();        
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        ArrayList<Pair> list = map.getOrDefault(key, new ArrayList<>());

        if(!list.isEmpty()){
            return search(list, timestamp);
        }   
        return "";     
    }

    private String search(ArrayList<Pair> list, int timestamp) {
        int l=0, r= list.size()-1;
        String ans=""; 

        while( l<=r) {
            int mid = (l+r)/2;

            if(list.get(mid).timestamp > timestamp) {
                r = mid-1;
            } else {
                ans = list.get(mid).value;
                l = mid+1;
            }
        }
        return ans;
    }

    private class Pair {
        String value;
        int timestamp;

        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
