package in_class_exercises_CS202.exercise7;
import java.io.*;

public class CircApp
   {
   public static void main(String[] args) throws IOException
      {
      int j, nPlayers, nSkips, startNo;
      CircList theList = new CircList();  // make list

      putText("Enter the number of players: ");
      nPlayers = getInt();

      for(j=nPlayers; j>0; j--)           // number 10, 20, ...
         theList.insert(j);

      putText("Players: ");
      theList.display();

      putText("Enter the the number of spaces to skip: ");
      nSkips = getInt();

      putText("Enter the the starting player's number: ");
      startNo = getInt();

theList.find(3);
      // Add your code here
      //step 1: find the starting player
      theList.find(startNo);
      //step 2: keep passing potato until only 1 player left
      while (theList.getSize()> 1) {
        //step 3: start passing the potato n amount of times for each round
         for (int i = 0; i < nSkips; i++) 
        {
            theList.step();
        }
        //step 4: eliminate the player
        theList.peek().display();
        theList.delete();
        //theList.display();

      }
      //step 5: display the winner
      System.out.print("The winner is: ");
      theList.display(); 
      


      }  // end main()
// -------------------------------------------------------------
   public static void putText(String s)
      {
      System.out.print(s);
      System.out.flush();
      }
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
      return s.charAt(0);
      }

//-------------------------------------------------------------
   public static int getInt() throws IOException
      {
      String s = getString();
      return Integer.parseInt(s);
      }
// -------------------------------------------------------------
   }  // end class CircApp
////////////////////////////////////////////////////////////////
class Link
   {
   public int iData;              // data item (key)
   public Link next;              // next link in list
// -------------------------------------------------------------
   public Link(int id)            // constructor
      { iData = id; }
// -------------------------------------------------------------
   public void display()      // display ourself
      { System.out.print(iData + " "); }
   }  // end class Link
////////////////////////////////////////////////////////////////
class CircList
   {
   private Link current;          // ref to current link
   private int count;             // # of links on list
// -------------------------------------------------------------
   public CircList()              // constructor
      {
      count = 0;                  // no links on list yet
      current = null;
      }
// -------------------------------------------------------------
   public boolean isEmpty()
      { return count==0; }
// -------------------------------------------------------------
   public int getSize()
      { return count; }
// -------------------------------------------------------------
   public void insert(int id)     // insert after current link
      {                           // make new link
      Link newLink = new Link(id);
      if(count == 0)              // if first one
         {
         current = newLink;       // current points to it
         current.next = current;  // next one is us
         }
      else
         {
         newLink.next = current.next; // downstream of new link
         current.next = newLink;      // upstream of new link
         }
      count++;                    // one more link
      }
// -------------------------------------------------------------
   public Link delete()        // delete link following currrent
      {
      Link tempLink;
      switch(count)
         {
         case 0:               // current is already null
            tempLink = current;
            break;
         case 1:               // delete ourself
            tempLink = current;
            current = null;
            count--;
            break;
         default:              // delete the next one
            tempLink = current.next;
            current.next = tempLink.next;
            count--;
            break;
         }
      return tempLink;
      }
// -------------------------------------------------------------
   public Link find(int key)      // find link with given key
      {                           //    at one past current
      int getHome = count;
      while(getHome > 0)          // while not back to
         {                        // beginning
         if(current.next.iData == key)  // found it?
            return current.next;        // return next one
         else                     // not found
            {                     // go to next link
            current = current.next;
            getHome--;            // one item closer to home
            }
         }
      return null;                // can't find it
      }
// -------------------------------------------------------------
   public Link delete(int key)    // delete link with given key
      {
      Link nextLink = find(key);        // find it
      if(nextLink != null)              // if found,
         {
         current.next = nextLink.next;  // delete it
         count--;
         }
      return nextLink;            // return null or link
      }
// -------------------------------------------------------------
   public void display()      // display the list
      {
      for(int j=0; j<count; j++)
         {
         current.next.display();
         current = current.next;
         }
      System.out.println("");
      }
// -------------------------------------------------------------
   public void step()
      {
      if(count != 0)
         current = current.next;  // go to next link
      }
// -------------------------------------------------------------
   public Link peek()
      { return current.next; }
// -------------------------------------------------------------
   }  // end class CurcList
/////////////////////////////////////////////////////////////