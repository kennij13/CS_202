package in_class_exercises_CS202.exercise1;
// highArray.java
// demonstrates array class with high-level interface
////////////////////////////////////////////////////////////////
class HighArrayApp
   {
   public static void main(String[] args)
      {
      int maxSize = 50;            // array size
      HighArray arr;                // reference to array
      arr = new HighArray(maxSize); // create the array

      arr.insert(2);
      arr.insert(2);
      arr.insert(3);
      arr.insert(5);
      arr.insert(2);
      arr.insert(5);
      arr.insert(4);
      arr.insert(4);
      arr.insert(4);
      arr.insert(4); 
      arr.insert(4);
     
      arr.display();
      arr.noDups();
      arr.display();

      arr.insert(77);               // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      arr.display();                // display items

      int searchKey = 35;           // search for item
      if( arr.find(searchKey) )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.delete(00);               // delete 3 items
      arr.delete(55);
      arr.delete(99);

      arr.display();                // display items again

      System.out.println("The maximum value in the array is: " + arr.getMax());
      arr.removeMax();
      arr.display();
      }  // end main()
   }  // end class HighArrayApp

class HighArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public HighArray(int max)         // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
   //-----------------------------------------------------------
   public boolean find(long searchKey)
      {                              // find specified value
      int j;
      for(j=0; j<nElems; j++)            // for each element,
         if(a[j] == searchKey)           // found item?
            break;                       // exit loop before end
      if(j == nElems)                    // gone to end?
         return false;                   // yes, can't find it
      else
         return true;                    // no, found it
      }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j;
      for(j=0; j<nElems; j++)        // look for it
         if( value == a[j] )
            break;
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move higher ones down
            a[k] = a[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
   //-----------------------------------------------------------
   //Q1- part a
   public long getMax()
   {
     if (nElems == 0) {
        return -1; 
     } else {
        long max = a[0];
        for (int i = 0; i < nElems; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
     }
   }
   //Q2- part b
   public long removeMax(){
      long result = getMax();
      delete(result);
      return result; 

   }

   //Q3- part c
   public void noDups(){
      //take one value, a[i], at a time from the array
      for (int i = 0; i < nElems; i++) {
         //check the other elements of the array if there are duplicated values, remove them
         for (int j = i+1; j < nElems; j++) {
            if (a[j]==a[i]) {
               for (int k = j ; k < nElems; k++) { //delete dups found
                  a[k]=a[k+1];
               
                  
                  
               }
               nElems--;
               j--;
               
               
            }
            
         }

         
      }


      
   }


   }  // end class HighArray
////////////////////////////////////////////////////////////////
