package in_class_exercises_CS202.exercise6;

public class Node {
    //data fields 
    public int data; 
    public Node next;


    //methods
    public Node(int data){
        this.data=data;
        next=null;


    }

    public Node(int data, Node nodeRef){
        this.data=data;
        next=nodeRef; 


    }




    
}
