package in_class_exercises_CS202.exercise8;

public class in_class_exercise8 {
    public static void main(String[] args) {
        MyStack s = new MyStack(5);

        if (s.isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println("Stack is NOT empty!");
        }

        s.push(10);
        s.display();
        s.push(20);
        s.display();
        s.push(30);
        s.display();
        s.push(40);
        s.display();
        s.push(50);
        s.display();

        if (s.isFull()) {
            System.out.println("Stack is full!");
        } else {
            System.out.println("Stack is NOT full!");
        }

        s.display();

        System.out.println("The top value "+ s.pop()+ " is popped out!");
        s.display();
    }
}
