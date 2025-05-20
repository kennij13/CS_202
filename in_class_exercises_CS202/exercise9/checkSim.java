import java.io.*;                 // for I/O
////////////////////////////////////////////////////////////////
class Queue
   {
   private int maxSize;
   private long[] queArray;
   private int front;
   private int rear;
   private int nItems;
//--------------------------------------------------------------
   public Queue(int s)          // constructor
      {
      maxSize = s;
      queArray = new long[maxSize];
      front = 0;
      rear = -1;
      nItems = 0;
      }
//--------------------------------------------------------------
   public void insert(long j)   // put item at rear of queue
      {
      if(rear == maxSize-1)         // deal with wraparound
         rear = -1;
      queArray[++rear] = j;         // increment rear and insert
      nItems++;                     // one more item
      }
//--------------------------------------------------------------
   public long remove()         // take item from front of queue
      {
      long temp = queArray[front++]; // get value and incr front
      if(front == maxSize)           // deal with wraparound
         front = 0;
      nItems--;                      // one less item
      return temp;
      }
//--------------------------------------------------------------
   public void display()       // display queue contents
      {
      if( isEmpty() == false )
         {
         if(front <= rear)
            for(int j=front; j<=rear; j++)
               System.out.print( queArray[j] + " ");
         else
            {
            for(int j=front; j<maxSize; j++)
               System.out.print( queArray[j] + " ");
            for(int j=0; j<=rear; j++)
               System.out.print( queArray[j] + " ");
            }
         }
      System.out.println("");
      }  // end display()
//--------------------------------------------------------------
   public boolean isEmpty()    // true if queue is empty
      { return (nItems==0); }
//--------------------------------------------------------------
   public boolean isFull()     // true if queue is full
      { return (nItems==maxSize); }
//--------------------------------------------------------------
   public int getN()           // number of items in queue
      {
      return nItems;
      }
//--------------------------------------------------------------
   }  // end class Queue
////////////////////////////////////////////////////////////////
class Checker
   {
   private int myNumber;
   private Queue myQueue;
   private int myTimer;
//--------------------------------------------------------------
   public Checker(int chn, int maxl)  // constructor
      {
      myNumber = chn + 1;
      myQueue = new Queue(maxl);
      myTimer = (int)(java.lang.Math.random() * 6) + 2;
      }
//--------------------------------------------------------------
   public void display()
      {
      System.out.print("Checker " + myNumber + ": ");
      myQueue.display();
      }
//--------------------------------------------------------------
   public void insert(int custN)
      {
      if( !myQueue.isFull() )
         myQueue.insert(custN);    // put customer # in queue                                 // start our timer
      }
//--------------------------------------------------------------
   public void tick()
      {
      if(--myTimer == 0)           // if timed out
         {
         if( !myQueue.isEmpty() )  // remove front customer
            myQueue.remove();      // reset timer
         myTimer = (int)(java.lang.Math.random() * 6) + 2;

         }
      }
//--------------------------------------------------------------
   public int getLineLength()
      {
      return myQueue.getN();
      }
//--------------------------------------------------------------
   }  // end class Checker
////////////////////////////////////////////////////////////////
class Store
   {
   private int maxCheckers;  // maximum # of Checkers
   private int maxLength;    // maximum # of customers per line
   private Checker[] checkers; // array of Checkers
   private long elapsedTime;
//--------------------------------------------------------------
   public Store(int maxCh, int maxL)  // constructor
      {
      maxCheckers = maxCh;
      maxLength = maxL;
      elapsedTime = 0;
      checkers = new Checker[maxCh];

      for(int j=0; j<maxCheckers; j++)         // put Checkers
         checkers[j] = new Checker(j, maxLength); //    in array
      }
//--------------------------------------------------------------
   void display()             // display all the checkers
      {
      for(int j=0; j<maxCheckers; j++)
         {
         checkers[j].display();
     //    System.out.println("");
         }
      }
//--------------------------------------------------------------
   public int getShortestLine()
      {
      int j=0;
      int minLine = checkers[0].getLineLength();
      int minIndex = 0;
      for(j=1; j<maxCheckers; j++)
         {
         if( minLine > checkers[j].getLineLength() )
            {
            minLine = checkers[j].getLineLength();
            minIndex = j;
            }
         }
      return minIndex;
      }
//--------------------------------------------------------------
   public void newCustomer() // insert customer in shortest line
      {
      int custoNumber = (int)(java.lang.Math.random() * 89) + 10;
      int lineNumber = getShortestLine();
      checkers[lineNumber].insert(custoNumber);
      }
//--------------------------------------------------------------
   public void masterTick()  // time tick
      {                      // pass on to all checkers
      for(int j=0; j<maxCheckers; j++)
         checkers[j].tick();
      }
//--------------------------------------------------------------
   }  // end class Store
////////////////////////////////////////////////////////////////
class SimApp
   {
   public static void main(String[] args) throws IOException
      {
      int nCheckers = 3;  // number of checkers
      int maxLL = 12;     // maximum line length
      Store theStore = new Store(nCheckers, maxLL);

      while(true)
         {
         System.out.print("Enter first letter of ");
         System.out.print("show, tick, enter: ");
         int choice = getChar();
         switch(choice)
            {
            case 's':
               theStore.display();
               break;
            case 't':
               theStore.masterTick();
               theStore.display();
               break;
            case 'e':
               theStore.newCustomer();
               theStore.display();
               break;
            default:
               System.out.print("Invalid entry\n");
            }  // end switch
         }  // end while
      }  // end main()
// -------------------------------------------------------------
   public static String getString() throws IOException
      {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      String s = br.readLine();
      return s;
      }
// -------------------------------------------------------------
   public static char getChar() throws IOException
      {
      String s = getString();
      if(s.length() == 0)
         return '#' ;
      else
         return s.charAt(0);
      }
//-------------------------------------------------------------
   public static int getInt() throws IOException
      {
      String s = getString();
      return Integer.parseInt(s);
      }
// -------------------------------------------------------------
   }  // end class SimApp
////////////////////////////////////////////////////////////////

