package in_class_exercises_CS202.exercise6;

public class exericse6 {
    public static void main(String[] args) {
        MyList list1= new MyList();
        list1.insert_head(40);
        list1.insert_head(30);
        list1.insert_head(20);
        list1.insert_head(10);

        list1.display(); 
        list1.delete_head();
        list1.display();
       
        System.out.println("The first node is: " + list1.front());
        System.out.println("The size of the list is: " + list1.size());

    }
}
