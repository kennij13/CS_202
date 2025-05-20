package program_assignments_CS202.program_assignment2;
import java.util.*;

public class program_assignment2 {
  
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> disc = new ArrayList<ArrayList<Integer>>(); 
        //input
        
        Scanner keyboard= new Scanner(System.in);

        //disc part
        System.out.print("Enter disc size: ");
        int discSize = keyboard.nextInt(); 
        
        //read the whole disc
        for (int i = 0; i < discSize; i++) 
        {
            System.out.print("Enter the number of integers in line " + (i + 1) + ": ");
            int rowSize= keyboard.nextInt();
            ArrayList<Integer> row = new ArrayList<Integer>(); 
            //read the data into each row/line
            for (int j = 0; j < rowSize; j++) 
            {  
                System.out.print("Enter the integer: ");
                row.add(keyboard.nextInt());
            }
            disc.add(row);
            
                
         }
            
            


    


        //query part
        //read number of queries
        System.out.print("Enter the number of queries: ");
        int queryNumber= keyboard.nextInt();

        ArrayList<String> results= new ArrayList<String>(); 

        //process query and produce output 
        for (int i = 0; i < queryNumber; i++) {
                System.out.print("Enter query line number: ");
                int x = keyboard.nextInt(); 
                System.out.print("Enter query line position: ");
                int y = keyboard.nextInt(); 
                
            if (x >= 1 && x <= disc.size() && y >= 1 && y <= disc.get(x - 1).size()) {
                results.add(disc.get(x - 1).get(y - 1) + "");
            } else {
                results.add("ERROR!");
            }
        }
            

       
        

        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }

        


        keyboard.close();


    


        
    }
    
}


