package mini_term_project_CS202;
import java.io.*;
import java.util.*;

public class arrayListSpellCheck {
    //binary search- search for key in sorted ArrayList<String>
    public static int binarySearch(ArrayList<String> list, String key) {
        int lo = 0, hi = list.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; //find mid index
            int cmp = key.compareTo(list.get(mid));//compare key vs mid index
            if (cmp < 0) hi = mid - 1; //search left side
            else if (cmp > 0) lo = mid + 1;  //search right side
            else return mid; //found key
        }
        return -1; //key not found
    }

    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);

        // hardcoded dictionary filename
        String dictionaryFileName = "C:\\Users\\Kenne\\VS_Code\\mini_term_project_CS202\\dictionary.txt";  // <-- set here
        ArrayList<String> dictionary = new ArrayList<>(); // arrayList for dictionary words

        //read dictionary file
        Scanner dictStream = null;
        try {
            dictStream = new Scanner(new File(dictionaryFileName));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening the dictionary file.");
            System.exit(1);
        }

        //read each word from dict file- convert to lowercase and then add to list
        while (dictStream.hasNext()) {
            dictionary.add(dictStream.next().toLowerCase());
        }
        dictStream.close();
        //sort dict for binary search
        Collections.sort(dictionary);

        // ask for text file to be spell checked
        System.out.print("Enter the text file name to check spelling: ");
        String textFileName = keyboard.next();
        BufferedReader textReader = null;

        try {
            textReader = new BufferedReader(new FileReader(textFileName));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening the text file.");
            System.exit(1);
        }

        // read text file line by line
        String line;
        int lineNumber = 1;

        while ((line = textReader.readLine()) != null) { // while there are more lines
            String[] words = line.split("\\s+");   //parse each line 
            ArrayList<String> misspelled = new ArrayList<>(); //list for misspelled words on the line 
            
        
            for (String word : words) {
                //strip any punctuation- convert to lowercase
                String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                if (!cleanWord.isEmpty() && binarySearch(dictionary, cleanWord) == -1) {
                    misspelled.add(cleanWord); //if word not found- add to misspelled list
                }
            }

            if (!misspelled.isEmpty()) { 
                //if misspelled words on line- print them out 
                System.out.println("Line " + lineNumber + ": " + misspelled.size() +
                        " misspelled word" + (misspelled.size() > 1 ? "s" : "") + ": " +
                        String.join(", ", misspelled));
            }

            lineNumber++; //move to next line
        }

        textReader.close();
        keyboard.close();

    }
    
}

    


    
