import java.util.Objects;

public class Word {
    String value;
    int occurrences = 0;
    int steps = 0;

    public Word(String word){
        this.value = word;
    }

    public String getValue(){
        return value + ",";
    }

    public int getOccurrences(){
        return occurrences;
    }

    public int getSteps(){
        return steps;
    }

    public void increaseOccurrences(){
        occurrences++;
    }

    public void setSteps(int steps){
        this.steps = steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(value, word1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
