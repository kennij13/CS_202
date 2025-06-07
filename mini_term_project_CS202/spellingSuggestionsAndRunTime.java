package mini_term_project_CS202;
import java.io.*;
import java.util.*;

public class spellingSuggestionsAndRunTime{
//binary search- search for key in sorted ArrayList<String>
public static boolean binarySearch(ArrayList<String> list, String key) {
    int lo = 0, hi = list.size() - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2; //find mid index
        int cmp = key.compareTo(list.get(mid));//compare key vs mid index
        if (cmp < 0) hi = mid - 1;//search left side
        else if (cmp > 0) lo = mid + 1;//search right side
        else return true; //found key 
    }
    return false; //key not found
}

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
        // hardcoded dictionary filename
        String dictFile = "C:\\Users\\Kenne\\VS_Code\\mini_term_project_CS202\\dictionary.txt"; 
        //ask for text file to be checked
        System.out.print("Enter the text file name to check spelling: ");
        String inputFile = keyboard.next(); 

        //start of array comparison
        System.out.println("--ArrayList + Binary Search Comparison--");

        long memBeforeList = usedMemory();//memory usage before
        long startList = System.currentTimeMillis();//start time

        //read each word from dict file- convert to lowercase and then add to list
        Scanner dictScanner = new Scanner(new File(dictFile));
        ArrayList<String> list = new ArrayList<>();
        while (dictScanner.hasNext()) {
            list.add(dictScanner.next().toLowerCase());
        }
        dictScanner.close();
        //sort dict for binary search
        Collections.sort(list);

        //check file for misspellings
        Scanner inputScanner = new Scanner(new File(inputFile));
        int misspelledList = 0;
        
        while (inputScanner.hasNextLine()) {
            String line = inputScanner.nextLine();
            String[] words = line.split("\\s+"); // parse the file 
            for (String word : words) {
                word = word.replaceAll("[^a-zA-Z]", "").toLowerCase(); //strip punctuation
                if (word.length() == 0) continue; //skip empty
                if (!binarySearch(list, word)) {
                    misspelledList++;
                    System.out.println("Misspelled word: " + word + " : Suggestions: " + suggest(word, list));
                }
            }
        }
        inputScanner.close();

        long endList = System.currentTimeMillis();
        long memAfterList = usedMemory();
        System.out.println("Misspelled Words: " + misspelledList);
        System.out.println("Time: " + (endList - startList) + " ms");
        System.out.println("Memory: " + (memAfterList - memBeforeList) / 1024 + " KB"); //compute memory used

        // start tst comparison 
        System.out.println("\n--TST Comparison--");

        long memBeforeTST = usedMemory();
        long startTST = System.currentTimeMillis();

        Scanner dictScannerTST = new Scanner(new File(dictFile));
        TST tst = new TST();
        ArrayList<String> tstWords = new ArrayList<>(); //store words for suggestions
        while (dictScannerTST.hasNext()) {
            String word = dictScannerTST.next().toLowerCase();
            tst.add(word);
            tstWords.add(word);
        }
        dictScannerTST.close();

        //check for misspellings
        Scanner inputScannerTST = new Scanner(new File(inputFile));
        int misspelledTST = 0;
        while (inputScannerTST.hasNextLine()) {
            String line = inputScannerTST.nextLine();
            String[] words = line.split("\\s+");//parse words
            for (String word : words) {
                word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();//strip punctuation
                if (word.length() == 0) continue;//skip empty
                if (!tst.contains(word)) {
                    misspelledTST++;
                    System.out.println("Misspelled word: " + word + " : Suggestions: " + suggest(word, tstWords));
                }
            }
        }
        inputScannerTST.close();

        long endTST = System.currentTimeMillis();
        long memAfterTST = usedMemory();

        System.out.println("Misspelled Words: " + misspelledTST);
        System.out.println("Time: " + (endTST - startTST) + " ms");
        System.out.println("Memory: " + (memAfterTST - memBeforeTST) / 1024 + " KB");
        keyboard.close();
    }

    

    //store memory usage 
    public static long usedMemory() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();// run garbage collector 
        return runtime.totalMemory() - runtime.freeMemory();//compute total storage used
    }
    
    //suggestions based on editing distance number
    public static List<String> suggest(String word, List<String> dict) {//rank words by edit distance
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            int da = levenshtein(word, a);
            int db = levenshtein(word, b);
            return Integer.compare(da, db);
        });
        pq.addAll(dict);//add all dict words

        List<String> suggestions = new ArrayList<>();
        for (int i = 0; i < 7 && !pq.isEmpty(); i++) {
            suggestions.add(pq.poll());// 3 closest matches based on sub, insert, and deletion 
        }
        return suggestions;
    }

    //editing distance number 
    public static int levenshtein(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0) dp[i][j] = j; //first string
                else if (j == 0) dp[i][j] = i; //second string 
                else if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1]; //chars match
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1])); //substiution, insertion and deletion
            }
        }
        return dp[a.length()][b.length()]; //return final editing distance 
        
    }
   
}   