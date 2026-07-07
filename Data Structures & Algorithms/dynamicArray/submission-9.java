class DynamicArray {
    int size;
    int cap;
    int[] arr;

    public DynamicArray(int capacity) {
        size=0;
        arr = new int[capacity];
        this.cap = capacity;
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
        
    }

    public void pushback(int n) {

        if(size == cap) {
            this.resize();
        }

        arr[size] = n;
        size++;
    }

    public int popback() {
        
        return arr[--size];
        

    }

    private void resize() {
        cap = cap*2;
        int[] newarr = new int[cap];
        for(int i=0 ; i< size ; i++) {
            newarr[i] = arr[i];
        }
        arr = newarr;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return cap;
    }

}
