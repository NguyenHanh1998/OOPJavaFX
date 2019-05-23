package sample.Model;

public class Word {
    private String word;
    private String mean;

    // Getter
    public String getWord() {
        return this.word;
    }

    public String getMean() {
        return this.mean;
    }

    // Setter 
    public void setWord(String word) {
        this.word = word;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    // Constructor
    public Word(String word, String mean) {
        this.word = word;
        this.mean = mean;
    }
}