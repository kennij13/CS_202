package program_assignments_CS202.program_assignment3; 

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
