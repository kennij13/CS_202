package program_assignments_CS202.program_assignment3;
import java.util.*;

public class program_assingment3 {
    public static void main(String[] args) {
        MyList list1= new MyList();
        Scanner keyboard= new Scanner(System.in);
        list1.insert_head(50);
        list1.insert_head(40);
        list1.insert_head(30);
        list1.insert_head(20);
        list1.insert_head(10);
        System.out.print("The list: ");
        list1.display(); 
        list1.delete_head();
        System.out.print("The list after the head has a been deleted: ");
        list1.display();
        list1.insert_back(60);
        System.out.print("The list after a node is inserted as the last item in the list: ");
        list1.display();
        list1.delete_back();
        System.out.print("The list after the last node has been deleted: ");
        list1.display();
        System.out.print("How many numbers would you like to search for? ");
        int numberOfSearches = keyboard.nextInt();
        for (int i = 0; i < numberOfSearches; i++) {
            System.out.print("Enter a number to search for: ");
            int numberSearch= keyboard.nextInt();
            System.out.println("The number " +numberSearch+ " being in the list is:" + list1.search(numberSearch));
        }
        list1.insert(40, 45);
        System.out.print("The list after a node is inserted: ");
        list1.display();
        list1.remove(45);
        System.out.print("The list after a node is deleted: ");
        list1.display();
        System.out.println("The first node is: " + list1.front());
        System.out.println("The size of the list is: " + list1.size());
        System.out.println("The last node in the list is: " + list1.get_back());
        keyboard.close();
        

    }
}
