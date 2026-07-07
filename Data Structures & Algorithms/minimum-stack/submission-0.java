class MinStack {
    int size;
    ArrayList<Integer> stack;
    ArrayList<Integer> minStack;

    public MinStack() {
        size = 0;
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }
    
    public void push(int val) {
        if( size == 0) {
            minStack.add(val);
        } else {
            minStack.add(Math.min(val, minStack.get(size-1)));
        }
        stack.add(val);
        size++;
    }
    
    public void pop() {
        if(size <= 0) {
            return;
        } 
        stack.remove(size-1);
        minStack.remove(size-1);
        size--;
        
    }
    
    public int top() {
        if( size <=0 ) {
            return -1;
        }
        return stack.get(size-1);
    }
    
    public int getMin() {
        return minStack.get(size-1);
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */