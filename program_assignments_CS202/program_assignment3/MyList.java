package program_assignments_CS202.program_assignment3;

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
        int lastValue= head.data; 
        for (Node temp = head; temp.next != null; temp = temp.next) 
        {
            lastValue= temp.next.data; 
        }
        return lastValue;
    }

    //g
    public void insert_back(int insert_me){
        //step 1- create a new node 
        //step 2- use loop structure to find the last node (copy paste)
        //step 3- assign the new node as the next node for the last node
        Node newNode = new Node(insert_me);
        if (head == null) 
        {
            head = newNode;
        } else 
        {
            Node temp = head;
            while (temp.next != null) 
            {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;

    }

    //h
    public void delete_back(){
        //step 1- use loop to find second to last node
        //step 2- assign null to be the next value for second to last node- temp.next.next!= null; temp.next.next = null;- at the second to last node 
        if (head.next == null)
        {
            head = null;
        } else 
        {
            Node temp = head;
            while (temp.next.next != null) 
            {
                temp = temp.next;
            }
            temp.next = null;
        }
        size--;

    }

    //i
    public boolean search(int target){
        Node temp = head;
        while (temp != null) 
        {
            if (temp.data==target) 
            {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    //j
    public void insert(int after_me, int insert_me){
        //step 1- create new node - insert_me node
        Node newNode= new Node(insert_me);
        //step 2- use loop to find the  after_me node you're going to insert behind 
        //step 3- assign the next node of the after_me node as the next node of the new node
        //assign the temp.next as the new node for insert_me node
        //step 4- assign the new node as the next node of the after_me node
        for(Node temp = head; temp != null; temp = temp.next){
            if (temp.data == after_me) 
            {
                newNode.next= temp.next;
                temp.next= newNode;
                size++;
                
            }
        }
        

    }

    //k
    public void remove(int delete_me){
        //step 1- use loop to find the node before the delete_me node- call it temp
        //step 2- assign the next node of temp as the next node of temp
        Node temp = head; 
        for(temp = head; temp.next != null && temp.next.data != delete_me;){
            temp = temp.next;
        }
        if (temp.next != null) 
        {
            temp.next = temp.next.next;
            size--;
        }
    }
       
    
       
    




}
