import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/LittleWomen.txt");
        Scanner reader = new Scanner(file);
        HashTable hashTable500 = new HashTable(500);
        HashTable hashTable1000 = new HashTable(1000);
        HashTable hashTable2000 = new HashTable(2000);
        HashTable hashTable5000 = new HashTable(5000);
        HashTable hashTable10000 = new HashTable(10000);
        while(reader.hasNext()){
            String word = reader.next().toLowerCase();
            hashTable500.put(word);
            hashTable1000.put(word);
            hashTable2000.put(word);
            hashTable5000.put(word);
            hashTable10000.put(word);
        }
        System.out.println("");
        hashTable500.writeToCSV();
 //       hashTable1000.writeToCSV();
//        hashTable2000.writeToCSV();
 //         hashTable5000.writeToCSV();
//        hashTable10000.writeToCSV();
    }
}
