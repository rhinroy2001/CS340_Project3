import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashTable {
    int slots;
    LinkedList[] hashTable;

    public HashTable(int slots){
        this.slots = slots;
        hashTable = new LinkedList[slots];
        for(int i = 0; i < slots; i++){
            hashTable[i] = new LinkedList<Word>();
        }
    }

    public void put(String value){
        Word word = new Word(value);
        int key = Math.abs(word.getValue().hashCode())%slots;
        boolean found = false;
        LinkedList<Word> bucket = hashTable[key];
        ListIterator<Word> bucketIterator = bucket.listIterator();
        while(bucketIterator.hasNext()){
            Word w = bucketIterator.next();
            if(word.getValue().equals(w.getValue())) {
                w.increaseOccurrences();
                found = true;
            }
        }
        if(!found){
            word.setSteps(bucket.size() + 1);
            word.increaseOccurrences();
            hashTable[key].add(word);
        }
    }

    public void writeToCSV() throws IOException {
        File outputfile = new File("src/main/resources/LittleWomenOutput.csv");
        PrintWriter pw = new PrintWriter(outputfile);
        List<String[]> dataLines = new ArrayList<>();
        for(int i = 0; i < slots; i++){
            LinkedList<Word> bucket = hashTable[i];
            ListIterator<Word> bucketIterator = bucket.listIterator();
            while(bucketIterator.hasNext()){
                Word w = bucketIterator.next();
                dataLines.add(new String[] {w.getValue(), toString(w.getOccurrences()), toString(w.getSteps() * w.getOccurrences())});
            }
        }
        dataLines.stream().map(this::convertToCSV).forEach(pw::println);
    }

    public String toString(int num){
        return num + "";
    }

    public String convertToCSV(String[] data){
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    public String escapeSpecialCharacters(String data){
        String escapedData = data.replaceAll("\\R", " ");
        if(data.contains(",") || data.contains("\"") || data.contains("'")){
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    public int myHashCode(String w){
        int sum = 0;
        int hash = 0;
        char[] ch = new char[w.length()];
        for(int i = 0; i < w.length(); i++){
            ch[i] = w.charAt(i);
            sum = (int) ch[i] + sum;
            hash = (hash ^ 2) - (sum % 7) + hash * 1447;
        }
        return hash;

    }


}
