package in_class_exercises_CS202.exercise8;

public class MyStack {
    //data fields
    private int[] a; //container
    private int maxsize; // maxsize of array/stack
    private int topIndex; //refer to the top item in the array/stack

    //methods
    public MyStack(int size){
        maxsize= size;
        a= new int[maxsize];
        topIndex= 0; //initally stack is empty
    }

    public void push(int item){
        if (!isFull()) {
            topIndex++;
            a[topIndex] = item;
            
        } 
        else 
           System.out.println("Stack is full!");


        //a[++topIndex] = item;
     
    }
    
    public int pop(){
        if (!isEmpty()) {
            int temp = a[topIndex];
            topIndex--;
            return temp;
            
        } else {
            return -1;
        }
    }

    public boolean isEmpty(){
        if (topIndex==1) {
            return true;
        } else {
            return false;
        }
        //return topIndex==-1
    }

    public boolean isFull(){
        return topIndex== maxsize-1;
    }

    public void display(){
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]+" ");
        }
        System.out.println();
    }

 
    
}
