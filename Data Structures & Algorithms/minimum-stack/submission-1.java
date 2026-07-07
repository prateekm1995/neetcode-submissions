class MinStack {
    Deque<Integer> stack;
    Deque<Integer> min;

    public MinStack() {
        stack = new ArrayDeque();
        min = new ArrayDeque();
    }
    
    public void push(int val) {
        stack.push(val);
        min.push(Math.min((min.peek() != null ? min.peek() : Integer.MAX_VALUE), val));
    }
    
    public void pop() {
        min.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
