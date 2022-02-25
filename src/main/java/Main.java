import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
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
        System.out.println();
    }
}
