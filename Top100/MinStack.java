class MinStack {
    
    int MAX_SIZE=30000;
    int[] dataArray;
    int[] minValueArray;
    int top=-1;
    int minIndex=-1;

    public MinStack() {
        dataArray = new int[MAX_SIZE];
        minValueArray = new int[MAX_SIZE];
    }
    
    public void push(int val) {
        if(top>=MAX_SIZE) throw new RuntimeException("Stack is full");
        dataArray[++top] = val;
        if( minIndex == -1 || val<=minValueArray[minIndex]){
            minValueArray[++minIndex] = val;
        }
    }
    
    public void pop() {
        if(top == -1) throw new RuntimeException("Stack is empty");
        int val = dataArray[top--];
        if(val == minValueArray[minIndex])
            minIndex--;
    }
    
    public int top() {
        return dataArray[top];
    }
    
    public int getMin() {
        return minValueArray[minIndex];
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
