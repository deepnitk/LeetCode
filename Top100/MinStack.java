class MinStack {

	public int maxStackSize = 30000;    // given in the problem, max operations as 30000, meaning we can never push more than that
    public int minValue = 2147483647; // upper boundary for minimum value, which will become the "minimum value" that appears as values are added to the stack
    public int top = 0; // a pointer that tells us the index of the most recent element added to the "stack" array
        
    public int[] stack = new int [maxStackSize]; // the "stack" array
    
	public int pointer = 0; // a pointer that tells us the index of the most recent smallest number added to the minValuesStack array
    public int[] minValuesStack = new int [maxStackSize]; //the minvauesStackArray

    public MinStack() { // constructor, we already initialize our variables, so nothing is needed here
        
    }
    
    public void push(int val) {
        if (val <= this.minValue){ // check if new value is less than our minValue, if it is, set the new minimum value, add it to the minimum value stack, and move the pointer
            this.minValue = val;
            this.minValueStack[pointer] = val;
            this.pointer = this.pointer + 1;
        }
        this.stack[this.top]= val; // always add data to stack when pushing, even if its not a minimum value
        this.top = this.top + 1; //move the pointer
    }
    
    public void pop() {
   
        if (this.stack[this.top-1] == this.minValue){ //check if the value being popped is the minimum value, if it is, move our pointer and remove the value from the minimum value stack
            this.pointer = this.pointer - 1; 
            this.minValueStack[this.pointer] = 0;
            
            if (this.pointer -1 < 0){ //if our pointer is less than 0, (ie 0) , then that means there is only 1 item on the stack, set that as minimum value
                this.minValue = this.stack[0];
            } else {
                this.minValue = this.minValueStack[this.pointer-1]; //otherwise, its the most recent added value in the minValueStack
            }      
        } else {
			//empty
        }
        this.top = this.top - 1; //even if the value isnt the minimum, we must remove it from the stack
        this.stack[this.top] = 0;           
        
    }
    
    public int top() {
        if (this.top == 0) //if the top variable is 0 (remember its an index), that means the stack is empty
            return 0;
        else 
            return this.stack[this.top-1]; //return the top of the stack
    }
    
    public int getMin() {
        
        if (this.pointer == 0) return stack[0];
        else return this.minValue;
    }
    
}
