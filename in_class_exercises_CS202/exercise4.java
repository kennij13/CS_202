package in_class_exercises_CS202;
import java.util.*; 

public class exercise4 {
    public static void main(String[] args) {
        //input
        ArrayList<Integer>numbers = new ArrayList<Integer>();
        Scanner keyboard= new Scanner(System.in);
        System.out.print("Enter a sequence of integers (ends with 0):");
        int temp= keyboard.nextInt();
        while (temp != 0) 
        {
           numbers.add(temp);
           temp= keyboard.nextInt();
        }  

        //System.out.println(numbers);
        //Testing other functions
        System.out.println("The max value is: "+ max(numbers));
        System.out.println("The sum of all numbers is : "+ sum(numbers));
        System.out.println("The list without any duplicated values is: "+ nodup(numbers));
        keyboard.close(); 
        

        
    }
    
        //Q1
    public static int max(ArrayList<Integer>list){
       int max= list.get(0); 
       for (int i = 0; i < list.size(); i++) 
       {
         if (max < list.get(i)) {
             max= list.get(i);  
         }
        
       }
       return max; 
    }

        //Q2

        public static int sum(ArrayList<Integer>list){
           int sum= 0; 
           for (int i = 0; i < list.size(); i++) {
              sum+= list.get(i);
           }
           return sum; 
        }


        
        //Q3

        public static ArrayList<Integer> nodup(ArrayList<Integer>list){
            ArrayList<Integer>results= new ArrayList<Integer>(); 
            for (int i = 0; i < list.size(); i++) //getting through each element of the original list
            { 
                if (results.indexOf(list.get(i))== -1 ) { //check if the element is in the result list array 
                    results.add(list.get(i)); 
                }
            }
            return results; 
        }
    
}
