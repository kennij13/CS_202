import java.util.*;

public class Circle extends AbstractShape {
    //data fields 
   private double radius; 
   

   //methods
   public Circle(){
     radius= 0.0;
     shapeName= toString();

   }


   public double computeArea()
   {
     return radius * radius * 3.14; 
   }

   public double computePerimeter()
   {
     return 2* radius * 3.14;
   }

   public void readShapeData()
   {
     Scanner keyboard= new Scanner(System.in);
     System.out.print("Enter the radius:");
     radius= keyboard.nextDouble();
     keyboard.close();

   }

   public String toString()
   {
      return "Circle!";
   }

    
}
