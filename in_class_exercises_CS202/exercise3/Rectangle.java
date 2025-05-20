import java.util.*; 

public class Rectangle extends AbstractShape  {
   //data fields 
   private double width; 
   private double height; 

   //methods
   public Rectangle(){
     width= 0.0;
     height=0.0;
     shapeName= toString();

   }


   public double computeArea()
   {
     return width*height; 
   }

   public double computePerimeter()
   {
     return 2*(width+height);
   }

   public void readShapeData()
   {
     Scanner keyboard= new Scanner(System.in);
     System.out.print("Enter the width:");
     width= keyboard.nextDouble();
     System.out.print("Enter the height:");
     height= keyboard.nextDouble();
     keyboard.close();

   }

   public String toString()
   {
      return "Rectangle!";
   }
}


