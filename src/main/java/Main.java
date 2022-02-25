import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("LittleWoman.txt");
        Scanner reader = new Scanner(file);
        HashTable hashTable1 = new HashTable(500);
        while(reader.hasNext()){
            Word word = new Word(reader.next().toLowerCase());
            hashTable1.put(word);
        }
    }
}
