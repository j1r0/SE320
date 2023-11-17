/* 
 * By: Jim Pamplona
 * 
 * 2. Write a program that reads words from a text file and displays all 
 * the nonduplicate words in ascending order. (Use a TreeSet to hold the words)
 */

import java.io.*;
import java.util.TreeSet;
import java.util.ArrayList;

public class TreeSetFileReader {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("words.txt");
        
        System.out.println(toTreeSet(readFile(file)));
    }

    //reads the words.txt file
    public static ArrayList<String> readFile(File file) throws FileNotFoundException {
        FileReader reader;
        BufferedReader bReader;
        ArrayList<String> words = new ArrayList<>();
        try {
            reader = new FileReader(file);
            bReader = new BufferedReader(reader);

            while (bReader.ready()){
                words.add(bReader.readLine());
            }
            System.out.println(words);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            throw e;
        } catch (IOException e1){
        }
        return words;
    }

    //converts arraylist into treeset. not necessary as it couldve been in the read file method, but separation of concerns :D
    public static TreeSet<String> toTreeSet(ArrayList<String> words){
        TreeSet<String> wordsTreeSet = new TreeSet<>();
        wordsTreeSet.addAll(words);
        return wordsTreeSet;
    }
}
