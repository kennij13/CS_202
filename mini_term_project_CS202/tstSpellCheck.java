package mini_term_project_CS202; 
import java.io.*;
import java.util.*;
import java.io.IOException;

public class tstSpellCheck {
    //TST- store and search words
    public static class TST {
        private class Node { // represents each char node in the TST
            char c; //store char in this node
            Node left, mid, right; //node's children
            boolean end; //check if this node is the end of a real word

            Node(char c) { //initialize node with char
                this.c = c;
            }
        }

        private Node root; 

        
        public boolean contains(String s) { //check if word exists in TST
            return contains(root, s, 0);
        }

        private boolean contains(Node x, String s, int d) {
            if (x == null) return false; // if node is null- word not found
            char c = s.charAt(d); // current char in word
            if (c < x.c) return contains(x.left, s, d); //search left
            else if (c > x.c) return contains(x.right, s, d);//search right
            else if (d < s.length() - 1) return contains(x.mid, s, d + 1);//move down
            else return x.end; //if final character- return true if it's end of word
        }

        public void add(String s) { //add word into TST
            root = add(root, s, 0);
        }

        private Node add(Node x, String s, int d) {
            char c = s.charAt(d);
            if (x == null) x = new Node(c); //if no node- create new node
            if (c < x.c) x.left = add(x.left, s, d); //insert to left subtree
            else if (c > x.c) x.right = add(x.right, s, d); //insert to right subtree
            else if (d < s.length() - 1) x.mid = add(x.mid, s, d + 1); //move to middle child
            else x.end = true; //end of word
            return x; //return node
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);

        // Hardcoded dictionary file name
        String dictionaryFileName = "C:\\Users\\Kenne\\VS_Code\\mini_term_project_CS202\\dictionary.txt";  
        TST dictionary = new TST(); //instantiate TST

        //open and read dict file
        Scanner dictStream = null;
        try {
            dictStream = new Scanner(new File(dictionaryFileName));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening the dictionary file.");
            System.exit(1);
        }
        //add each word from dict to TST
        while (dictStream.hasNext()) {
            dictionary.add(dictStream.next().toLowerCase());
        }
        dictStream.close();

        // ask for text file to be spell checked
        System.out.print("Enter the text file name to check spelling: ");
        String textFileName = keyboard.next();
        BufferedReader textReader = null;

        //open text file
        try {
            textReader = new BufferedReader(new FileReader(textFileName));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening the text file.");
            System.exit(1);
        }

        // read and process the text line by line
        String line;
        int lineNumber = 1;

        while ((line = textReader.readLine()) != null) {//while there are more lines
            String[] words = line.split("\\s+"); //parse each line
            ArrayList<String> misspelled = new ArrayList<>();//list of mispelled words on the line

            for (String word : words) {
                 //strip any punctuation- convert to lowercase
                String strippedWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                if (!strippedWord.isEmpty() && !dictionary.contains(strippedWord)) {
                    misspelled.add(strippedWord);//if word not found- add to misspelled list
                }
            }

            if (!misspelled.isEmpty()) {
                //if misspelled words on line- print them out 
                System.out.println("Line " + lineNumber + ": " + misspelled.size() +
                        " misspelled word" + (misspelled.size() > 1 ? "s" : "") + ": " +
                        String.join(", ", misspelled));
            }

            lineNumber++;// move to next line
        }

        textReader.close();
        keyboard.close();
        
    }
}
