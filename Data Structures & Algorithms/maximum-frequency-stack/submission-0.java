class FreqStack {
    List<Deque<Integer>> list;
    Map<Integer, Integer> map;

    public FreqStack() {
        list = new ArrayList<Deque<Integer>>();
        map = new HashMap<Integer, Integer>();
    }
    
    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        int freq = map.get(val);
        if( freq > list.size()) {
            list.add(new ArrayDeque<Integer>());
        }
        list.get(freq-1).push(val);
    }
    
    public int pop() {
        int val;
        val = list.get(list.size() - 1).poll();
        if(list.get(list.size() -1).isEmpty()) {
            list.remove(list.size() -1 );
        }
        map.put(val, map.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */