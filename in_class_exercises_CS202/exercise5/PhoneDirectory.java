package in_class_exercises_CS202.exercise5;
/**
 * This is an implementation of the PhoneDirectoryInterface
 * that uses an ArrayList to store the data.
 */
import java.util.ArrayList;

public class PhoneDirectory {

    // Data fields
    /** The ArrayList to contain the directory data */
    private ArrayList<DirectoryEntry> theDirectory = new ArrayList<>();

    //methods
    public String addOrChangeEntry(String aName, String newNumber){
        //find if aName is in the directory
        for ( int i= 0; i < theDirectory.size(); i++) 
        {
           if (theDirectory.get(i).getName().equals(aName)) {
               //aName is found, update phone number
               String temp = theDirectory.get(i).getNumber();
               theDirectory.get(i).setNumber(newNumber);
               return temp;
            
           }   
        }
        //aName is not found, add aName/newNumber as a new entry in the Directory
        theDirectory.add(new DirectoryEntry(aName, newNumber));
        return null;
        
    }

    public DirectoryEntry removeEntry(String aName){
        //find if aName is in the directory 
        for (int i = 0; i < theDirectory.size(); i++) 
        {
            if (theDirectory.get(i).getName().equals(aName)) {
                //if aName is found, delete the entry 
                DirectoryEntry temp = theDirectory.get(i);
                theDirectory.remove(i);
                return temp;
            }
        }
        //aName is not found
        return null; 

    }

    public void print(){
        for (int i = 0; i < theDirectory.size(); i++) 
        {
            System.out.println(theDirectory.get(i).getName()+ " "+ theDirectory.get(i).getNumber());
            
        }
    }



   
}
