public class Word {
    String word;
    int occurrences;
    int steps;

    public Word(String word){
        this.word = word;
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

}
