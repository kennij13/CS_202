package in_class_exercises_CS202.exercise11;

import java.io.*;
import java.util.*;               // for Stack class
class TreeApp
   {
   public static void main(String[] args) throws IOException
      {
      int value;

      System.out.print("Enter character string for tree: ");
      String str = getString();
      Tree theTree = new Tree(str);

      while(true)
         {
         System.out.print("Enter first letter of ");
         System.out.print("show or traverse: ");
         int choice = getChar();
         switch(choice)
            {
            case 's':
               theTree.displayTree();
               break;
            case 't':
               System.out.print("Enter type 1, 2 or 3: ");
               value = getInt();
               theTree.traverse(value);
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
      return s.charAt(0);
      }

//-------------------------------------------------------------
   public static int getInt() throws IOException
      {
      String s = getString();
      return Integer.parseInt(s);
      }
// -------------------------------------------------------------
   }  // end class TreeApp

////////////////////////////////////////////////////////////////
class Node
   {
   public char keyChar;           // key
   public Node leftChild;         // this node's left child
   public Node rightChild;        // this node's right child
// -------------------------------------------------------------
   Node(char kch)                 // constructor
      { keyChar = kch; }
// -------------------------------------------------------------
   public void display()          // display ourself
      { System.out.print("(" + keyChar + ")"); }
// -------------------------------------------------------------
   }  // end class Node
////////////////////////////////////////////////////////////////
class Tree
   {
   private Node root;               // first node of tree
   private String strBuild;         // string used to build tree
   private int maxNodes;            // total number of nodes
// -------------------------------------------------------------
   public Tree(String s)            // constructor
      {
      strBuild = s;
      maxNodes = s.length();
      char ch = strBuild.charAt(0); // get first character
      root = new Node(ch);          // make the root
      recBuild(root, 1);            // create root's children
      }
// -------------------------------------------------------------
   public void recBuild(Node thisNode, int ourNumber)
      {
         //build your tree here!
         //find the left child
         int leftIndex = ourNumber*2; 
         if (leftIndex > strBuild.length()) {
            return;
         } else {
            char c = strBuild.charAt(leftIndex - 1);
            //initialize the left node and attach as left child for current subtree root
            Node leftNode = new Node(c);
            thisNode.leftChild = leftNode; 
            recBuild(leftNode, leftIndex);
            
         }
         
         int rightIndex = ourNumber*2 + 1; 
         if (rightIndex > strBuild.length()) {
            return;
         } else {
            char c = strBuild.charAt(rightIndex + 1);
            //initialize the left node and attach as left child for current subtree root
            Node rightNode = new Node(c);
            thisNode.rightChild = rightNode; 
            recBuild(rightNode, leftIndex);
            
         }






      }
// -------------------------------------------------------------
   public void traverse(int traverseType)
      {
      switch(traverseType)
         {
         case 1: System.out.print("\nPreorder traversal: ");
                 preOrder(root);
                 break;
         case 2: System.out.print("\nInorder traversal:  ");
                 inOrder(root);
                 break;
         case 3: System.out.print("\nPostorder traversal: ");
                 postOrder(root);
                 break;
         }
      System.out.println();
      }
// -------------------------------------------------------------
   private void preOrder(Node localRoot)
      {
      if(localRoot != null)
         {
         localRoot.display();
         preOrder(localRoot.leftChild);
         preOrder(localRoot.rightChild);
         }
      }
// -------------------------------------------------------------
   private void inOrder(Node localRoot)
      {
      if(localRoot != null)
         {
         inOrder(localRoot.leftChild);
         localRoot.display();
         inOrder(localRoot.rightChild);
         }
      }
// -------------------------------------------------------------
   private void postOrder(Node localRoot)
      {
      if(localRoot != null)
         {
         postOrder(localRoot.leftChild);
         postOrder(localRoot.rightChild);
         localRoot.display();
         }
      }
// -------------------------------------------------------------
   public void displayTree()
      {
      Stack globalStack = new Stack();
      globalStack.push(root);
      int nBlanks = 32;
      boolean isRowEmpty = false;
      System.out.println(
      "......................................................");
      while(isRowEmpty==false)
         {
         Stack localStack = new Stack();
         isRowEmpty = true;

         for(int j=0; j<nBlanks; j++)
            System.out.print(' ');

         while(globalStack.isEmpty()==false)
            {
            Node temp = (Node)globalStack.pop();
            if(temp != null)
               {
               temp.display();
               localStack.push(temp.leftChild);
               localStack.push(temp.rightChild);

               if(temp.leftChild != null ||
                                   temp.rightChild != null)
                  isRowEmpty = false;
               }
            else
               {
               System.out.print("---");
               localStack.push(null);
               localStack.push(null);
               }
            for(int j=0; j<nBlanks*2-3; j++)
               System.out.print(' ');
            }  // end while globalStack not empty
         System.out.println();
         nBlanks /= 2;
         while(localStack.isEmpty()==false)
            globalStack.push( localStack.pop() );
         }  // end while isRowEmpty is false
      System.out.println(
      "......................................................");
      }  // end displayTree()
// -------------------------------------------------------------
   }  // end class Tree

////////////////////////////////////////////////////////////////
