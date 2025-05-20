package in_class_exercises_CS202.exercise5;

public class exercise5 {
    public static void main(String[] args) {
        PhoneDirectory contacts = new PhoneDirectory();

        contacts.addOrChangeEntry("Tom", "217-000-0000");
        contacts.addOrChangeEntry("Nick", "223-000-0000");
        contacts.addOrChangeEntry("Mary", "213-000-0000");
        
        contacts.print();
        System.out.println();

        contacts.addOrChangeEntry("Nick", "223-111-1111");
        contacts.print();
        System.out.println();
            
        contacts.removeEntry("Nick");
        contacts.print();
        
    }
    
}
