package in_class_exercises_CS202.exercise6;

public class MyList {
    //data fields
    private Node head= null;
    private int size= 0; 

    public MyList(){
        head= null;
        size= 0; 
    }
    //methods
    //a
    public int front(){
        return head.data; 
    }
    
    //b
    public int size(){
        return size; 
    }

    //c
    public void insert_head(int insert_me){
        //step 1- create new node
        Node temp = new Node(insert_me); 
        //step 2- assign the old head as the next node for the new node
        temp.next= head; 
        //step 3- assign the new node as the head of the LL
        head= temp; 
        // head= new Node(insert_me_head);
        size++;
    }

    //d
    public void delete_head(){
        //asign the second node in the list as the head
        head= head.next;
        size--;
    }

    //e
    public void display(){
        for (Node temp = head; temp != null; temp = temp.next) 
        {
            System.out.print("->"+ temp.data);
        }
        System.out.println();
    }
    
    //f
    public int get_back(){
        //step 1- use loop strucutre to find the last node and stop
        //print the value in the last node
    
        for (Node temp = head; temp.next != null; temp = temp.next) 
        {
            System.out.print(temp.next); 

        }
        System.out.println();
    }

    //g
    public void insert_back(int insert_me){
        //step 1- create a new node 

        //step 2- use loop structure to find the last node (copy paste)

        //step 3- assign the new node as the next node for the last node


    }

    //h
    public void delete_back(){
        //step 1- use loop to find second to last node
        
        //step 2- assign null to be the next value for second to last node- temp.next.next!= null; temp.next.next = null;- at the second to last node 


    }

    //i
    public boolean search(int target){
        //
    }

    //j
    public void insert(int after_me, int insert_me){
        //step 1- create new node - insert_me node
        //step 2- use loop to find the  after_me node you're going to insert behind 
        //step 3- assign the next node of the after_me node as the next node of the new node
        //assign the temp.next as the new node for insert_me node
        //step 4- assign the new node as the next node of the after_me node
        size++;

    }

    //k
    public void remove(int delete_me){
        //step 1- use loop to find the node before the delete_me node- call it temp
        //step 2- assign the next node of temp as the next node of temp
        


        size--;

    }




}
