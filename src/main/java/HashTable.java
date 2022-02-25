import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class HashTable implements Iterable<Word>{
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
        int key = Math.abs(word.hashCode()%slots);
        boolean found = false;
        LinkedList<Word> bucket = hashTable[key];
        ListIterator<Word> bucketIterator = bucket.listIterator();
        while(bucketIterator.hasNext()){
            Word w = bucketIterator.next();
            if(word.equals(w)) {
                w.increaseOccurrences();
                found = true;
            }
        }
        if(!found){
            word.setSteps(bucket.size());
            word.increaseOccurrences();
            hashTable[key].add(word);
        }
    }

    @Override
    public Iterator<Word> iterator() {
        return null;
    }
}
