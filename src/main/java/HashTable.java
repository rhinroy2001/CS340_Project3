import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class HashTable{
    int slots;
    int key;
    LinkedList<String> bucket = new LinkedList<String>();
    LinkedList[] hashTable;

    public HashTable(int slots){
        this.slots = slots;
        LinkedList[] hashTable = new LinkedList[slots];
        for(int i = 0; i < slots; i++){
            hashTable[i] = bucket;
        }
    }

    public void put( Word word){
        //LinkedList<String> temp = new LinkedList<String>();
        boolean found = false;
        ListIterator<String> wordIterator = bucket.listIterator();
        for(int i = 0; i < slots; i++){
            bucket = hashTable[i];
            while(bucket.listIterator().hasNext()){
                if(bucket.listIterator().equals(word)){
                    word.increaseOccurrences();
                    word.steps = bucket.indexOf(word);
                    found = true;
                }
            }
        }
        if(found == false){
            key = Math.abs(word.hashCode()%slots);
            hashTable[key].add(word);
            word.setSteps(hashTable[key].indexOf(word));
        }
    }

}
